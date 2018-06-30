package com.kuranado.blog.controller;

import com.kuranado.blog.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: <a href='http://www.kuranado.com'>KURANADO</a>
 * @Date: 2018/6/30 20:24
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView listUser(Model model) {
        model.addAttribute("userList", userRepository);
        model.addAttribute("title", "查看所有用户");
        return new ModelAndView("users/list", "userModel", model);
    }

}
