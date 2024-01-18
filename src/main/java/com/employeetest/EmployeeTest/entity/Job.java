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
@Table(name = "Jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "User_Id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "User_Id", insertable = false, updatable = false)
    private User user;

    @Column(name = "Name")
    private String name;

    @Column(name = "Start_At")
    private LocalDateTime startAt;

    @Column(name = "End_At")
    private LocalDateTime endAt;

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
