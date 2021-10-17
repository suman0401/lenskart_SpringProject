package com.lenscartapp.repository;
/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lenscartapp.model.Frame;

@Repository
public interface IFrameRepository extends JpaRepository<Frame, Integer> {
	List<Frame> findByLensLensBrand(String lensbrand);

	List<Frame> findByLensLensPower(String lenspower);

	List<Frame> findByBrandShape(String shape);

	List<Frame> findByBrandPrice(double price);

	List<Frame> findByBrandPriceAndBrandBrandName(double price, String name);

	//@Query("from Frame f inner join f.category c on where c.categoryName=?1 and c.material=?2")
	@Query(value = " select * from frame f inner join category c on f.frame_id=c.category_id where c.category_name=?1 and c.material=?2", nativeQuery = true)
	List<Frame> findByCategoryCategoryNameAndCategoryMaterial(String name, String material);
  
	
}
