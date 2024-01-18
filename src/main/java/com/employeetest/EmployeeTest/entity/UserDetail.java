package com.employeetest.EmployeeTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

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
}
