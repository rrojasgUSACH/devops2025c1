package com.example.romano;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RomanoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RomanoApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("=== Beans registrados ===");
            Arrays.stream(ctx.getBeanDefinitionNames())
                  .filter(name -> name.toLowerCase().contains("romano"))
                  .sorted()
                  .forEach(System.out::println);
        };
    }

}
