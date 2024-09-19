    import java.util.Date;

    public class RefferalAppointments extends Appointment {
        private String referralDoctor;
        private String notes;
        private String referralDoctorNotes;


        // Constructor for GeneralAppointments, which also calls the superclass constructor
        public RefferalAppointments(Doctor doctor, Patient patient, Date date, String time, String referralDoctor, String notes) {
            // Call to the superclass constructor to initialize inherited fields
            super(doctor, patient, date, time);
            // Initialize patientNotes specific to this class
            this.referralDoctor = referralDoctor;
            this.notes = notes;
        }

        // Getters and Setters
        public String getReferralDoctor() {
            return referralDoctor;
        }

        public void setReferralDoctor(String referralDoctor) {
            this.referralDoctor = referralDoctor;
        }

        public String getNotes(){
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

    }


