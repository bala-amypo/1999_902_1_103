// package com.example.demo.service.impl;
// import com.example.demo.service.ShiftTemplateService;
// public class ShiftTemplateServiceImpl implements ShiftTemplateService{
    
// }

package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shiftscheduler.model.ShiftTemplate;
import com.example.shiftscheduler.repository.ShiftTemplateRepository;
import com.example.shiftscheduler.service.ShiftTemplateService;

@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService {

    @Autowired
    private ShiftTemplateRepository templateRepository;

    @Override
    public ShiftTemplate addTemplate(ShiftTemplate template) {
        return templateRepository.save(template);
    }

    @Override
    public List<ShiftTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }

    @Override
    public ShiftTemplate getTemplateById(Long id) {
        return templateRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTemplate(Long id) {
        templateRepository.deleteById(id);
    }
}
