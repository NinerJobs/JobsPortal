package com.niner.jobs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfiguration {

   @Bean
   public CascadeSaveMongoEventListener cascadingSaveMongoEventListener() {
	    return new CascadeSaveMongoEventListener();
	}

}