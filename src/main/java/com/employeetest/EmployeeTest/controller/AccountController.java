package com.employeetest.EmployeeTest.controller;


import com.employeetest.EmployeeTest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public ResponseEntity<Object> get(@RequestHeader("Authorization") String authorization){
        var response = service.getOneAccount(authorization);
        return ResponseEntity.status(200).body(response);
    }
}
