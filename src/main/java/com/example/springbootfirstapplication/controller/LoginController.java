package com.example.springbootfirstapplication.controller;

import com.example.springbootfirstapplication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String showHomePage(ModelMap modelMap)
    {
        modelMap.put("name",getLoggedInUserName());
        return "welcome";
    }

    public String getLoggedInUserName()
    {
        Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails)
        {
            return ((UserDetails) principal).getUsername();
        }
        else
            return principal.toString();
    }
    /*@RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginPage()
    {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model)
    {
        if(loginService.validate(name, password))
        {
            model.put("name", name);
            return "welcome";
        }
        else
        {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

    }*/
}

