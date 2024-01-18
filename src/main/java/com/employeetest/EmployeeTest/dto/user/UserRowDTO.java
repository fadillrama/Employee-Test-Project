package com.employeetest.EmployeeTest.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRowDTO {
    private Boolean status;
    private List<UserDTO> data;
}
