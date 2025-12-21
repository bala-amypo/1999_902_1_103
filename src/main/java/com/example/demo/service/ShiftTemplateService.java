// package com.example.demo.service;

// import java.util.List;

// public interface ShiftTemplateService{
//     ShiftTemplate create(ShiftTemplate template);
//     List<ShiftTemplate> getByDepartment(Long departmentId);
// }

package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ShiftTemplate;

public interface ShiftTemplateService {

    ShiftTemplate addTemplate(ShiftTemplate template);

    List<ShiftTemplate> getAllTemplates();

    ShiftTemplate getTemplateById(Long id);

    void deleteTemplate(Long id);
}
