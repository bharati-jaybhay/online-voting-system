package com.sprk.sprk_hotels.service;

import com.sprk.sprk_hotels.model.Candidate;
import com.sprk.sprk_hotels.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateService{

    private CandidateRepository candidateRepository;

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        Candidate savedCandidate = candidateRepository.save(candidate);
        return savedCandidate;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate getListingById(int id) {
        return candidateRepository.findById(id).orElse(null);
    }

}
