package com.lobin.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lobin.service.TestService;
@RestController
public class TestCtrl {
//	@Autowired
//    RestTemplate restTemplate;
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String add() {
//    	System.out.println("go in list method..................");
//        return restTemplate.getForEntity("http://ACTIVITIDEMO/list", String.class).getBody();
//    }
	@Autowired
	private TestService testService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return testService.list();
	}
}
