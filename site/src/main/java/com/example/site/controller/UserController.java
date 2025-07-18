package com.example.site.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/user")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("")
  @ModelAttribute
  public ModelAndView getAllCompanies(Model model) {
    model.addAttribute("content", "users");
    model.addAttribute("pageTitle", "Users");
    model.addAttribute("users:", userService.getAllUsers());
    return new ModelAndView("layout");
  }
}
