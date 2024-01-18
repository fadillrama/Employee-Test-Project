package com.employeetest.EmployeeTest.repository;

import com.employeetest.EmployeeTest.dto.user.EntityUserDTO;
import com.employeetest.EmployeeTest.dto.user.UserDTO;
import com.employeetest.EmployeeTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            SELECT new com.employeetest.EmployeeTest.dto.user.EntityUserDTO(
                use.id, 
                use.username, 
                use.password,
                use.createdBy,
                use.createdAt,
                use.updatedBy,
                use.updatedAt,
                use.deletedBy,
                use.deletedAt
                )
            FROM User AS use
            WHERE use.username = :username
            """)
    public EntityUserDTO getByUsername(@Param("username") String username);

    @Query("""
            SELECT new com.employeetest.EmployeeTest.dto.user.UserDTO(
                use.id, use.username, use.createdBy, use.createdAt,
                use.updatedBy, use.updatedAt, use.deletedBy, use.deletedAt
            )
            FROM User AS use
            WHERE use.deletedAt IS NULL
            """)
    public List<UserDTO> getRow();
}
