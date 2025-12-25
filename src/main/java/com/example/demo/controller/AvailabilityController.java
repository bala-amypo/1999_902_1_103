// // package com.example.demo.controller;
// // public class AvailabilityController{
    
// // }

// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.EmployeeAvailability;
// import com.example.demo.service.AvailabilityService;

// @RestController
// @RequestMapping("/api/availability")
// public class AvailabilityController {

//     @Autowired
//     private AvailabilityService availabilityService;

//     @PostMapping("/add")
//     public EmployeeAvailability addAvailability(
//             @RequestBody EmployeeAvailability availability) {
//         return availabilityService.addAvailability(availability);
//     }

//     @GetMapping("/all")
//     public List<EmployeeAvailability> getAllAvailability() {
//         return availabilityService.getAllAvailability();
//     }

//     @GetMapping("/{id}")
//     public EmployeeAvailability getAvailabilityById(
//             @PathVariable Long id) {
//         return availabilityService.getAvailabilityById(id);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {
    private final AvailabilityService availabilityService;
    private final EmployeeRepository employeeRepository;

    public AvailabilityController(AvailabilityService availabilityService, EmployeeRepository employeeRepository) {
        this.availabilityService = availabilityService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<EmployeeAvailability>> byDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return ResponseEntity.ok(availabilityService.getByDate(localDate));
    }

    @PostMapping
    public ResponseEntity<EmployeeAvailability> create(@RequestBody EmployeeAvailability availability) {
        return ResponseEntity.ok(availabilityService.create(availability));
    }
}