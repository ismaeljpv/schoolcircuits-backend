package com.school.circuits.service;


import com.school.circuits.entities.Photos;
import com.school.circuits.exception.EntityNotFound;
import com.school.circuits.repository.PhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotosService {

  @Autowired
  private PhotosRepository photosRepository;

  public List<Photos> findEvidence(Integer idplan){
    return photosRepository.findByIdplan(idplan);
  }

  public Photos addPhoto(Photos photo){
    return photosRepository.save(photo);
  }

  public Photos updatePhoto(Photos photo, Integer idphoto){
    Optional<Photos> photos = photosRepository.findById(idphoto);
    if (!photos.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idphoto);
    return photosRepository.save(photo);
  }

  public void deletePhoto(Integer idphoto){
    Optional<Photos> photo = photosRepository.findById(idphoto);
    if (!photo.isPresent())
      throw new EntityNotFound("No hay resultado por el valor: " + idphoto);
    photosRepository.deleteById(idphoto);
  }

}
