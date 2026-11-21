package com.mycompany.m4a2_adiova;

public class SmsMessage extends Message implements Trackable {

    public SmsMessage(String recipient) {
        super(recipient);
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to " + getRecipient());
    }

    @Override
    public void showStatus() {
        System.out.println("SMS status: Sent");
    }
}
