package com.example.projectdemex.controller;

import com.example.projectdemex.model.Complaint;
import com.example.projectdemex.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping("/complaint")
    public String getAllComplaints(Model model) {
        List<Complaint> complaints = complaintService.getAllComplaints();
        model.addAttribute("complaint", complaints);
        return "complaint";
    }

    @GetMapping("/complaint/add")
    public String showAddComplaintForm(Model model) {
        model.addAttribute("complaint", new Complaint());
        return "add_complaint";
    }

    @PostMapping("/complaint/create")
    public String createComplaint(@ModelAttribute("complaint") Complaint complaint) {
        complaintService.createComplaint(complaint);
        return "redirect:/complaint";
    }

    @PostMapping("/complaint/delete/{id}")
    public String deleteComplaint(@PathVariable("id") Long id) {
        complaintService.deleteComplaint(id);
        return "redirect:/complaint";
    }
}