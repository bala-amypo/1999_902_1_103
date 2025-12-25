// package com.example.demo.controller;
// public class EmployeeController{
    
// }

// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.Employee;
// import com.example.demo.service.EmployeeService;

// @RestController
// @RequestMapping("/api/employees")
// public class EmployeeController {

//     @Autowired
//     private EmployeeService employeeService;

//     @PostMapping("/add")
//     public Employee addEmployee(@RequestBody Employee employee) {
//         return employeeService.addEmployee(employee);
//     }

//     @GetMapping("/all")
//     public List<Employee> getAllEmployees() {
//         return employeeService.getAllEmployees();
//     }

//     @GetMapping("/{id}")
//     public Employee getEmployeeById(@PathVariable Long id) {
//         return employeeService.getEmployeeById(id);
//     }

//     @DeleteMapping("/delete/{id}")
//     public String deleteEmployee(@PathVariable Long id) {
//         employeeService.deleteEmployee(id);
//         return "Employee deleted successfully";
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> list() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Deleted");
    }
}