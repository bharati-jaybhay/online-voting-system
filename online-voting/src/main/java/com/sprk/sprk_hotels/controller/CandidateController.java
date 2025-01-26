package com.sprk.sprk_hotels.controller;

import com.sprk.sprk_hotels.model.Candidate;
import com.sprk.sprk_hotels.service.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.regex.Pattern;

@Controller
@AllArgsConstructor
public class CandidateController {

    private CandidateService candidateService;

    @GetMapping("/voting/add")
    public String showAddForm(Model model) {
        Candidate candidate = new Candidate();
        model.addAttribute("candidate", candidate);
        return "candidate-form";
    }

    @PostMapping("/voting")
    public String saveListing(@RequestParam(name = "id") String idStr, @Valid @ModelAttribute Candidate candidate, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        // Handling Server Side validation
        if (bindingResult.hasErrors()) {
            return "candidate-form";
        }

        String regex = "^\\d+$";
        if (Pattern.matches(regex, idStr)) {

            // Save to DB
            int id = Integer.parseInt(idStr);
            candidate.setId(id);
            candidateService.saveCandidate(candidate);
            if (id != 0) {
                redirectAttributes.addFlashAttribute("successMessage", "Your candidate update successfully");
                return "redirect:/voting/view/" + id;
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Your candidate added successfully");
                return "redirect:/voting/add";
            }

        } else {
            redirectAttributes.addFlashAttribute("errorMessage","Id cna not be String!");
            return "redirect:/candidates";
        }

    }

    @GetMapping(value= {"/","/votings"})
    public String showAllHotels(Model model) {
        List<Candidate> candidates = candidateService.getAllCandidates();
        model.addAttribute("allCandidates", candidates);

        return "index";
    }

    @GetMapping("/voting/view/{id}")
    public String showCandidateById(@PathVariable("id") String idStr, Model model, RedirectAttributes redirectAttributes) {

        String regex = "^\\d+$";
        if (Pattern.matches(regex, idStr)) {
            int id = Integer.parseInt(idStr);
            Candidate candidate = candidateService.getCandidateById(id);

            if (candidate != null) {
                model.addAttribute("candidate", candidate);
                return "show-candidates";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Your candidate not found in our record!");
                return "redirect:/candidates";
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Id cannot be string!");
            return "redirect:/candidates";
        }
    }

    // delete by id
    @GetMapping("/voting/delete")
    public String deleteCandidate(@RequestParam(name = "id") String idStr, RedirectAttributes redirectAttributes) {

        String regex = "^\\d+$";
        if (Pattern.matches(regex, idStr)) {
            int id = Integer.parseInt(idStr);
            Candidate  candidate = candidateService.getCandidateById(id);

            if (candidate != null) {
                // delete
                candidateService.deleteCandidateById(id);
                redirectAttributes.addFlashAttribute("errorMessage", "Candidate Deleted Successfully!");
                return "redirect:/candidates";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Your candidate not found in our record!");
                return "redirect:/candidates";
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Id cannot be string!");
            return "redirect:/candidates";
        }
    }

    // update by id
    @GetMapping("/voting/edit")
    public String showUpdateForm(@RequestParam(name = "id") String idStr, RedirectAttributes redirectAttributes, Model model) {

        String regex = "^\\d+$";
        if (Pattern.matches(regex, idStr)) {
            int id = Integer.parseInt(idStr);
            Candidate candidate = candidateService.getCandidateById(id);

            if (candidate != null) {
                model.addAttribute("candidate", candidate);
                model.addAttribute("btn_name", "Update");
                return "candidate-form";

            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Your candidate not found in our record!");
                return "redirect:/candidates";
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Id cannot be string!");
            return "redirect:/candidates";
        }
    }

}
