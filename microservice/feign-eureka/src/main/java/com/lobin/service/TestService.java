package com.lobin.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(value="TEST-SERVICE",fallback=TestServiceHystrix.class)
public interface TestService {
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    String list();
    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
	String welcome();

}
