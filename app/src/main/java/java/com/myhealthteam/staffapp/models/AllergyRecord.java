package java.com.myhealthteam.staffapp.models;

public class AllergyRecord {

    private String name;       // Name of the allergy
    private String type;       // Type of allergy (e.g., Drug, Environmental, Food)
    private String severity;   // Severity of the allergy (e.g., Severe, Moderate)
    private String reaction;   // Reaction caused by the allergy (e.g., Anaphylaxis, Sneezing)
    private String notedOn;    // Date when the allergy was noted

    // Constructor
    public AllergyRecord(String name, String type, String severity, String reaction, String notedOn) {
        this.name = name;
        this.type = type;
        this.severity = severity;
        this.reaction = reaction;
        this.notedOn = notedOn;
    }

    // Getters
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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public void setNotedOn(String notedOn) {
        this.notedOn = notedOn;
    }
}