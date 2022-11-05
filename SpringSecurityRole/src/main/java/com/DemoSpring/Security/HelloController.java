package com.DemoSpring.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/")
	public String hello() {
		
		return "index";
	}
	@GetMapping("/admin")
	public String admin() {
		
		return "index";
	}
	@GetMapping("/user")
	public String user() {
		
		return "index";
	}
	@GetMapping("/editor")
	public String editor() {
		
		return "index";
	}
}
