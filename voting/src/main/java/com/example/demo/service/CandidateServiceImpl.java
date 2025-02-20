package com.example.demo.service;

import com.example.demo.model.Candidate;
import com.example.demo.repository.CandidateRepos;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateService{

    private CandidateRepos candidateRepository;

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
    public Candidate getCandidateById(int id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCandidateById(int id) {
        candidateRepository.deleteById(id);
    }

}
