package com.myphotos.example.myphotos.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.myphotos.example.myphotos.model.Photo;
import com.myphotos.example.myphotos.service.PhotoService;
import com.myphotos.example.myphotos.service.iPhotoService;

@RestController
public class PhotoController {
    
    @Autowired
    @Qualifier("mainPhotoService")
    private iPhotoService photoService;
    
    public PhotoController(){
       
    

    }
    @RequestMapping("api/photos")
    public Iterable<Photo> getAll(){
      
        
        return photoService.getAll();
    }

    @RequestMapping("/api/photos/{id}")
    public Photo getById(@PathVariable int id){

        Optional<Photo> photo = photoService.getById(id);

        if (photo.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Foto non Trovata");
        }

        return photo.get();
    }

}
