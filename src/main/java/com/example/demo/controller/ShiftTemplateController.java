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

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/generate/{date}")
    public ResponseEntity<List<GeneratedShiftSchedule>> generate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return ResponseEntity.ok(scheduleService.generateForDate(localDate));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<GeneratedShiftSchedule>> byDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return ResponseEntity.ok(scheduleService.getByDate(localDate));
    }
}