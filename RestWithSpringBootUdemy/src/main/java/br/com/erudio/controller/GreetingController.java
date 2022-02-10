package br.com.erudio.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.Greeting;

/**
 * 
 * @author Edilson
 *
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Alguém") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/greeting/{name}")
	public Greeting greetingByName(@PathVariable("name") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}	
}
