package com.catdog.times.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class hellocontroller {
    @GetMapping("/hello")
    public List<String> Hello(){
        String[] data = {"첫번째데이터","두번째데이터","세번째데이터","네번째데이터","다섯번째데이터"};
        return Arrays.asList(data);
    }
}