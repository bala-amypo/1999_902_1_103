// package com.example.demo.controller;
// public class ShiftTemplateController{
    
// }

// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.ShiftTemplate;
// import com.example.demo.service.ShiftTemplateService;

// @RestController
// @RequestMapping("/api/templates")
// public class ShiftTemplateController {

//     @Autowired
//     private ShiftTemplateService templateService;

//     @PostMapping("/add")
//     public ShiftTemplate addTemplate(@RequestBody ShiftTemplate template) {
//         return templateService.addTemplate(template);
//     }

//     @GetMapping("/all")
//     public List<ShiftTemplate> getAllTemplates() {
//         return templateService.getAllTemplates();
//     }

//     @GetMapping("/{id}")
//     public ShiftTemplate getTemplateById(@PathVariable Long id) {
//         return templateService.getTemplateById(id);
//     }

//     @DeleteMapping("/delete/{id}")
//     public String deleteTemplate(@PathVariable Long id) {
//         templateService.deleteTemplate(id);
//         return "Shift template deleted successfully";
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/shift-templates")
public class ShiftTemplateController {
    private final ShiftTemplateService shiftTemplateService;
    private final DepartmentRepository departmentRepository;

    public ShiftTemplateController(ShiftTemplateService shiftTemplateService, DepartmentRepository departmentRepository) {
        this.shiftTemplateService = shiftTemplateService;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public ResponseEntity<List<ShiftTemplate>> list() {
        List<ShiftTemplate> allTemplates = new ArrayList<>();
        for (Department dept : departmentRepository.findAll()) {
            allTemplates.addAll(shiftTemplateService.getByDepartment(dept.getId()));
        }
        return ResponseEntity.ok(allTemplates);
    }

    @PostMapping
    public ResponseEntity<ShiftTemplate> create(@RequestBody ShiftTemplate shiftTemplate) {
        return ResponseEntity.ok(shiftTemplateService.create(shiftTemplate));
    }
}