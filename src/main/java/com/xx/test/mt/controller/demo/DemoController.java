package com.xx.test.mt.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/webworker")
	public String helloMvc() {

		return "webworkerTest";
	}

}
