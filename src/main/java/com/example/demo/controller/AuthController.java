package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.LibraryUser;
import com.example.demo.service.LibraryUserService;

@Controller
public class AuthController {

  @Autowired
  private LibraryUserService userService;

  @GetMapping("/login")
  public String loginPage(Model model) {
    model.addAttribute("user", new LibraryUser());
    return "login";
  }

  @GetMapping("/register")
  public String registerForm(Model model) {
    model.addAttribute("user", new LibraryUser());
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(@ModelAttribute("user") LibraryUser user) {
    userService.save(user);
    return "redirect:/login";
  }

  @GetMapping("/home")
  public String homePage() {
    return "home";
  }

}
