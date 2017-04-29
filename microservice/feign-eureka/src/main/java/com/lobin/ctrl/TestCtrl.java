package com.lobin.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lobin.service.TestService;

@RestController
public class TestCtrl {
	@Autowired
	TestService testService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return testService.list();
	}
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcome(){
		return testService.welcome();
	}
}
