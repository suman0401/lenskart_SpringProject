package com.lenscartapp.controllers;

/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	ResponseEntity<Frame> addframe(@RequestBody Frame frame) {
		Frame addframe = frameService.addframe(frame);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Added successfully ");
		return ResponseEntity.ok().body(addframe);
	}

	@PutMapping("/lenskart")
	ResponseEntity<String> updateFrame(@RequestBody Frame frame) {
		frameService.updateFrame(frame);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Updated Frame successfully ");
		return ResponseEntity.ok().headers(headers).body("Updated successfully");
	}

	@DeleteMapping("/lenskart/frameId/{frameId}")
	ResponseEntity<String> deleteFrame(@PathVariable("frameId") int frameId) {
		frameService.deleteFrame(frameId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Deleted Frame successfully ");
		return ResponseEntity.ok().headers(headers).body("deleted Successfully");
	}

	@GetMapping("/lenskart")
	ResponseEntity<List<Frame>> getall() {
		List<Frame> frameList = frameService.getall();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Frame ");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(frameList);

	}

	@GetMapping("/lenskart/{frameId}")
	ResponseEntity<Frame> getById(@PathVariable("frameId") int id) {
		Frame frame = frameService.getById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Showing Frame By Id ");
		return ResponseEntity.ok().headers(headers).body(frame);

	}

	@GetMapping("/lenskart/LensBrand/{lensbrand}")
	ResponseEntity<List<Frame>> getByLensBrand(@PathVariable("lensbrand") String lensbrand) {
		List<Frame> frameList = frameService.getByLensBrand(lensbrand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Frame By Brand");
		return ResponseEntity.ok().headers(headers).body(frameList);

	}

	@GetMapping("/lenskart/LensPower/{lenspower}")
	ResponseEntity<List<Frame>> getByLensPower(@PathVariable("lenspower") String lenspower) {
		List<Frame> frameList = frameService.getByLensPower(lenspower);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Frame By Lens Power ");
		return ResponseEntity.ok().headers(headers).body(frameList);

	}

	@GetMapping("/lenskart/brandshape/{brandshape}")
	ResponseEntity<List<Frame>> getByBrandShpae(@PathVariable("brandshape") String shape) {
		List<Frame> frameList = frameService.getByBrandShpae(shape);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Frame By Brand Shape ");
		return ResponseEntity.ok().headers(headers).body(frameList);

	}

	@GetMapping("/lenskart/brandprice/{brandprice}")
	ResponseEntity<List<Frame>> getByBrandPrice(@PathVariable("brandprice") double price) {
		List<Frame> frameList = frameService.getByBrandPrice(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Frame ");
		return ResponseEntity.ok().headers(headers).body(frameList);

	}

	@GetMapping("/lenskart/brandprice/{brandprice}/brandname/{brandname}")
	ResponseEntity<List<Frame>> getByBrandPriceAndBrandBrandName(double price, String name) {
		List<Frame> frameList = frameService.getByBrandPriceAndBrandBrandName(price, name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Frame by Brand price And Brand name ");
		return ResponseEntity.ok().headers(headers).body(frameList);

	}

	@GetMapping("/lenskart/categoryname/{categoryname}/material/{material}")
	ResponseEntity<List<Frame>> getByCategoryCategoryNameAndCategoryMaterial(String name, String material) {
		List<Frame> frameList = frameService.getByCategoryCategoryNameAndCategoryMaterial(name, material);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Frame By Category Name ");
		return ResponseEntity.ok().headers(headers).body(frameList);
	}

}
