// package com.example.demo.service.impl;
// import com.example.demo.service.AvailabilityService;
// public class AvailabilityServiceImpl implements AvailabilityService{
    
// }

package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shiftscheduler.model.EmployeeAvailability;
import com.example.shiftscheduler.repository.AvailabilityRepository;
import com.example.shiftscheduler.service.AvailabilityService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Override
    public EmployeeAvailability addAvailability(
            EmployeeAvailability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public List<EmployeeAvailability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    @Override
    public EmployeeAvailability getAvailabilityById(Long id) {
        return availabilityRepository.findById(id).orElse(null);
    }
}
