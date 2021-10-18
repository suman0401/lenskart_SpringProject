package com.lenscartapp.service;
/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscartapp.exception.BrandNotFoundException;
import com.lenscartapp.model.Brand;
import com.lenscartapp.repository.IBrandRepository;

@Service
public class IBrandServiceImpl implements IBrandService {
	@Autowired
	IBrandRepository brandRepository;

	@Override
	public Brand addbrand(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public void updateBrand(Brand brand) {
		brandRepository.save(brand);
	}

	@Override
	public void deleteBrand(int brandId) {
		brandRepository.deleteById(brandId);
	}

	@Override
	public List<Brand> getAll() {
		return brandRepository.findAll();
	}

	@Override
	public List<Brand> getByFrameColor(String color) throws BrandNotFoundException {
		List<Brand> brandList = brandRepository.findByFrameColor(color);
		if (brandList.isEmpty()) {
			throw new BrandNotFoundException("Invalid brand with frame color");
		}
		return brandList;
	}

	@Override
	public List<Brand> getByNameAndFrameGender(String name, String gender) throws BrandNotFoundException {
		List<Brand> brandList = brandRepository.findByNameAndFrameGender(name, gender);
		if (brandList.isEmpty()) {
			throw new BrandNotFoundException("Invalid brand with frame name and gender");
		}
		return brandList;
	}

	@Override
	public List<Brand> getByFrameModelId(int modelId) throws BrandNotFoundException {
		List<Brand> brandList = brandRepository.findByFrameModelId(modelId);
		if (brandList.isEmpty()) {
			throw new BrandNotFoundException("Invalid brand with frame color");
		}
		return brandList;
	}

	@Override
	public Brand getBrandById(int brandid) throws BrandNotFoundException {
		Brand brand=brandRepository.findById(brandid).get();
		if(brand==null) {
			throw new BrandNotFoundException("Invalid brand id");
		}
		return brand;
	}

}
