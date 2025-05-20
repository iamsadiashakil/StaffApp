package com.myhealthteam.staffapp.models;

public class Message {
    private String text;
    private boolean isUserMessage;
    private String timestamp;

    public Message(String text, boolean isUserMessage, String timestamp) {
        this.text = text;
        this.isUserMessage = isUserMessage;
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public boolean isUserMessage() {
        return isUserMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }
}