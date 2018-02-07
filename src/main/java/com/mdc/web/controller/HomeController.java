package com.mdc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//
//    @Autowired
//    private UserRepository userRepository;

    @GetMapping("/")
    public String indexPage() {

     //   userRepository.save(user);

        return "index";
    }
}
