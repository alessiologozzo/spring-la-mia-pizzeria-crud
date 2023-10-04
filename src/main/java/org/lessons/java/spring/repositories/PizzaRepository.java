package org.lessons.java.spring.repositories;

import org.lessons.java.spring.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}