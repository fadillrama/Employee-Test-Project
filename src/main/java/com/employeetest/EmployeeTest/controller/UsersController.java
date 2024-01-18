package com.employeetest.EmployeeTest.controller;

import com.employeetest.EmployeeTest.dto.user.UpsertUserDTO;
import com.employeetest.EmployeeTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Object> get(){
        var response = service.getUserRow();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(required = true) Long id){
        var response = service.getOneUser(id);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping
    public ResponseEntity<Object> post(@RequestHeader("Authorization") String authorization,
                                       @RequestBody UpsertUserDTO dto, BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            var response = service.saveUser(authorization, dto);
            return ResponseEntity.status(201).body(response);
        }
        return ResponseEntity.status(422).body(bindingResult.getAllErrors());
    }

    @PutMapping
    public ResponseEntity<Object> put(@RequestHeader("Authorization") String authorization,
                                       @RequestBody UpsertUserDTO dto, BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            var response = service.saveUser(authorization, dto);
            return ResponseEntity.status(201).body(response);
        }
        return ResponseEntity.status(422).body(bindingResult.getAllErrors());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@RequestHeader("Authorization") String authorization,
                                         @PathVariable(required = true) Long id){
        var response = service.delete(authorization, id);
        return ResponseEntity.status(409).body(response);
    }
}
