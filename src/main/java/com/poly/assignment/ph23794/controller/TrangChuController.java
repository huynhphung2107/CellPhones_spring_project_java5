package com.poly.assignment.ph23794.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class TrangChuController {

    @GetMapping("/dashboard/home")
    public String home(Model model){
//        return "/dashboard/trangAdmin";
        return "/viewform/header1";
    }

    @GetMapping("/home")
    public String client(Model model){
//        return "/dashboard/trangAdmin";
        return "/viewform/index";
    }

    @GetMapping("/login")
    public String loginController(){

        return "/client/login";
    }
}
