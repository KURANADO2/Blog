package com.kuranado.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: KURANADO
 * @Date: 2018/6/30 20:06
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Welcome to kuranado's blog!";
    }

}
