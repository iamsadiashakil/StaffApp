package java.com.myhealthteam.staffapp.models;

public class Chat {
    private String doctorId;
    private String doctorName;
    private String lastMessage;
    private String messageTime;

    public Chat(String doctorId, String doctorName, String lastMessage, String messageTime) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.lastMessage = lastMessage;
        this.messageTime = messageTime;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getMessageTime() {
        return messageTime;
    }
}
