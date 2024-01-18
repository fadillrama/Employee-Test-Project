package com.employeetest.EmployeeTest.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private DetailUserDTO detail;
    private List<JobUserDTO> jobs;
    private Long created_by;
    private LocalDateTime created_at;
    private Long updated_by;
    private LocalDateTime updated_at;
    private Long deleted_by;
    private LocalDateTime deleted_at;

    public UserDTO(Long id, String username, Long created_by, LocalDateTime created_at, Long updated_by, LocalDateTime updated_at, Long deleted_by, LocalDateTime deleted_at) {
        this.id = id;
        this.username = username;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.deleted_by = deleted_by;
        this.deleted_at = deleted_at;
    }
}
