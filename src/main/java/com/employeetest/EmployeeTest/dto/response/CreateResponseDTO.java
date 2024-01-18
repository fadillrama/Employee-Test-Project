package com.employeetest.EmployeeTest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateResponseDTO {
    private Boolean status;
    private String messages;
    private UserCreateResponseDTO reference_data;
}
