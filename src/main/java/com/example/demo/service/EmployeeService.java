// package com.example.demo.service;

// import java.util.List;

// public interface EmployeeService{
//     Employee createEmployee(Employee employee);
//     Employee getEmployee(Long id);
//     Employee updateEmployee(Long id,Employee employee);
//     void deleteEmployee(Long id);
//     List<Employee> getAll();
// }

package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Employee;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void deleteEmployee(Long id);
}
