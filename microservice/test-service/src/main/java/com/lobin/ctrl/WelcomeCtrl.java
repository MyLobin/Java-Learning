package com.lobin.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeCtrl {
	 @RequestMapping(value = "/welcome" ,method = RequestMethod.GET)
	    public String welcome() {
	       return "welcome";
	    }
}
