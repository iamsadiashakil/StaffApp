package java.com.myhealthteam.staffapp.models;

public class Message {
    private String messageText;
    private String sender; // "user" or "doctor"
    private String timestamp;

    public Message(String messageText, String sender, String timestamp) {
        this.messageText = messageText;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getSender() {
        return sender;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
