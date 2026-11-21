package com.mycompany.m4a2_adiova;

public class EmailMessage extends Message implements Trackable {

    public EmailMessage(String recipient) {
        super(recipient);
    }

    @Override
    public void send() {
        System.out.println("Sending email to " + getRecipient());
    }

    @Override
    public void showStatus() {
        System.out.println("Email status: Sent");
    }
}
