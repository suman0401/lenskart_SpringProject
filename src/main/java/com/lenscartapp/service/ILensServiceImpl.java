package com.lenscartapp.service;
/**
 * @author SumanD
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscartapp.exception.LensNotFoundException;
import com.lenscartapp.model.Lens;
import com.lenscartapp.repository.ILensRepository;

@Service
public class ILensServiceImpl implements ILensService {
	@Autowired
	ILensRepository lensRepository;

	@Override
	public Lens addLens(Lens lens) {
		return lensRepository.save(lens);
	}

	@Override
	public void updateLens(Lens lens) {
		lensRepository.save(lens);
	}

	@Override
	public void deleteLens(int lensId) {
		lensRepository.deleteById(lensId);
	}

	@Override
	public List<Lens> getall() {
		return lensRepository.findAll();
	}

	@Override
	public List<Lens> getByFrameColor(String color) throws LensNotFoundException {
		List<Lens> lensList = lensRepository.findByFrameColor(color);
		if (lensList.isEmpty()) {
			throw new LensNotFoundException("Invalid Lens");
		}
		return lensList;
	}

	@Override
	public List<Lens> getByFrameName(String name) throws LensNotFoundException {
		List<Lens> lensList = lensRepository.findByFrameName(name);
		if (lensList.isEmpty()) {
			throw new LensNotFoundException("Invalid Lens");
		}
		return lensList;
	}

}
