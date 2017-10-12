package com.dbManager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bdManager.entity.Candidate;
import com.bdManager.entity.CandidateDAO;

@Repository
public class CandidateDAOImpl implements CandidateDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Candidate> getCandidates() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Candidate> theQuery = currentSession.createQuery("from Candidate order by lastName", Candidate.class);
		
		
		List<Candidate> candidates = theQuery.getResultList();
		
		return candidates;
		
	}

	@Override
	public void saveCandidate(Candidate theCandidate) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCandidate);
		
	}

	@Override
	public Candidate getCandidate(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Candidate theCandidate = currentSession.get(Candidate.class, theId);
		return null;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete form query where id =: candidateId");
		theQuery.setParameter("candidateId", theId);
		theQuery.executeUpdate();
		
	}

}
