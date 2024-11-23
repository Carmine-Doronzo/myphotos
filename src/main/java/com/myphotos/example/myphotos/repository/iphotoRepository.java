package com.myphotos.example.myphotos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myphotos.example.myphotos.model.Photo;

@Repository
public interface iphotoRepository extends CrudRepository<Photo, Integer>{

}
