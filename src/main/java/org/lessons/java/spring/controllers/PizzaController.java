package org.lessons.java.spring.controllers;

import java.util.Comparator;
import java.util.List;

import org.lessons.java.spring.models.Pizza;
import org.lessons.java.spring.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class PizzaController {
	@Autowired
	public PizzaService pizzaService;

	@GetMapping("/")
	public String index(Model model, @RequestParam(required = false) String name,
			@RequestParam(required = false) String orderBy) {
		List<Pizza> pizzas = null;
		boolean search = false;
		String oldOrderBy = "default";

		if (name == null || name.equals(""))
			pizzas = pizzaService.findAll();
		else {
			pizzas = pizzaService.findByNameContaining(name);
			search = true;
		}

		if (orderBy != null) {
			oldOrderBy = orderBy;

			if (orderBy.equals("asc"))
				pizzas = orderPizzasAsc(pizzas);

			else if (orderBy.equals("desc"))
				pizzas = orderPizzasDesc(pizzas);
		}

		model.addAttribute("pizzas", pizzas);
		model.addAttribute("search", search);
		model.addAttribute("oldName", name);
		model.addAttribute("oldOrderBy", oldOrderBy);

		return "index.html";
	}

	@GetMapping("/pizza/{id}")
	public String show(@PathVariable long id, Model model) {
		model.addAttribute("pizza", pizzaService.findById(id));

		return "show.html";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", Pizza.createEmptyPizza());
		return "create.html";
	}

	@PostMapping("/store")
	public String store(@Valid @ModelAttribute Pizza pizza, BindingResult bindingResult, Model model) {
		String result = "redirect:/";

		if (bindingResult.hasErrors())
			result = "create.html";
		else
			pizzaService.save(pizza);

		return result;
	}

	@GetMapping("/error")
	public String error() {
		return "error.html";
	}

	private List<Pizza> orderPizzasAsc(List<Pizza> pizzas) {
		return pizzas.stream().sorted(Comparator.comparingDouble(Pizza::getPrice)).toList();
	}

	private List<Pizza> orderPizzasDesc(List<Pizza> pizzas) {
		return pizzas.stream().sorted(Comparator.comparingDouble(Pizza::getPrice).reversed()).toList();
	}
}
