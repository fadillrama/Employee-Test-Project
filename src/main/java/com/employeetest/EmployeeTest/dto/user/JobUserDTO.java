package com.employeetest.EmployeeTest.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobUserDTO {
    private String name;
    private LocalDateTime start_at;
    private LocalDateTime until_at;
}
