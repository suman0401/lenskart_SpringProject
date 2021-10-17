package com.lenscartapp.repository;
/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lenscartapp.model.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {
	//@Query("from Brand b inner join b.Frame on where f.color=?1")
	@Query(value = "select * from brand b inner join frame f on b.brand_id=f.frame_id where f.color=?1", nativeQuery = true)
	List<Brand> findByFrameColor(String color);

	// @Query("from Brand b inner join b.Frame f where f.modelId=?1 and f.gender=?2")
	@Query(value = "select * from brand b inner join frame f on b.brand_id=f.frame_id where f.model_id=?1 and f.gender=?2;", nativeQuery = true)
	List<Brand> findByFrameModelIdAndFrameGender(int modelId, String gender);
     
	//@Query("from Brand b inner join b.Frame f on where f.modelId=?1)
	@Query(value = "select * from brand b inner join frame f on b.brand_id=f.frame_id where f.model_id=?1", nativeQuery = true)
	List<Brand> findByFrameModelId(int modelId);

}
