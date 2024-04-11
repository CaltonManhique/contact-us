package com.exercise.contactusform.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ContactUs {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String fullName;

    @NotNull(message = "Required field")
    @Size(min = 1, message = "Required field")
    @Pattern(regexp = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
            message = "Invalid email.")
    private String email;

    private String phoneNumber;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String subject;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String message;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String terms;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }
}
