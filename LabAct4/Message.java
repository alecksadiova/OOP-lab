package com.mycompany.m4a2_adiova;

public abstract class Message {

    private String recipient;

    public Message(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public abstract void send();
}
