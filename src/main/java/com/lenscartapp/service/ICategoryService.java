package com.lenscartapp.service;
/**
 * @author SumanD
 *
 */
import java.util.List;

import com.lenscartapp.model.Category;

public interface ICategoryService {
	
	Category addCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(int categoryId);
	
	List<Category> getall();
	
	List<Category> findByFrameFrameSize(String framesize);

}
