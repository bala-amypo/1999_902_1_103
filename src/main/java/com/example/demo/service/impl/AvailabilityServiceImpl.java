package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.service.AvailabilityService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Override
    public EmployeeAvailability addAvailability(EmployeeAvailability availability) {
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
