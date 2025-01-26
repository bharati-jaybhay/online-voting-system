package com.sprk.sprk_hotels.service;

import com.sprk.sprk_hotels.model.Candidate;
import jakarta.validation.Valid;

import java.util.List;

public interface CandidateService {

    Candidate saveCandidate(Candidate candidate);

    List<Candidate> getAllCandidates();

    Candidate getCandidateById(int id);

    void deleteCandidateById(int id);
}
