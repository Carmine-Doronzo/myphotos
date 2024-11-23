package com.myphotos.example.myphotos.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.myphotos.example.myphotos.model.Photo;
import com.myphotos.example.myphotos.service.iPhotoService;


@RestController
public class AdminPhotoController {

    @Autowired
    @Qualifier("mainPhotoService")
    private iPhotoService photoService;

  

    public AdminPhotoController(){
        
       

    }
    @RequestMapping("/admin/api/photos")
    public Iterable<Photo> getAll(){
      
        
        return photoService.getAll();
    }

    @RequestMapping("/admin/api/photos/{id}")
    public Photo getById(@PathVariable int id){

        Optional<Photo> photo = photoService.getById(id);

        if (photo.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Foto non Trovata");
        }

        return photo.get();
    }

    @PostMapping("/admin/api/photos")
    public Photo create(@RequestBody Photo photo){

       return photoService.create(photo);
    }

    @PutMapping("/admin/api/photos/{id}")
    public Photo update(@PathVariable int id, @RequestBody Photo photo){
        Optional<Photo> updatedPhoto = photoService.update(id, photo);

        if (updatedPhoto.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Foto non Trovata");
        }

        return updatedPhoto.get();

    }

    @DeleteMapping("/admin/api/photos/{id}")
    public void delete(@PathVariable int id){

       

        Boolean isDeleted = photoService.delete(id);

        if (isDeleted == false){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Foto non Trovata");
        }

    

        

    }
}
