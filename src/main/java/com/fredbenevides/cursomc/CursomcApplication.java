package com.fredbenevides.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fredbenevides.cursomc.domain.Category;
import com.fredbenevides.cursomc.domain.City;
import com.fredbenevides.cursomc.domain.Product;
import com.fredbenevides.cursomc.domain.State;
import com.fredbenevides.cursomc.repositories.CategoryRepository;
import com.fredbenevides.cursomc.repositories.CityRepository;
import com.fredbenevides.cursomc.repositories.ProductRepository;
import com.fredbenevides.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Info");
		Category cat2 = new Category(null, "Escritorio");
		
		Product p1 = new Product(null, "Ordinateur", 2000.00);
		Product p2 = new Product(null, "Imprimante", 800.00);
		Product p3 = new Product(null, "Sourris", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State s1 = new State(null, "Quebec");
		State s2 = new State(null, "Ontario");
		
		City c1 = new City(null, "Montreal", s1);
		City c2 = new City(null, "Trois Rivieres", s1);
		City c3 = new City(null, "Otawa", s2);
		
		s1.getCities().addAll(Arrays.asList(c1, c2));
		s2.getCities().addAll(Arrays.asList(c3));
		
		stateRepository.saveAll(Arrays.asList(s1, s2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
	}
}