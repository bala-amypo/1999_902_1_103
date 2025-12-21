// package com.example.demo.service;

// import java.util.List;

// public interface DepartmentService{
//     Department create(Department department);
//     Department get(Long id);
//     void delete(Long id);
//     List<Department> getAll();
// }

package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Department;

public interface DepartmentService {

    Department addDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    void deleteDepartment(Long id);
}
