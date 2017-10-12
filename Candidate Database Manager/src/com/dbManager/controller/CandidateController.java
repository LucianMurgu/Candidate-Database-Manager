package com.dbManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdManager.entity.Candidate;
import com.bdManager.entity.CandidateDAO;
import com.dbManager.Service.CandidateService;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@GetMapping("/list")
	public String listCandidates(Model theModel) {
		
		List<Candidate> theCandidates = candidateService.getCandidates();
		
		theModel.addAttribute("candidates", theCandidates);
		return "list-candidates";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		Candidate theCandidate = new Candidate();
		theModel.addAttribute("candidate", theCandidate);
		
		return "candidate-form";
	}
	
	@PostMapping("/saveCandidate")
	public String saveCandidate(@ModelAttribute("candidate") Candidate theCandidate){
		
		candidateService.saveCandidate(theCandidate);
		
		return "redirect:/candidate/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("candidateId") int theId, Model theModel){
		
		Candidate theCandidate = candidateService.getCandidate(theId);
		
		theModel.addAttribute("candidate", theCandidate);
		
		return "candidate-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCandidate(@RequestParam("candidateId") int theId)
	{
		candidateService.deleteCandidate(theId);
		
		return "redirect:/candidate/list" ;
	
	}
	
	
	

}






