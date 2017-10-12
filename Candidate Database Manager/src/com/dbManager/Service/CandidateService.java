package com.dbManager.Service;

import java.util.List;

import com.bdManager.entity.Candidate;

public interface CandidateService {

	public List<Candidate> getCandidates();

	public Candidate getCandidate(int theId);

	public void saveCandidate(Candidate theCandidate);

	public void deleteCandidate(int theId);
}
