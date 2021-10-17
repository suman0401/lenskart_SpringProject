package com.lenscartapp.repository;
/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenscartapp.model.Lens;
@Repository
public interface ILensRepository extends JpaRepository<Lens, Integer> {
	
	List<Lens> findByFrameColor(String color);
	List<Lens> findByFrameName(String name);

}
