package com.employeetest.EmployeeTest.service;

import com.employeetest.EmployeeTest.component.JwtManager;
import com.employeetest.EmployeeTest.dto.user.OneUserDTO;
import com.employeetest.EmployeeTest.dto.user.UserDTO;
import com.employeetest.EmployeeTest.repository.JobRepository;
import com.employeetest.EmployeeTest.repository.UserDetailRepository;
import com.employeetest.EmployeeTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    public JwtManager jwtManager;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserDetailRepository userDetailRepository;
    @Autowired
    public JobRepository jobRepository;


    public OneUserDTO getOneAccount(String authorization){
        var token = authorization.substring(7);
        var username = jwtManager.getUsername(token);
        var entity = userRepository.getByUsername(username);
        var detail = userDetailRepository.getDetailById(entity.getId());
        var jobs = jobRepository.getJobById(entity.getId());

        var response = new UserDTO(
                entity.getId(),
                entity.getUsername(),
                detail,
                jobs,
                entity.getCreatedBy(),
                entity.getCreatedAt(),
                entity.getUpdatedBy(),
                entity.getUpdatedAt(),
                entity.getDeletedBy(),
                entity.getDeletedAt()
        );
        return new OneUserDTO(true, response);
    }
}
