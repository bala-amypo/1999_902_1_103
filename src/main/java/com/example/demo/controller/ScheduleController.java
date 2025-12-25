// package com.example.demo.controller;
// public class ScheduleController{
    
// }

// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.GeneratedShiftSchedule;
// import com.example.demo.service.ScheduleService;

// @RestController
// @RequestMapping("/api/schedules")
// public class ScheduleController {

//     @Autowired
//     private ScheduleService scheduleService;

//     @PostMapping("/generate")
//     public GeneratedShiftSchedule generateSchedule(
//             @RequestBody GeneratedShiftSchedule schedule) {
//         return scheduleService.generateSchedule(schedule);
//     }

//     @GetMapping("/all")
//     public List<GeneratedShiftSchedule> getAllSchedules() {
//         return scheduleService.getAllSchedules();
//     }

//     @GetMapping("/{id}")
//     public GeneratedShiftSchedule getScheduleById(@PathVariable Long id) {
//         return scheduleService.getScheduleById(id);
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