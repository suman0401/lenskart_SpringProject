package com.lenscartapp.service;
/**
 * @author SumanD
 *
 */
import java.util.List;

import com.lenscartapp.exception.LensNotFoundException;
import com.lenscartapp.model.Lens;

public interface ILensService {
	
	Lens addLens(Lens lens);
	void updateLens(Lens lens);
	void deleteLens(int lensId);
	
	List<Lens> getall();
	
	List<Lens> getByFrameColor(String color)throws LensNotFoundException;
	List<Lens> getByFrameName(String name)throws LensNotFoundException;


}
