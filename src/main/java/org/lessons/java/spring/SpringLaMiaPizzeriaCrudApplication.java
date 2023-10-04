package org.lessons.java.spring;

import java.util.Arrays;
import java.util.List;

import org.lessons.java.spring.models.Pizza;
import org.lessons.java.spring.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Pizza> pizzas = Arrays.asList(new Pizza("Pizza Margherita", "/images/margherita.jpg", 6f),
				new Pizza("Pizza ai Quattro Formaggi", "/images/quattro-formaggi.jpg", 7.5f),
				new Pizza("Pizza Capricciosa", "/images/capricciosa.jpg", 8.5f),
				new Pizza("Pizza Tonno e Cipolla", "/images/tonno-cipolla.jpg", 9f),
				new Pizza("Pizza ai Funghi", "/images/funghi.jpg", 8.5f),
				new Pizza("Pizza al Salmone", "/images/salmone.webp", 9f));
		pizzaService.saveAll(pizzas);

	}
}
