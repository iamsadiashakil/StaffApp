package com.myhealthteam.staffapp.models;

public class Allergy {
    private String name;
    private String type;
    private String severity;
    private String reaction;
    private String notedOn;

    public Allergy(String name, String type, String severity, String reaction, String notedOn) {
        this.name = name;
        this.type = type;
        this.severity = severity;
        this.reaction = reaction;
        this.notedOn = notedOn;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSeverity() {
        return severity;
    }

    public String getReaction() {
        return reaction;
    }

    public String getNotedOn() {
        return notedOn;
    }
}