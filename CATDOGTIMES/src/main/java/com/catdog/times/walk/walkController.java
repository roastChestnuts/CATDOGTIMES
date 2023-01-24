package com.catdog.times.walk;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class walkController {
    @GetMapping("walk")
    public List<String> Hello(){
    	String[] data = {"1","2","3","4","5"};
        return Arrays.asList(data);
    }
}