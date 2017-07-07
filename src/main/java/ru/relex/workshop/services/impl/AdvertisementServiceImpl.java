package ru.relex.workshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.relex.workshop.domain.Advertisement;
import ru.relex.workshop.repositories.AdvertisementRepository;
import ru.relex.workshop.services.AdvertisementService;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
	
	@Autowired
	private AdvertisementRepository advertisementRepository;

	@Override
	public int createAdvertisement(Advertisement advertisement) {
		return advertisementRepository.createAdvertisement(advertisement);
	}

	@Override
	public int deleteAdvertisement(Long id) {
		return advertisementRepository.deleteAdvertisement(id);
	}

	@Override
	public List<Advertisement> getAllAdvertisements() {
		return advertisementRepository.getAllAdvertisements();
	}

	@Override
	public int updateAdvertisement(Advertisement advertisement) {
		return advertisementRepository.updateAdvertisement(advertisement);
	}

	@Override
	public Advertisement getAdvertisementById(Long id) {
		return advertisementRepository.getAdvertisementById(id);
	}

}
