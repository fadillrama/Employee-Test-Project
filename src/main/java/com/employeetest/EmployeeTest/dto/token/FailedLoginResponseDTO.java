package com.employeetest.EmployeeTest.dto.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FailedLoginResponseDTO {
    private Boolean status;
    private String messages;
}
