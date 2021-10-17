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

import com.lenscartapp.model.Frame;
import com.lenscartapp.service.IFrameService;

@RestController
@RequestMapping("/frame-service")
public class FrameController {
	@Autowired
	IFrameService frameService;

	@PostMapping("/lenskart")
	Frame addframe(@RequestBody Frame frame) {
		return frameService.addframe(frame);

	}

	@PutMapping("/lenskart")
	void updateFrame(@RequestBody Frame frame) {
		frameService.updateFrame(frame);

	}

	@DeleteMapping("/lenskart/frameId/{frameId}")
	void deleteFrame(@PathVariable("frameId") int frameId) {
		frameService.deleteFrame(frameId);
	}

	@GetMapping("/lenskart")
	List<Frame> getall() {
		return frameService.getall();

	}

	@GetMapping("/lenskart/{frameId}")
	Frame getById(@PathVariable("frameId") int id) {
		return frameService.getById(id);

	}

	@GetMapping("/lenskart/LensBrand/{lensbrand}")
	List<Frame> getByLensBrand(@PathVariable("lensbrand") String lensbrand) {
		return frameService.getByLensBrand(lensbrand);

	}

	@GetMapping("/lenskart/LensPower/{lenspower}")
	List<Frame> getByLensPower(@PathVariable("lenspower") String lenspower) {
		return frameService.getByLensPower(lenspower);

	}

	@GetMapping("/lenskart/brandshape/{brandshape}")
	List<Frame> getByBrandShpae(@PathVariable("brandshape") String shape) {
		return frameService.getByBrandShpae(shape);

	}

	@GetMapping("/lenskart/brandprice/{brandprice}")
	List<Frame> getByBrandPrice(@PathVariable("brandprice") double price) {
		return frameService.getByBrandPrice(price);

	}

	@GetMapping("/lenskart/brandprice/{brandprice}/brandname/{brandname}")
	List<Frame> getByBrandPriceAndBrandBrandName(double price, String name) {
		return frameService.getByBrandPriceAndBrandBrandName(price, name);

	}

	@GetMapping("/lenskart/categoryname/{categoryname}/material/{material}")
	List<Frame> getByCategoryCategoryNameAndCategoryMaterial(String name, String material) {
		return frameService.getByCategoryCategoryNameAndCategoryMaterial(name, material);

	}

}
