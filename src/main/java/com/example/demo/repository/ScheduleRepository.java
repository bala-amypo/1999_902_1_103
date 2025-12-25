// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.model.GeneratedShiftSchedule;

// @Repository
// public interface ScheduleRepository extends JpaRepository<GeneratedShiftSchedule,Long>{
    
// }


package com.example.demo.repository;

import com.example.demo.model.GeneratedShiftSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface GeneratedShiftScheduleRepository extends JpaRepository<GeneratedShiftSchedule, Long> {
    List<GeneratedShiftSchedule> findByShiftDate(LocalDate shiftDate);
}