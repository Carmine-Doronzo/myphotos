package com.myphotos.example.myphotos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    
    public String index() {
        return "index";
    } 

    @GetMapping("/demo")
    @ResponseBody
    public String demo() {
        return "Questa è una demo";
    } 
}
