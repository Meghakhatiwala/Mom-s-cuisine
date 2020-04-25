package org.launchcode.MomsCuisine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping
    @ResponseBody
    public String main() {
        return "Default Page";
    }

    @GetMapping("signup")
    @ResponseBody
    public String signup() {
        return "Hello, Spring";
    }

}
