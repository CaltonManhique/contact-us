package com.exercise.contactusform.service;

import com.exercise.contactusform.model.ContactUs;

public interface ContactUsMailServiceInterface {

    boolean sendEmail(ContactUs contactUs);
}
