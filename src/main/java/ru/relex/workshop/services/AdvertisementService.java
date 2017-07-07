package ru.relex.workshop.services;

import java.util.List;

import ru.relex.workshop.domain.Advertisement;

public interface AdvertisementService {

	int createAdvertisement(Advertisement advertisement);
	
	int deleteAdvertisement(Long id);
	
	List<Advertisement> getAllAdvertisements();
	
	Advertisement getAdvertisementById(Long id);
	
	int updateAdvertisement(Advertisement advertisement);
	
}
