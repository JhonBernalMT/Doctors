package com.doctors.controller;

import com.doctors.model.SpecialtyModel;
import com.doctors.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specialty")
@CrossOrigin(origins = "specialty")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/all")
    public List<SpecialtyModel> getAllSpecialties(){
        return specialtyService.getAllSpecialty();
    }

    @GetMapping("/{id}")
    public Optional<SpecialtyModel> getSpecialty(@PathVariable Integer id){
        return specialtyService.getSpecialty(id);
    }

    @PostMapping("/save")
    public SpecialtyModel saveSpecialty(@RequestBody SpecialtyModel specialtyModel){
        return specialtyService.saveSpecialty(specialtyModel);
    }

    @PutMapping("/update")
    public SpecialtyModel updateSpecialty(SpecialtyModel specialtyModel){
        return specialtyService.updateSpecialty(specialtyModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteSpecialty(Integer id){
        return specialtyService.deleteSpecialty(id);
    }
}
