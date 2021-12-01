package com.zjq.cservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zjq
 */
@RestController
public class SampleController {
    @GetMapping("/c")
    public String methodC(){
        String result = " -> Service C";
        return result;
    }
}
