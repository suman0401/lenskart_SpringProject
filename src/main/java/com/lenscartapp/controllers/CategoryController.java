package com.lenscartapp.controllers;

/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category addcategory = categoryService.addCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Updated Frame successfully ");
		return ResponseEntity.ok().headers(headers).body(addcategory);
	}

	@PutMapping("/lenskart/category")
	ResponseEntity<String> updateCategory(Category category) {
		categoryService.updateCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Updated Category successfully ");
		return ResponseEntity.ok().headers(headers).body("Updated Successfully");
	}

	@DeleteMapping("/lenskart/category/{categoryId}")
	ResponseEntity<String> deleteCategory(@PathVariable("categoryId") int categoryId) {
		categoryService.deleteCategory(categoryId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Deleted Category successfully ");
		return ResponseEntity.ok().headers(headers).body("Deleted Successfully");
	}

	@GetMapping("/lenskart")
	ResponseEntity<List<Category>> getall() {
		List<Category> categorylist = categoryService.getall();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Updated Frame successfully ");
		return ResponseEntity.ok().headers(headers).body(categorylist);
	}

	@GetMapping("/lenskart-category/framesize/{framesize}")
	ResponseEntity<List<Category>> findByFrameFrameSize(@PathVariable("framesize") String framesize) {
		List<Category> categorylist = categoryService.getByFrameFrameSize(framesize);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Category By Frame size  ");
		return ResponseEntity.ok().headers(headers).body(categorylist);
	}

	@GetMapping("/lenskart-category/color/{color}/gender/{gender}")
	ResponseEntity<List<Category>> getByFramecolorAndGender(@PathVariable("color") String color,
			@PathVariable("gender") String gender) {
		List<Category> categorylist = categoryService.getByFramecolorAndGender(color, gender);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Updated Frame successfully ");
		return ResponseEntity.ok().headers(headers).body(categorylist);
	}

}
