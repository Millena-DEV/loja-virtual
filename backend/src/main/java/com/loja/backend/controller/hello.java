package com.loja.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping ("/api")

public class hello {
    @GetMapping("/")

    public String Hello(){
        return "Hello Millena" +new Date();

    }
    
}
