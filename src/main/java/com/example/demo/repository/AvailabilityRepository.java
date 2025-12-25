// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.model.EmployeeAvailability;

// @Repository
// public interface AvailabilityRepository extends JpaRepository<EmployeeAvailability,Long>{
    
// }

package com.example.demo.repository;

import com.example.demo.model.EmployeeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AvailabilityRepository extends JpaRepository<EmployeeAvailability, Long> {
    Optional<EmployeeAvailability> findByEmployee_IdAndAvailableDate(Long employeeId, LocalDate availableDate);
    List<EmployeeAvailability> findByAvailableDateAndAvailable(LocalDate availableDate, Boolean available);
    List<EmployeeAvailability> findByEmployee_Id(Long employeeId);
}