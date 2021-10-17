package com.lenscartapp;
/**
 * @author SumanD
 *
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lenscartapp.model.Brand;
import com.lenscartapp.model.Category;
import com.lenscartapp.model.Frame;
import com.lenscartapp.model.Lens;
import com.lenscartapp.service.IBrandService;
import com.lenscartapp.service.ICategoryService;
import com.lenscartapp.service.IFrameService;
import com.lenscartapp.service.ILensService;

@SpringBootApplication
public class SpringLenscartRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringLenscartRestapiApplication.class, args);
	}

	@Autowired
	IFrameService frameService;
	@Autowired
	ILensService lensService;
	@Autowired
	IBrandService brandService;
	@Autowired
	ICategoryService categoryService;

	@Override
	public void run(String... args) throws Exception {

		// FOR FRAME LENS AND BRAND AND CATEGORY

		// -----------------------------------WORKING--------------------------------------------------
//		Lens lens1 = new Lens("crizal", "single");
//		Lens lens2 = new Lens("crizal", "double");
//		Lens lens3 = new Lens("aqualens", "zero");
//		Lens lens4 = new Lens("alcon", "double");
//		Lens lens5 = new Lens("essilor", "zero");
//
//		Brand brand1 = new Brand("oval", "fullrim", "Vincent Chase", 2000d);
//		Brand brand2 = new Brand("rectangle", "halfrim", "Vincent Chase", 3000d);
//		Brand brand3 = new Brand("square", "rimless", "Ray-Ban", 2500d);
//		Brand brand4 = new Brand("hexagon", "fullrim", "Air Vincent Chase", 3500d);
//		Brand brand5 = new Brand("square", "halfrim", "Calvin klein", 5000d);
//		Category category1 = new Category("Eyeglass", "Silver");
//		categoryService.addCategory(category1);
//		Category category2 = new Category("Computerglass", "Silver");
//		categoryService.addCategory(category2);
//		Category category3 = new Category("Sunglass", "Fiber");
//		categoryService.addCategory(category3);
//		Category category4 = new Category("Kidsglass", "plastic");
//		categoryService.addCategory(category4);
//		Category category5 = new Category("Cylindricalglass", "Fiber");
//		categoryService.addCategory(category5);
//		Set<Category> categoryList = new HashSet<>(
//				Arrays.asList(category1, category2, category3, category4, category5));
//
//		Frame frame1 = new Frame(10, "Red flex", "medium", "Red", "Male", lens1, brand1, categoryList);
//		Frame frame2 = new Frame(20, "Blue Transparant", "wide", "Blue", "Female", lens2, brand2, categoryList);
//		Frame frame3 = new Frame(30, "Brown Tortoise", "narrow", "Brown", "Unisex", lens3, brand3, categoryList);
//		Frame frame4 = new Frame(40, "Air tight", "small", "Red", "Male", lens4, brand4, categoryList);
//		Frame frame5 = new Frame(50, "Black knight", "medium", "Black", "female", lens5, brand5, categoryList);
//
//		frameService.addframe(frame1);
//		frameService.addframe(frame2);
//		frameService.addframe(frame3);
//		frameService.addframe(frame4);
//		frameService.addframe(frame5);

//-----------------------------------------------WORKING END----------------------------------------------

		// FOR FRAME TABLE AND CATEGORY TABLE

//		Category category1 = new Category("Eyeglass", "Silver");
//		categoryService.addCategory(category1);
//		Category category2 = new Category("Computerglass", "Silver");
//		categoryService.addCategory(category2);
//		Set<Category> categoryList = new HashSet<>(Arrays.asList(category1, category2));
//
//		Frame Frame = new Frame(1, "name", "framesize", "color", "gender", categoryList);
//		frameService.addframe(Frame);

	}

}
