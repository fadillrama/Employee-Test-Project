package com.employeetest.EmployeeTest.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Created_By")
    private Long createdBy;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @Column(name = "Updated_By")
    private Long updatedBy;

    @Column(name = "Updated_At")
    private LocalDateTime updatedAt;

    @Column(name = "Deleted_By")
    private Long deletedBy;

    @Column(name = "Deleted_At")
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "user")
    private List<Job> jobs;
}
