package org.lessons.java.spring.controllers;

import java.util.List;

import org.lessons.java.spring.models.Pizza;
import org.lessons.java.spring.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaController {
	@Autowired
	public PizzaService pizzaService;

	@GetMapping("/")
	public String index(Model model) {
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);

		return "index.html";
	}

	@GetMapping("/error")
	public String error() {
		return "error.html";
	}
}
