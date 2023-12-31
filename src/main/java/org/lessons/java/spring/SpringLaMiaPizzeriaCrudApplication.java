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
		List<Pizza> pizzas = Arrays.asList(
				new Pizza("Pizza Margherita", "Pomodoro, fior di latte, basilico fresco, sale, olio",
						"/images/margherita.jpg", 6f),
				new Pizza("Pizza Quattro Formaggi",
						"Farina, sale, olio, pomodoro, mozzarella, gorgonzola, fontina, parmigiano reggiano",
						"/images/quattro-formaggi.jpg", 7.5f),
				new Pizza("Pizza Capricciosa", "Pomodoro, mozzarella, prosciutto cotto, funghi, olive, carciofini",
						"/images/capricciosa.jpg", 8.5f),
				new Pizza("Pizza Tonno e Cipolla", "Farina, sale, olio, pomodoro, mozzarella, tonno, cipolla",
						"/images/tonno-cipolla.jpg", 9f),
				new Pizza("Pizza ai Funghi", "Pomodoro, farina, sale, olio, fior di latte, funghi",
						"/images/funghi.jpg", 8.5f),
				new Pizza("Pizza al Salmone", "Pomodoro, farina, sale, olio, fior di latte, salmone",
						"/images/salmone.webp", 9f),
				new Pizza("Pizza alla Marinara", "Farina, pomodoro, olio, aglio, origano", "/images/marinara.jpg", 7.f),
				new Pizza("Pizza Quattro Stagioni",
						"Pomodoro, olio, origano, funghi, basilico, prosciutto cotto, olive, fior di latte, salame",
						"/images/quattro_stagioni.jpg", 9.5f));
		pizzaService.saveAll(pizzas);

	}
}
