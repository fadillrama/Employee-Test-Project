package com.employeetest.EmployeeTest.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpsertUserDTO {
    private Long id;
    private String username;
    private String password;
}
