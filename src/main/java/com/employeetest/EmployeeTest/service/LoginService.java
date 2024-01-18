package com.employeetest.EmployeeTest.service;

import com.employeetest.EmployeeTest.component.ApplicationUserDetails;
import com.employeetest.EmployeeTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var account = userRepository.getByUsername(username);

        if (account == null){
            throw new UsernameNotFoundException("User not found !");
        } else {
            var userDetail = new ApplicationUserDetails(account);
            return userDetail;
        }
    }

    public Boolean checkAuthenticate(String username, String password){
        var isAuthenticated = false;
        var entity = userRepository.getByUsername(username);
        if (entity != null){
            var hashPassword = entity.getPassword();
            isAuthenticated = passwordEncoder.matches(password, hashPassword);
        }
        return isAuthenticated;
    }

    public Long getIdByUsername(String username){
        var entity = userRepository.getByUsername(username);
        return entity.getId();
    }
}
