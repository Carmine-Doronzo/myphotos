package com.myphotos.example.myphotos.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.myphotos.example.myphotos.model.Photo;
import com.myphotos.example.myphotos.repository.iphotoRepository;

@Service("mainPhotoService")
public class DbPhotoService implements iPhotoService {

    @Autowired
    private iphotoRepository photoRepository;

    @Override
    public Iterable<Photo> getAll() {

        return photoRepository.findAll();
    }
    @Override
    public Optional<Photo> getById(@PathVariable int id) {

        return photoRepository.findById(id);
    }
    @Override
    public Photo create(Photo photo) {

        return photoRepository.save(photo);

    }
    @Override
    public Optional<Photo> update(int id, Photo photo) {
      
        Optional<Photo> foundPhoto = photoRepository.findById(id);
        if(foundPhoto.isEmpty()){
            return Optional.empty();
        }

        foundPhoto.get().setUrl(photo.getUrl());

        photoRepository.save(foundPhoto.get());

        return foundPhoto;

    }
    @Override
    public Boolean delete(int id) {

        Optional<Photo> foundPhoto = photoRepository.findById(id);
        if(foundPhoto.isEmpty()){
            return false;
        }

        photoRepository.delete(foundPhoto.get());

        return true;

    }

}
