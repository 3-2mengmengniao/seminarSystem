package com.test.seminar.view;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value="/",method = GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value="/vali_psw",method = GET)
    public String vali_psw(Model model) {
        return "vali_psw";
    }

    @RequestMapping(value="/email-modify",method = GET)
    public String email_modify(Model model) {
        return "email-modify";
    }
}
