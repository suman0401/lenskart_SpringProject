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

import com.lenscartapp.model.Lens;
import com.lenscartapp.service.ILensService;

@RestController
@RequestMapping("lens-service")
public class LensController {
	@Autowired
	ILensService lensService;

	@PostMapping("/lenskart-lens")
	ResponseEntity<Lens> addLens(@RequestBody Lens lens) {
		Lens addlens = lensService.addLens(lens);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Lens By Frame color ");
		return ResponseEntity.ok().headers(headers).body(addlens);
	}

	@PutMapping("/lenskart-lens")
	ResponseEntity<String> updateLens(@RequestBody Lens lens) {
		lensService.updateLens(lens);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Lens By Frame color ");
		return ResponseEntity.ok().headers(headers).body("Lens Updated Successfully");
	}

	@DeleteMapping("/lenskart-lens/{lensId}")
	ResponseEntity<String> deleteLens(int lensId) {
		lensService.deleteLens(lensId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Lens Deleted Successfully ");
		return ResponseEntity.ok().headers(headers).body("Deleted Successfully");
	}

	@GetMapping("/lenskart-lens")
	ResponseEntity<List<Lens>> getall() {
		List<Lens> lensList = lensService.getall();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Lens ");
		return ResponseEntity.ok().headers(headers).body(lensList);
	}

	@GetMapping("/lenskart-lens/framecolor/{color}")
	ResponseEntity<List<Lens>> getByFrameColor(@PathVariable("color") String color) {
		List<Lens> lensList = lensService.getByFrameColor(color);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Lens By Frame color ");
		return ResponseEntity.ok().headers(headers).body(lensList);
	}

	@GetMapping("/lenskart-lens/framename/{framename}")
	ResponseEntity<List<Lens>> getByFrameName(@PathVariable("framename") String name) {
		List<Lens> lensList = lensService.getByFrameName(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Lens By Frame Name ");
		return ResponseEntity.ok().headers(headers).body(lensList);

	}

}
