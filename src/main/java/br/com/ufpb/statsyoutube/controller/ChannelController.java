package br.com.ufpb.statsyoutube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/channels")
public class ChannelController {
	
		@GetMapping
		public String hello() {
			return "hello mundo";
		}
}
