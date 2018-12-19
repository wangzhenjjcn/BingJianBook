package com.bingjian.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bingjian.book.domain.CurrentUser;

@Controller
public class HomeController {

    @SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

//    @Autowired
//    private MediaPlatformService mediaPlatformService;

    @RequestMapping("/")
    public String getHomePage(@ModelAttribute("currentUser") CurrentUser currentUser, Model model) {
//        MediaPlatform mp =  mediaPlatformService.findByUserName(currentUser.getUsername());
//        if(mp != null) {
//            model.addAttribute("mp", mp);
//        }
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam(required = false) String error) {
        return new ModelAndView("login", "error", error);
    }

}
