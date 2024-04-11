package com.exercise.contactusform.controller;

import com.exercise.contactusform.model.ContactUs;
import com.exercise.contactusform.service.ContactUsMailServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactUsController {
    
    private ContactUsMailServiceInterface contactUsMailService;

    @Autowired
    public ContactUsController(ContactUsMailServiceInterface contactUsMailService) {
        this.contactUsMailService = contactUsMailService;
    }

    @GetMapping("/contactUs")
    public String contactUs(Model model){
        model.addAttribute("contactUs", new ContactUs());
        return "contact-us-form";
    }
    
    @PostMapping("/contactUs")
    public String processEmail(@Valid @ModelAttribute("contactUs") ContactUs contactUs, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "contact-us-form";
        } else{
            contactUsMailService.sendEmail(contactUs);
            return "contact-us-success";
        }
    }
}
