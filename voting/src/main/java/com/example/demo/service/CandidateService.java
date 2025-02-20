package com.example.demo.service;

import com.example.demo.model.Candidate;

import java.util.List;

public interface CandidateService {

    Candidate saveCandidate(Candidate candidate);

    List<Candidate> getAllCandidates();

    Candidate getCandidateById(int id);

    void deleteCandidateById(int id);
}
