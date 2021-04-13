package com.commentsManager.controller;

import com.commentsManager.domain.Role;
import com.commentsManager.domain.User;
import com.commentsManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String userSave(@RequestParam String username,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String passportData,
                           @RequestParam("userId") User user,
                           @RequestParam Map<String, String> form){

        userService.saveUser(username, name, surname, passportData, user , form);

        return  "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("name", user.getName());
        model.addAttribute("surname", user.getSurname());
        model.addAttribute("passportData", user.getPassportData());

        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @RequestParam String username,
                                @RequestParam String password,
                                @RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam String passportData
     ){
        userService.updateProfile(user, username, password, name, surname, passportData);
        return "redirect:/user/profile";
    }
}
