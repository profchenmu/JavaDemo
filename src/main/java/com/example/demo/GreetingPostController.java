package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingPostController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@PostMapping("/greetingPost")
	public GreetingPost greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new GreetingPost(counter.incrementAndGet(), String.format(template, name));
	}

}
