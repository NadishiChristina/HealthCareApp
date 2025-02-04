import java.util.Date;

public abstract class Appointment {
    // Encapsulated fields (private)
    private Doctor doctor;
    private Patient patient;
    private Date date;
    private String time;

    // Constructor to initialize fields
    public Appointment(Doctor doctor, Patient patient, Date date, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }

    // Getter and Setter methods for each field (Encapsulation)
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

