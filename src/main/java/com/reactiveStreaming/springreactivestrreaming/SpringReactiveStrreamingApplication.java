package com.reactiveStreaming.springreactivestrreaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class SpringReactiveStrreamingApplication {

	@Autowired
	private StreamingService service;

	//  produces = "video/mp4" -> to tell mp4 video is needed
	// Range as header -> tell the range of bytes to fetch as resource
	// Every call return - 206 Partial Content - in the network tab
	@GetMapping(value = "/video/{title}", produces = "video/mp4")
	public Mono<Resource> loadVideos(@PathVariable String title, @RequestHeader("Range") String range) {
		return service.loadVideoResource(title);
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveStrreamingApplication.class, args);
	}

}
