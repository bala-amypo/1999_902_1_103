// package com.example.demo.service.impl;
// import com.example.demo.service.ScheduleService;
// public class ScheduleServiceImpl implements ScheduleService{
    
// }

package com.example.demo.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public GeneratedShiftSchedule generateSchedule(GeneratedShiftSchedule schedule) {

        // Auto-assign today's date if not provided
        if (schedule.getShiftDate() == null) {
            schedule.setShiftDate(LocalDate.now());
        }

        return scheduleRepository.save(schedule);
    }

    @Override
    public List<GeneratedShiftSchedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public GeneratedShiftSchedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }
}
