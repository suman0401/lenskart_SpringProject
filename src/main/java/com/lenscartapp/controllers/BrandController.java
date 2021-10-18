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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenscartapp.model.Brand;
import com.lenscartapp.service.IBrandService;

@RestController
@RequestMapping("/brand-service")
public class BrandController {
	@Autowired
	IBrandService brandservice;

	@PostMapping("/lenskart-brand")
	Brand addbrand(Brand brand) {
		return brandservice.addbrand(brand);

	}

	@PutMapping("/lenskart-brand")
	void updateBrand(Brand brand) {
		brandservice.addbrand(brand);
	}

	@DeleteMapping("/lenskart-brand/{brandId}")
	void deleteBrand(int brandId) {
		brandservice.deleteBrand(brandId);
	}

	@GetMapping("/lenskart-brand")
	List<Brand> getAll() {
		return brandservice.getAll();

	}
	@GetMapping("/lenskart-brand/{brandId}")
	public Brand Viewbrand(@PathVariable("brandId") int brandid) {
		return brandservice.getBrandById(brandid);
		
	}

	@GetMapping("/lenskart-brand/framecolor/{color}")
	List<Brand> getByFrameColor(@PathVariable("color") String color) {
		return brandservice.getByFrameColor(color);

	}

	@GetMapping("/lenskart-brand/name/{name}/gender/{gender}")
	List<Brand> findByFrameModelIdAndFrameGender(@PathVariable("name") String name,
			@PathVariable("gender") String gender) {
		return brandservice.getByNameAndFrameGender(name, gender);

	}
	
	@GetMapping("/lenskart-brand/modelId/{modelId}")
	List<Brand> findByFrameModelId(@PathVariable("modelId") int modelId) {
		return brandservice.getByFrameModelId(modelId);

	}

}
