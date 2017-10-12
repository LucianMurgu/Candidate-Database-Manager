package com.bdManager.entity;

import java.util.List;

public interface CandidateDAO {
	
	public List<Candidate> getCandidates();

	public void saveCandidate(Candidate theCandidate);

	public Candidate getCandidate(int theId);

	public void deleteCustomer(int theId);

}
