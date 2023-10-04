package org.lessons.java.spring.services;

import java.util.List;

import org.lessons.java.spring.models.Pizza;
import org.lessons.java.spring.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	@Autowired
	private PizzaRepository pizzaRepository;

	public List<Pizza> findAll() {
		return pizzaRepository.findAll();
	}

	public void save(Pizza pizza) {
		pizzaRepository.save(pizza);
	}

	public void saveAll(List<Pizza> pizzas) {
		pizzaRepository.saveAll(pizzas);
	}
}
