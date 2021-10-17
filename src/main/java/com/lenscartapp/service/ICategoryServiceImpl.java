package com.lenscartapp.service;
/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Category> findByFrameFrameSize(String framesize) {
		return categoryRepository.findByFrameFramesize(framesize);
	}

}
