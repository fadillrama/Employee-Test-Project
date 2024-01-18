package com.employeetest.EmployeeTest.repository;

import com.employeetest.EmployeeTest.dto.user.JobUserDTO;
import com.employeetest.EmployeeTest.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("""
            SELECT new com.employeetest.EmployeeTest.dto.user.JobUserDTO(job.name, job.startAt, job.endAt)
            FROM Job AS job
            WHERE job.userId = :id
            """)
    public List<JobUserDTO> getJobById(@Param("id") Long id);
}
