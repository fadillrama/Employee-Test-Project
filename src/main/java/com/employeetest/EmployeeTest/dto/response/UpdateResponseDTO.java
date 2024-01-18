package com.employeetest.EmployeeTest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateResponseDTO {
    private Boolean status;
    private String messages;
    private UserUpdateResponseDTO reference_data;
}
