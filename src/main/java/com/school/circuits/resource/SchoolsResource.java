package com.school.circuits.resource;


import com.school.circuits.dto.SchoolsDto;
import com.school.circuits.entities.Schools;
import com.school.circuits.service.SchoolsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/schools")
public class SchoolsResource {

    private SchoolsService schoolsService;
    public SchoolsResource(SchoolsService schoolsService) {
        this.schoolsService = schoolsService;
    }

    @GetMapping( value = "/getAll")
    public List<Schools> findSchools(){
        return schoolsService.findAllSchools();
    }

    @GetMapping( value = "/getAllInfo" )
    public List<SchoolsDto> findSchoolsDto(){
        return schoolsService.findAllSchoolsDto();
    }

    @GetMapping( value = "/getSchool/{idplantel}")
    public SchoolsDto findSchoolDto(@PathVariable int idplantel){
        return schoolsService.findSchoolDto(idplantel);
    }

    @GetMapping( value="/getAllSchoolInfo/{idSchool}")
    public HashMap<String, Object> findAllSchoolInfo(@PathVariable Integer idSchool){
      return schoolsService.findFullSchool(idSchool);
    }

    @GetMapping( value = "/getFullSchool/{idplantel}")
    public Optional<Schools> findSchool(@PathVariable int idplantel){
        return schoolsService.findSchool(idplantel);
    }

    @PostMapping(value = "/addSchool")
    public Schools addSchool(@RequestBody Schools school){
        return schoolsService.addSchool(school);
    }

    @PutMapping( value ="/updateSchool/{idplantel}")
    public Schools updateSchool(@RequestBody Schools school, @PathVariable int idplantel){

        return schoolsService.updateSchool(school, idplantel);
    }

    @DeleteMapping(value = "/deleteSchool/{idschool}")
    public void deleteSchool(@PathVariable Integer idschool){
        schoolsService.deleteSchool(idschool);
    }



}
