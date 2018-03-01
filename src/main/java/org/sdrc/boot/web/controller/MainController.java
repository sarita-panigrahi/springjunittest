package org.sdrc.boot.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	
	@GetMapping("/getHelloPage")
	@ResponseBody
	public String getView() {

		return "hello";
	}

	@GetMapping("/")
	public String home() {

		return "home";
	}

	@GetMapping(value = "/hello")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok().body("Hello there !");
	}

	
}
