// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.model.Department;

// @Repository
// public interface DepartmentRepository extends JpaRepository<Department,Long>{
    
// // }

// package com.example.demo.repository;

// import com.example.demo.model.Department;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface DepartmentRepository extends JpaRepository<Department, Long> {
//     boolean existsByName(String name);
// }

package com.example.demo.repository;

import com.example.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsByName(String name);
}
