package com.conversorChallenge.conversor;

import com.conversorChallenge.conversor.consola.MenuConsola;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConversorApplication.class, args);
		new MenuConsola().iniciar(); // delegamos al menú de consola
	}
}
