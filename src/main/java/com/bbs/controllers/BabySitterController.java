package com.bbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.dao.IBabySitterRepository;
import com.bbs.entities.BabySitter;

@Controller
@RequestMapping("/babysitters")
public class BabySitterController {
	
	@Autowired
	IBabySitterRepository babysitterRepository; 
	
	@GetMapping("/create")
	public String diplayBabysitterForm(Model model) {
		
		BabySitter babySitter = new BabySitter(); 
		model.addAttribute("babysitter", babySitter);
		
		return "new-babysitter";
		
	}
	
	@PostMapping("/save")
	public String CreateBabySitter(BabySitter babySitter, Model model) {
		
		int startTimeCalulation = (babySitter.bedTime - babySitter.startTime) * 12; 
		int bedtimeCalulation = (babySitter.endTime - babySitter.bedTime);
		int endOfJobCalculation = Math.abs(12 - babySitter.endTime);
		int bedTimeHours = bedtimeCalulation * 8;
		 int overNightHours = endOfJobCalculation * 16;
		
		if (babySitter.endTime >= 12) {
			bedtimeCalulation = Math.abs((12 - babySitter.bedTime)); // stop counting at midnight
			bedTimeHours = bedtimeCalulation * 8;
			
			 babySitter.nightlyCharge = startTimeCalulation + bedTimeHours + overNightHours;
		}
		else {
			babySitter.nightlyCharge = startTimeCalulation + bedTimeHours; 
		}
		
		//save to db
		babysitterRepository.save(babySitter);
		return "redirect:/babysitters/create";
	}

}
