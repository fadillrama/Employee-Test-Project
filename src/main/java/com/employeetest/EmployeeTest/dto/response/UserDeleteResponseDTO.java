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
public class UserDeleteResponseDTO {
    private String entity;
    private Long pk;
    private Long deleted_by;
    private LocalDateTime deleted_at;
}
