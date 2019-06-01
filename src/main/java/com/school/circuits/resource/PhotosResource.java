package com.school.circuits.resource;


import com.school.circuits.entities.Photos;
import com.school.circuits.entities.Plan;
import com.school.circuits.service.PhotosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/photos")
public class PhotosResource {

  private PhotosService photosService;
  public PhotosResource(PhotosService photosService) {
    this.photosService = photosService;
  }

  @GetMapping( value="/getEvidence/{idplan}")
  public List<Photos> findEvidence(@PathVariable Integer idplan){
    return photosService.findEvidence(idplan);
  }

  @PostMapping( value="/addPhoto")
  public Photos addPhoto(@RequestBody Photos photo){
    return photosService.addPhoto(photo);
  }

  @PutMapping( value ="/updatePhoto/{idphoto}")
  public Photos updatePhoto(@RequestBody Photos photo, @PathVariable Integer idphoto){

    return photosService.updatePhoto(photo, idphoto);
  }

  @DeleteMapping( value="/deletePhoto/{idphoto}" )
  public void deletePhoto(@PathVariable Integer idphoto){
    photosService.deletePhoto(idphoto);
  }


}
