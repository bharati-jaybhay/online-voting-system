package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@ToString
@Getter
@Setter
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Candidate name is required")
    private String candidateName;

    @NotEmpty(message = "Party name is required")
    private String partyName;

    @NotBlank(message = "Invalid URL")
    private String imageUrl;

    public @NotEmpty(message = "Candidate name is required") String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(@NotEmpty(message = "Candidate name is required") String candidateName) {
        this.candidateName = candidateName;
    }

    public @NotEmpty(message = "Party name is required") String getPartyName() {
        return partyName;
    }

    public void setPartyName(@NotEmpty(message = "Party name is required") String partyName) {
        this.partyName = partyName;
    }
}
