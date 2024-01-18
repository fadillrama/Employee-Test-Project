package com.employeetest.EmployeeTest.repository;

import com.employeetest.EmployeeTest.dto.user.DetailUserDTO;
import com.employeetest.EmployeeTest.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    @Query("""
            SELECT new com.employeetest.EmployeeTest.dto.user.DetailUserDTO(det.firstName, det.lastName)
            FROM UserDetail AS det
            WHERE det.userId = :id
            """)
    public DetailUserDTO getDetailById(@Param("id") Long id);
}
