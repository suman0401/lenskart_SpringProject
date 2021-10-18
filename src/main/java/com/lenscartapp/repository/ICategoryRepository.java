package com.lenscartapp.repository;
/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lenscartapp.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
	@Query("from Category c inner join c.frameList f  where f.framesize=?1")
	//@Query(value = "select * from category c inner join frame f on c.category_id=f.frame_id where f.framesize=?1", nativeQuery = true)
	List<Category> findByFrameFramesize(String framesize);
	
	@Query("from Category c inner join c.frameList f where f.color=?1 and f.gender=?2")
	List<Category> findByFramecolorAndGender(String color,String gender);
	
	
	

}
