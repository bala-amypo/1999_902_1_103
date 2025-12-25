// 

// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.Department;
// import com.example.demo.service.DepartmentService;

// @RestController
// @RequestMapping("/api/departments")
// public class DepartmentController {

//     @Autowired
//     private DepartmentService departmentService;

//     @PostMapping("/add")
//     public Department addDepartment(@RequestBody Department department) {
//         return departmentService.addDepartment(department);
//     }

//     @GetMapping("/all")
//     public List<Department> getAllDepartments() {
//         return departmentService.getAllDepartments();
//     }

//     @GetMapping("/{id}")
//     public Department getDepartmentById(@PathVariable Long id) {
//         return departmentService.getDepartmentById(id);
//     }

//     @DeleteMapping("/delete/{id}")
//     public String deleteDepartment(@PathVariable Long id) {
//         departmentService.deleteDepartment(id);
//         return "Department deleted successfully";
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> list() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> get(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.create(department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}