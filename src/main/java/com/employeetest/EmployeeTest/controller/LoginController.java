package com.employeetest.EmployeeTest.controller;

import com.employeetest.EmployeeTest.component.JwtManager;
import com.employeetest.EmployeeTest.dto.token.FailedLoginResponseDTO;
import com.employeetest.EmployeeTest.dto.token.RequestTokenDTO;
import com.employeetest.EmployeeTest.dto.token.SuccessLoginResponseDTO;
import com.employeetest.EmployeeTest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private JwtManager jwtManager;

    @Autowired
    private LoginService service;

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody RequestTokenDTO request){
        var isAuthenticated = service.checkAuthenticate(request.getUsername(), request.getPassword());
        if (isAuthenticated){
            var id = service.getIdByUsername(request.getUsername());
            var token = jwtManager.generateToken(
                    id,
                    request.getUsername(),
                    request.getSubject(),
                    request.getAudience(),
                    request.getSecretKey()
            );
            var successResponse = new SuccessLoginResponseDTO(true, "Succesfully Login", token, token);
            return ResponseEntity.status(HttpStatus.OK).body(successResponse);
        }
        var failResponse = new FailedLoginResponseDTO(false, "Unauthorized");
        return ResponseEntity.status(401).body(failResponse);
    }
}
