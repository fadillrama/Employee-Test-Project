package com.employeetest.EmployeeTest.service;

import com.employeetest.EmployeeTest.component.JwtManager;
import com.employeetest.EmployeeTest.dto.response.*;
import com.employeetest.EmployeeTest.dto.user.OneUserDTO;
import com.employeetest.EmployeeTest.dto.user.UpsertUserDTO;
import com.employeetest.EmployeeTest.dto.user.UserDTO;
import com.employeetest.EmployeeTest.dto.user.UserRowDTO;
import com.employeetest.EmployeeTest.entity.User;
import com.employeetest.EmployeeTest.repository.JobRepository;
import com.employeetest.EmployeeTest.repository.UserDetailRepository;
import com.employeetest.EmployeeTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    public JwtManager jwtManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private JobRepository jobRepository;

    public UserRowDTO getUserRow(){
        var users = userRepository.getRow();
        for(var user : users){
            user.setDetail(userDetailRepository.getDetailById(user.getId()));
            user.setJobs(jobRepository.getJobById(user.getId()));
        }

        return new UserRowDTO(true, users);
    }

    public OneUserDTO getOneUser(Long id){
        var user = userRepository.findById(id).get();
        var detail = userDetailRepository.getDetailById(id);
        var jobs = jobRepository.getJobById(id);

        var entity = new UserDTO(
                id,
                user.getUsername(),
                detail,
                jobs,
                user.getCreatedBy(),
                user.getCreatedAt(),
                user.getUpdatedBy(),
                user.getUpdatedAt(),
                user.getDeletedBy(),
                user.getDeletedAt()
        );
        return new OneUserDTO(true, entity);
    }

    public Object saveUser(String authorization, UpsertUserDTO dto){
        var token = authorization.substring(7);
        var username = jwtManager.getUsername(token);
        var entity = userRepository.getByUsername(username);

        if (dto.getId() != null){
            var user = new User();
            user.setId(dto.getId());
            user.setUsername(dto.getUsername());
            var hashedPassword = passwordEncoder.encode(dto.getPassword());
            user.setPassword(hashedPassword);
            user.setCreatedBy(entity.getCreatedBy());
            user.setCreatedAt(entity.getCreatedAt());
            user.setUpdatedBy(entity.getId());
            user.setUpdatedAt(LocalDateTime.now());

            var userSaved = userRepository.save(user);

            var reference = new UserUpdateResponseDTO("User", userSaved.getId(), userSaved.getUpdatedBy(), userSaved.getUpdatedAt());
            return new UpdateResponseDTO(true, "Succesfully Update Data", reference);
        } else {
            var user = new User();
            user.setId(dto.getId());
            user.setUsername(dto.getUsername());
            var hashedPassword = passwordEncoder.encode(dto.getPassword());
            user.setPassword(hashedPassword);
            user.setCreatedBy(entity.getId());
            user.setCreatedAt(LocalDateTime.now());

            var userSaved = userRepository.save(user);

            var reference = new UserCreateResponseDTO("User", userSaved.getId(), userSaved.getCreatedBy(), userSaved.getCreatedAt());
            return new CreateResponseDTO(true, "Succesfully Create Data", reference);
        }
    }

    public DeleteResponseDTO delete(String authorization, Long id){
        var token = authorization.substring(7);
        var username = jwtManager.getUsername(token);
        var entity = userRepository.getByUsername(username);

        var user = userRepository.findById(id).get();
        user.setDeletedBy(entity.getId());
        user.setDeletedAt(LocalDateTime.now());
        var userSaved = userRepository.save(user);

        var reference = new UserDeleteResponseDTO("User", userSaved.getId(), userSaved.getDeletedBy(), userSaved.getDeletedAt());
        return new DeleteResponseDTO(true, "Succesfully Delete Data", reference);
    }
}
