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

import com.lenscartapp.model.Lens;
import com.lenscartapp.service.ILensService;

@RestController
@RequestMapping("lens-service")
public class LensController {
	@Autowired
	ILensService lensService;
	@PostMapping("/lenskart-lens")
	Lens addLens(@RequestBody Lens lens) {
		return lensService.addLens(lens);
		
	}
	@PutMapping("/lenskart-lens")
	void updateLens(@RequestBody Lens lens) {
		lensService.updateLens(lens);
	}
	@DeleteMapping("/lenskart-lens/{lensId}")
	void deleteLens(int lensId) {
		lensService.deleteLens(lensId);
	}
	@GetMapping("/lenskart-lens")
	List<Lens> getall(){
		return lensService.getall();
		
	}
	@GetMapping("/lenskart-lens/framecolor/{color}")
	List<Lens> getByFrameColor(@PathVariable("color") String color){
		return lensService.getByFrameColor(color);
		
	}
	@GetMapping("/lenskart-lens/framename/{framename}")
	List<Lens> getByFrameName(@PathVariable("framename") String name){
		return lensService.getByFrameName(name);
		
	}

}
