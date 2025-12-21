// package com.example.demo.controller;
// public class ScheduleController{
    
// }

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/generate")
    public GeneratedShiftSchedule generateSchedule(
            @RequestBody GeneratedShiftSchedule schedule) {
        return scheduleService.generateSchedule(schedule);
    }

    @GetMapping("/all")
    public List<GeneratedShiftSchedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public GeneratedShiftSchedule getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }
}
