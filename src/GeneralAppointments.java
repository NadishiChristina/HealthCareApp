
    import java.util.Date;

    public class GeneralAppointments extends Appointment {
        // New field specific to GeneralAppointments
        private String patientNotes;

        // Constructor for GeneralAppointments, which also calls the superclass constructor
        public GeneralAppointments(Doctor doctor, Patient patient, Date date, String time, String patientNotes) {
            // Call to the superclass constructor to initialize inherited fields
            super(doctor, patient, date, time);
            // Initialize patientNotes specific to this class
            this.patientNotes = patientNotes;
        }

        // Getter and Setter for patientNotes
        public String getPatientNotes() {
            return patientNotes;
        }

        public void setPatientNotes(String patientNotes) {
            this.patientNotes = patientNotes;
        }

    }


