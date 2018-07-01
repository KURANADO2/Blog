package com.kuranado.blog.controller;

import com.kuranado.blog.domain.User;
import com.kuranado.blog.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 获取所有用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView listUser(Model model) {
        model.addAttribute("title", "查看所有用户");
        model.addAttribute("userList", userRepository.findAll());
        // 路径会自动补上 templates/，所以不要再 users 前加 /，否则将会报错：An error happened during template parsing (template: "class path resource [templates//users/list.html]")
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 创建用户实例返回给 form.html 页面的 form 表单
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView craeteUser(Model model) {
        model.addAttribute("title", "创建用户");
        model.addAttribute("user", new User(null, null, null));
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 根据 id 查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView viewUserById(@PathVariable Long id, Model model) {
        model.addAttribute("title", "根据 id 查看单个用户");
        model.addAttribute("user", userRepository.findById(id).get());
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 根据 id 删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 更新用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modifyUserById(@PathVariable Long id, Model  model) {
        model.addAttribute("title", "修改用户");
        model.addAttribute("user", userRepository.findById(id).get());
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 新增或更新用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }
}
