package com.hh99_spring.project02.controller;

import com.hh99_spring.project02.security.UserDetailsImpl;
import com.sun.istack.NotNull;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            String username = userDetails.getUsername();
            model.addAttribute("username", username);
            return "index";
        }
        model.addAttribute("message","null" );
        return "index";
    }

    @GetMapping("/detail")
    public String detail(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            String username = userDetails.getUsername();
            model.addAttribute("username", username);
            return "detail";
        }
        model.addAttribute("message","null" );
        return "forbiden";
    }

    @GetMapping("/error")
    public String error(){
        return "forbiden";
    }

}


//    @GetMapping("/")
//    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        try {
//            model.addAttribute("username", userDetails.getUsername());
//        }catch (IllegalArgumentException e){
//            System.out.println(e);
//            model.addAttribute("message", e.getMessage());
//            return "index";
//        }
//        return "index";
//    }