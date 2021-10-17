package com.lenscartapp.service;
/**
 * @author SumanD
 *
 */
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscartapp.exception.FrameNotFoundException;
import com.lenscartapp.model.Frame;
import com.lenscartapp.repository.IFrameRepository;

@Service
public class IFrameServiceImpl implements IFrameService {
	@Autowired
	IFrameRepository frameRepository;

	@Override
	public List<Frame> getByLensBrand(String lensbrand) {
		return frameRepository.findByLensLensBrand(lensbrand);
	}

	@Override
	public List<Frame> getByLensPower(String lenspower) {
		return frameRepository.findByLensLensPower(lenspower);
	}

	@Override
	public Frame addframe(Frame frame) {
		return frameRepository.save(frame);
	}

	@Override
	public void updateFrame(Frame frame) {
		frameRepository.save(frame);
	}

	@Override
	public void deleteFrame(int frameId) {
		frameRepository.deleteById(frameId);
	}

	@Override
	public List<Frame> getByBrandShpae(String shape) throws FrameNotFoundException {
		List<Frame> frameList = frameRepository.findByBrandShape(shape).stream()
				.filter((frame) -> frame.getBrand().getShape().equalsIgnoreCase(shape)).collect(Collectors.toList());
		if (frameList.isEmpty()) {
			throw new FrameNotFoundException("Invalid frame shape");
		}
		return frameList;
	}

	@Override
	public List<Frame> getall() {
		return frameRepository.findAll();
	}

	@Override
	public List<Frame> getByBrandPrice(double price) throws FrameNotFoundException {
		List<Frame> frameList = frameRepository.findByBrandPrice(price).stream()
				.filter((frame) -> frame.getBrand().getPrice() <= price).toList();
		if (frameList.isEmpty()) {
			throw new FrameNotFoundException("invalid frame price");
		}
		return frameList;
	}

	@Override
	public List<Frame> getByBrandPriceAndBrandBrandName(double price, String name) {

		List<Frame> frameList = frameRepository.findByBrandPriceAndBrandBrandName(price, name).stream()
				.filter((frame) -> frame.getBrand().getPrice() <= price)
				.filter((mframe) -> mframe.getBrand().getBrandName().equals(name)).collect(Collectors.toList());
		if (frameList.isEmpty()) {
			throw new FrameNotFoundException("Invalid brand price and brand name");
		}
		return frameList;
	}

	@Override
	public List<Frame> getByCategoryCategoryNameAndCategoryMaterial(String name, String material) {
		List<Frame> frameList = frameRepository.findByCategoryCategoryNameAndCategoryMaterial(name, material);
		if (frameList.isEmpty()) {
			throw new FrameNotFoundException("Invalid category name and category material");
		}
		return frameList;
	}

	@Override
	public Frame getById(int id)throws FrameNotFoundException {
		Frame frame= frameRepository.findById(id).get();
		if(frame==null) {
			throw new FrameNotFoundException("Invalid Id");
		}
		return frame;
	}

}
