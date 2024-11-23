package com.myphotos.example.myphotos.service;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.myphotos.example.myphotos.model.Photo;

import jakarta.validation.Valid;

public interface iPhotoService {

    public Iterable<Photo> getAll();

    public Optional<Photo> getById(@PathVariable int id);

    public Photo create(@Valid Photo photo);

    public Optional<Photo> update(@Valid int id, Photo photo);

    public Boolean delete(int id);

}
