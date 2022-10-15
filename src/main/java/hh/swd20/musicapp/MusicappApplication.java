package hh.swd20.musicapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MusicappApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MusicappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner musicDemo() {
		return (args) -> {
			
		};
	}

}
