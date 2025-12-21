// package com.example.demo.controller;
// public class ShiftTemplateController{
    
// }

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.service.ShiftTemplateService;

@RestController
@RequestMapping("/api/templates")
public class ShiftTemplateController {

    @Autowired
    private ShiftTemplateService templateService;

    @PostMapping("/add")
    public ShiftTemplate addTemplate(@RequestBody ShiftTemplate template) {
        return templateService.addTemplate(template);
    }

    @GetMapping("/all")
    public List<ShiftTemplate> getAllTemplates() {
        return templateService.getAllTemplates();
    }

    @GetMapping("/{id}")
    public ShiftTemplate getTemplateById(@PathVariable Long id) {
        return templateService.getTemplateById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTemplate(@PathVariable Long id) {
        templateService.deleteTemplate(id);
        return "Shift template deleted successfully";
    }
}
