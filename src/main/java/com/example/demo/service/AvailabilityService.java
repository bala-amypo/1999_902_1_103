// package com.example.demo.service;

// import java.Time.*;
// import java.util.List;

// import com.example.demo.model.EmployeeAvailability;
// public interface AvailabilityService{
//      EmployeeAvailability create(EmployeeAvailability availability);
//      EmployeeAvailability update(Long id,EmployeeAvailability availability);
//      void delete(Long id);
//      List<EmployeeAvailability> getByData(LocalDate date);
// }

package com.example.demo.service;

import java.util.List;
import com.example.demo.model.EmployeeAvailability;

public interface AvailabilityService {

    EmployeeAvailability addAvailability(EmployeeAvailability availability);

    List<EmployeeAvailability> getAllAvailability();

    EmployeeAvailability getAvailabilityById(Long id);
}
