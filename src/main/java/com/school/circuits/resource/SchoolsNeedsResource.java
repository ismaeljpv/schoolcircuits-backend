package com.school.circuits.resource;


import com.school.circuits.entities.SchoolsNeeds;
import com.school.circuits.service.SchoolsNeedsService;
import com.school.circuits.service.SchoolsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/needs")
public class SchoolsNeedsResource {

  private SchoolsNeedsService snService;
  public SchoolsNeedsResource(SchoolsNeedsService snService) {
    this.snService = snService;
  }

  @GetMapping( value ="/findBySchool/{idSchool}" )
  public SchoolsNeeds findBySchool(@PathVariable Integer idSchool){
    return snService.finsSchoolNeeds(idSchool);
  }

  @PostMapping(value = "/addNeeds")
  public SchoolsNeeds addNeeds(@RequestBody SchoolsNeeds sn){
    return snService.addNeeds(sn);
  }

  @PutMapping(value ="/updateNeeds/{idNeeds}")
  public SchoolsNeeds updateNeeds(@RequestBody SchoolsNeeds sn, @PathVariable Integer idNeeds){
    return snService.updateNeeds(sn, idNeeds);
  }

  @DeleteMapping(value = "/deleteNeed/{idNeed}")
  public void deleteNeeds(@PathVariable Integer idNeed){
    snService.deleteNeeds(idNeed);
  }


}
