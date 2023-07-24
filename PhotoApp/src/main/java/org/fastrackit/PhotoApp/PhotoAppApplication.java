package org.fastrackit.PhotoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class PhotoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApplication.class, args);
	}

}
