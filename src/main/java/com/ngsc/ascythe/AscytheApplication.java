package com.ngsc.ascythe;

import com.ngsc.ascythe.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class AscytheApplication {

	public static void main(String[] args) {
		SpringApplication.run(AscytheApplication.class, args);
	}

}
