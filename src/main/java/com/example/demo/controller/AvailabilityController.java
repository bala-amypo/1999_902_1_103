// package com.example.demo.controller;
// public class AvailabilityController{
    
// }

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.shiftscheduler.entity.EmployeeAvailability;
import com.example.shiftscheduler.service.AvailabilityService;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @PostMapping("/add")
    public EmployeeAvailability addAvailability(
            @RequestBody EmployeeAvailability availability) {
        return availabilityService.addAvailability(availability);
    }

    @GetMapping("/all")
    public List<EmployeeAvailability> getAllAvailability() {
        return availabilityService.getAllAvailability();
    }

    @GetMapping("/{id}")
    public EmployeeAvailability getAvailabilityById(
            @PathVariable Long id) {
        return availabilityService.getAvailabilityById(id);
    }
}
