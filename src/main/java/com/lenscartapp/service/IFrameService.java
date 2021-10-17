package com.lenscartapp.service;
/**
 * @author SumanD
 *
 */
import java.util.List;

import com.lenscartapp.exception.FrameNotFoundException;
import com.lenscartapp.model.Frame;

public interface IFrameService {
	Frame addframe(Frame frame);
	void updateFrame(Frame frame);
	void deleteFrame(int frameId);
	List<Frame> getall();
	
	Frame getById(int id)throws FrameNotFoundException;
	
	List<Frame> getByLensBrand(String lensbrand) throws FrameNotFoundException;
	List<Frame> getByLensPower(String lenspower) throws FrameNotFoundException;
    List<Frame> getByBrandShpae(String shape) throws FrameNotFoundException;
    
	List<Frame> getByBrandPrice(double price) throws FrameNotFoundException;
	List<Frame> getByBrandPriceAndBrandBrandName(double price,String name) throws FrameNotFoundException;
	
	List<Frame> getByCategoryCategoryNameAndCategoryMaterial(String name,String material) throws FrameNotFoundException;
}
