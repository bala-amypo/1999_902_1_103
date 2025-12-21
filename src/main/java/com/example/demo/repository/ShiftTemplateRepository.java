// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.model.ShiftTemplate;

// @Repository
// public interface ShiftTemplateRepository extends JpaRepository<ShiftTemplate,Integer>{
    
// }

package com.example.shiftscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shiftscheduler.entity.ShiftTemplate;

public interface ShiftTemplateRepository extends JpaRepository<ShiftTemplate, Long> {
}
