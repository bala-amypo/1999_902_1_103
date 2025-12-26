package com.example.demo.repository;

import com.example.demo.model.EmployeeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<EmployeeAvailability, Long> {
    Optional<EmployeeAvailability> findByEmployee_IdAndAvailableDate(Long employeeId, LocalDate availableDate);
    List<EmployeeAvailability> findByAvailableDateAndAvailable(LocalDate availableDate, boolean available);
    List<EmployeeAvailability> findByEmployee_Id(Long employeeId);
    List<EmployeeAvailability> findAll();
}