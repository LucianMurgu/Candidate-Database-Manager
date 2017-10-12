package com.dbManager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdManager.entity.Candidate;
import com.bdManager.entity.CandidateDAO;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateDAO candidateDAO;
	
	@Override
	@Transactional
	public List<Candidate> getCandidates() {
		
		return candidateDAO.getCandidates();
	}

	@Override
	public void saveCandidate(Candidate theCandidate) {
		candidateDAO.saveCandidate(theCandidate);
		
	}

	@Override
	@Transactional
	public Candidate getCandidate(int theId) {
		
		return candidateDAO.getCandidate(theId);
	}

	@Override
	@Transactional
	public void deleteCandidate(int theId) {
		candidateDAO.deleteCustomer(theId);
	}

}
