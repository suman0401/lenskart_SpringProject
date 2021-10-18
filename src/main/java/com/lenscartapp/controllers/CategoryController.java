package com.lenscartapp.controllers;

/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenscartapp.model.Category;
import com.lenscartapp.service.ICategoryService;

@RestController
@RequestMapping("/category-service")
public class CategoryController {
	@Autowired
	ICategoryService categoryService;

	@PostMapping("/lenskart/category")
	Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);

	}

	@PutMapping("/lenskart/category")
	void updateCategory(Category category) {
		categoryService.updateCategory(category);
	}

	@DeleteMapping("/lenskart/category/{categoryId}")
	void deleteCategory(@PathVariable("categoryId") int categoryId) {
		categoryService.deleteCategory(categoryId);
	}

	@GetMapping("/lenskart")
	List<Category> getall() {
		return categoryService.getall();

	}

	@GetMapping("/lenskart-category/framesize/{framesize}")
	List<Category> findByFrameFrameSize(@PathVariable("framesize") String framesize) {
		return categoryService.getByFrameFrameSize(framesize);

	}
	@GetMapping("/lenskart-category/color/{color}/gender/{gender}")
	List<Category> getByFramecolorAndGender(@PathVariable("color") String color,@PathVariable("gender") String gender) {
		return categoryService.getByFramecolorAndGender(color,gender);

	}


}
