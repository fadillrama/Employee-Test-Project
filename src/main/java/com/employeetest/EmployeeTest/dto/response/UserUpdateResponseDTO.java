package com.employeetest.EmployeeTest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateResponseDTO {
    private String entity;
    private Long pk;
    private Long updated_by;
    private LocalDateTime updated_at;
}
