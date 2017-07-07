package ru.relex.workshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkshopController {

	@RequestMapping("index")
	public ModelAndView hello() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("add-adv")
	public ModelAndView addAdvertisement() {
		return new ModelAndView("add-adv");
	}
	
	@RequestMapping("adv-info/{id}")
	public ModelAndView advertisementInfo(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("adv-info");
		model.addObject("id", id);
		return model;
	}
	
}
