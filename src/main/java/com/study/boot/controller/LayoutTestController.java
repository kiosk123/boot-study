package com.study.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutTestController {
    
    @GetMapping("/layout")
    public String layout() {
        System.out.println("hello!");
        return "layout/hello";
    }
}
