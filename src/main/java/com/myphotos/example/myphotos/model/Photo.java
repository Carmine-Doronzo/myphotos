package com.myphotos.example.myphotos.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @NotBlank(message = "this field is required")
    @Length(min = 6, message = "min lenght is 6")
    private String url;
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getUrl() {
        return url;
    } 

    public void setUrl(String url){
        this.url = url;
    }

    public Photo(){

    }

    public Photo(int id, String url){
        this.id = id;
        this.url = url;
    }

}
