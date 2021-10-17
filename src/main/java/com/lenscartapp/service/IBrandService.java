package com.lenscartapp.service;
/**
 * @author SumanD
 *
 */
import java.util.List;

import com.lenscartapp.exception.BrandNotFoundException;
import com.lenscartapp.model.Brand;

public interface IBrandService {
	Brand addbrand(Brand brand);
	void updateBrand(Brand brand);
	void deleteBrand(int brandId);
	
	List<Brand> getAll();
	Brand getBrandById(int brandid)throws BrandNotFoundException;
	
	List<Brand> getByFrameColor(String color) throws BrandNotFoundException;
	List<Brand> getByFrameModelIdAndFrameGender(int modelId,String gender)throws BrandNotFoundException;
	List<Brand> getByFrameModelId(int modelId)throws BrandNotFoundException;

}
