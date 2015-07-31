package com.motang.framework.core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ExampleApp {
	
	@RequestMapping("/")
    String home() {
        return "Hello World by Spring boot!";
    }

}
