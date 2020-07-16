package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.lang.model.element.NestingKind;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @auther gxf
 * @date2020/6/30-9:54
 */
@Controller
public class LoginController {
    //@RequestMapping(value = "/user/login", method= RequestMethod.POST)
//    @DeleteMapping
//    @GetMapping
//    @PutMapping
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登录成功
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";

        } else {
            //登录失败
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }
}
