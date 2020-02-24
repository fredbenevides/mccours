package com.fredbenevides.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fredbenevides.cursomc.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> listing() {

		Category cat1 = new Category(1, "Informatique");
		Category cat2 = new Category(2, "Bureau");

		List<Category> list = new ArrayList<>();

		list.add(cat1);
		list.add(cat2);
		return list;
	}

}