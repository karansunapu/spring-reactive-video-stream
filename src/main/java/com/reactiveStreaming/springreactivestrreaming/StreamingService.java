package com.reactiveStreaming.springreactivestrreaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {

    private static final String FORMAT= "classpath:videos/%s.mp4";

    // use from <springframework.core.io>
    // to load video as a resource
    @Autowired
    private ResourceLoader resourceLoader;

    // send video bytes as mono of resource
    public Mono<Resource> loadVideoResource(String title){
        return Mono.fromSupplier(() -> resourceLoader.
                getResource(String.format(FORMAT,title))) ;
    }

}
