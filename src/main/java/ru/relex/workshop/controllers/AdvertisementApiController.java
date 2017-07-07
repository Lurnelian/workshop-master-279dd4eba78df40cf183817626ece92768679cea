package ru.relex.workshop.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import ru.relex.workshop.domain.Advertisement;
import ru.relex.workshop.dto.AdvertisementDto;
import ru.relex.workshop.dto.ExceptionDto;
import ru.relex.workshop.services.AdvertisementService;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementApiController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDto> handleValidationErrro(Exception ex) {
		return new ResponseEntity<ExceptionDto>(new ExceptionDto(ex.getMessage(), ExceptionUtils.getStackTrace(ex)),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AdvertisementDto> addAdvertisement(@Valid @RequestBody AdvertisementDto advertisementDto) {
		
		int affected = advertisementService.createAdvertisement(advertisementDto.toDomain());
		
		return new ResponseEntity<AdvertisementDto>(advertisementDto, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<AdvertisementDto> updateAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
		
		int affected = advertisementService.updateAdvertisement(advertisementDto.toDomain());
		
		return new ResponseEntity<AdvertisementDto>(advertisementDto, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<Object> updateAdvertisement(@PathVariable("id") Long id) {
		int affected = advertisementService.deleteAdvertisement(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AdvertisementDto>> getAdvertisements() {
		List<Advertisement> advertisements = advertisementService.getAllAdvertisements();
		List<AdvertisementDto> advertisementDtos = new ArrayList<>();
		for (Advertisement advertisement : advertisements) {
			advertisementDtos.add(new AdvertisementDto(advertisement));
		}
		return new ResponseEntity<List<AdvertisementDto>>(advertisementDtos, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<AdvertisementDto> getAdvertisementById(@PathVariable("id") Long id) {
		Advertisement advertisement = advertisementService.getAdvertisementById(id);
		return new ResponseEntity<AdvertisementDto>(new AdvertisementDto(advertisement), HttpStatus.OK);
	}

}
