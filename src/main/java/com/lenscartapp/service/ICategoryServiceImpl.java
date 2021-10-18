package com.lenscartapp.service;

/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscartapp.exception.CategoryNotFoundException;
import com.lenscartapp.model.Category;
import com.lenscartapp.repository.ICategoryRepository;

@Service
public class ICategoryServiceImpl implements ICategoryService {
	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public List<Category> getall() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> getByFrameFrameSize(String framesize) {
		List<Category> categorylist = categoryRepository.findByFrameFramesize(framesize);
		if (categorylist.isEmpty()) {
			throw new CategoryNotFoundException("Invalid frame size with category");
		}
		return categorylist;
	}

	@Override
	public List<Category> getByFramecolorAndGender(String color, String gender) {
		List<Category> categorylist = categoryRepository.findByFramecolorAndGender(color, gender);
		if (categorylist.isEmpty()) {
			throw new CategoryNotFoundException("Invalid frame color and gender with category");
		}
		return categorylist;
	}

}
