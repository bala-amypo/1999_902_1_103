// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.model.Employee;

// @Repository
// public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
// }

// package com.example.demo.repository;

// import com.example.demo.model.Employee;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//     boolean existsByEmail(String email);
//     Optional<Employee> findByEmail(String email);
// }

package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    boolean existsByEmail(String email);
}
