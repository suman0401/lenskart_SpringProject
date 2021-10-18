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
	ResponseEntity<Brand> addbrand(Brand brand) {
		Brand addbrand = brandservice.addbrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", " Brand Added successfully ");
		return ResponseEntity.ok().headers(headers).body(addbrand);
	}

	@PutMapping("/lenskart-brand")
	ResponseEntity<String> updateBrand(Brand brand) {
		brandservice.addbrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", " Brand Updated Successfully ");
		return ResponseEntity.ok().headers(headers).body("Updated Successfully");
	}

	@DeleteMapping("/lenskart-brand/{brandId}")
	ResponseEntity<String> deleteBrand(int brandId) {
		brandservice.deleteBrand(brandId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Brand ");
		return ResponseEntity.ok().headers(headers).body("Deleted Successfully");
	}

	@GetMapping("/lenskart-brand")
	ResponseEntity<List<Brand>> getAll() {
		List<Brand> brandlist = brandservice.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Brand ");
		return ResponseEntity.ok().headers(headers).body(brandlist);
	}

	@GetMapping("/lenskart-brand/{brandId}")
	public ResponseEntity<Brand> Viewbrand(@PathVariable("brandId") int brandid) {
		Brand brand = brandservice.getBrandById(brandid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Added successfully ");
		return ResponseEntity.ok().headers(headers).body(brand);
	}

	@GetMapping("/lenskart-brand/framecolor/{color}")
	ResponseEntity<List<Brand>> getByFrameColor(@PathVariable("color") String color) {
		List<Brand> brandlist = brandservice.getByFrameColor(color);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Brand By Frame Color ");
		return ResponseEntity.ok().headers(headers).body(brandlist);
	}

	@GetMapping("/lenskart-brand/name/{name}/gender/{gender}")
	ResponseEntity<List<Brand>> findByFrameModelIdAndFrameGender(@PathVariable("name") String name,
			@PathVariable("gender") String gender) {
		List<Brand> brandlist = brandservice.getByNameAndFrameGender(name, gender);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Brand By Frame gender ");
		return ResponseEntity.ok().headers(headers).body(brandlist);
	}

	@GetMapping("/lenskart-brand/modelId/{modelId}")
	ResponseEntity<List<Brand>> findByFrameModelId(@PathVariable("modelId") int modelId) {
		List<Brand> brandlist = brandservice.getByFrameModelId(modelId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Brand By Frame modelId ");
		return ResponseEntity.ok().headers(headers).body(brandlist);
	}

}
