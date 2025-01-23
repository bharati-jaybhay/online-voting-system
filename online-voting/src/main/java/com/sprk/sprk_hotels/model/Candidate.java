package com.sprk.sprk_hotels.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Please enter title")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    private String candidateName;

    @NotBlank(message = "Please enter party name")
    @Size(min = 10, max = 255, message = "Description must be between 10 and 255 characters")
    private String partyName;

    @NotBlank(message = "Please enter image URL")
    private String imageUrl;

}
