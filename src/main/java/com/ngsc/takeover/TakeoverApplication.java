package com.ngsc.takeover;

import com.ngsc.takeover.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class TakeoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakeoverApplication.class, args);
	}

}
