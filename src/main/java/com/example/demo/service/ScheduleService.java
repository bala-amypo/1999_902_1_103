// package com.example.demo.service;

// import java.util.List;

// public interface ScheduleService{
//     List<GeneratedShiftSchedule> generateForDate(LocalDate date);
//     List<GeneratedShiftSchedule> getByDate(LocalDate date);
// }

package com.example.demo.service;

import java.util.List;
import com.example.demo.model.GeneratedShiftSchedule;

public interface ScheduleService {

    GeneratedShiftSchedule generateSchedule(GeneratedShiftSchedule schedule);

    List<GeneratedShiftSchedule> getAllSchedules();

    GeneratedShiftSchedule getScheduleById(Long id);
}
