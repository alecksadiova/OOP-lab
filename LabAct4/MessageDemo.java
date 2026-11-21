package com.mycompany.m4a2_adiova;

public class MessageDemo {

    public static void main(String[] args) {

        EmailMessage email = new EmailMessage("aaadiova@fit.edu.ph");
        SmsMessage sms = new SmsMessage("09123456789");

        Message[] messages = {email, sms};

        System.out.println("=== Campus Message Dispatcher ===");

        System.out.println("\nTest 1:");
        for (Message message : messages) {
            message.send();
        }

        System.out.println("\nTest 2:");
        Trackable track = email;
        track.showStatus();
    }
}
