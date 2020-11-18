/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrodata.Rest.controller;

import com.metrodata.Rest.entities.LoginInput;
import com.metrodata.Rest.entities.RegisterInput;
import com.metrodata.Rest.entities.UserAddress;
import com.metrodata.Rest.entities.UserContact;
import com.metrodata.Rest.entities.UserCurrentOccupation;
import com.metrodata.Rest.entities.UserEducation;
import com.metrodata.Rest.entities.UserInfo;
import com.metrodata.Rest.services.LoginRestService;
import com.metrodata.Rest.services.RegisterRestService;
import com.metrodata.Rest.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Boona
 */
@Controller
public class RestController {

    String id;

    @Autowired
    RegisterRestService registerRestService;

    @Autowired
    LoginRestService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("loginInput", new LoginInput());
        model.addAttribute("registerInput", new RegisterInput());
        return "login";
    }

    @GetMapping("signup")
    public String signup(Model model) {
        model.addAttribute("loginInput", new LoginInput());
        model.addAttribute("registerInput", new RegisterInput());
        return "register";
    }

    //login
    @PostMapping("login")
    public String login(LoginInput input) {
        System.out.println(service.login(input));
        id = service.getById(service.login(input));
        System.out.println(id);
        return "redirect:/profile/";
    }

    @PostMapping("/register/")
    public String saveRegister(RegisterInput input) {
        System.out.println(input);
        registerRestService.register(input);
        return "redirect:/";
    }

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/profile/")
    public String basicProfile(Model model) {
        model.addAttribute("profile", userProfileService.getUserInfo(id));
        model.addAttribute("address", userProfileService.getUserAddress(id));
        model.addAttribute("contact", userProfileService.getUserContact(id));
        model.addAttribute("occupation", userProfileService.getUserOccupation(id));
        model.addAttribute("education", userProfileService.getUserEducation(id));
        return "landingPage";
    }

    @PostMapping("/profile/basic")
    public String editBasic(UserInfo userInfo) {
        userProfileService.saveBasicInformation(userInfo);
        return "redirect:/profile/";
    }

    @PostMapping("/profile/address")
    public String editAddress(UserAddress userAddress) {
        userProfileService.saveAddress(userAddress);
        return "redirect:/profile/";
    }

    @PostMapping("/profile/contact")
    public String editContact(UserContact userContact) {
        userProfileService.saveContact(userContact);
        return "redirect:/profile/";
    }

    @PostMapping("/profile/currentoccupation")
    public String editOccupation(UserCurrentOccupation userCurrentOccupation) {
        userProfileService.saveOccupationOccupation(userCurrentOccupation);
        return "redirect:/profile/";
    }

    @PostMapping("/profile/education")
    public String editEducation(UserEducation userEducation) {
        userProfileService.saveEducation(userEducation);
        return "redirect:/profile/";
    }

}
