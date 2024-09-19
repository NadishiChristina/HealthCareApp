import java.util.*;

public class Controller {

    public static ArrayList<Doctor> allDoctors = new ArrayList<>();
    public static ArrayList<Patient> allPatients = new ArrayList<>();

    public static int NUMBER_OF_SLOTS = 5;


    public static void addDoctor(){
        // add doctor
        System.out.println("\n"+"---------Doctor information---------");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter birthday: ");
        String birthday = sc.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = sc.nextLine();

        System.out.print("Enter contact number: ");
        String contactNumber = sc.nextLine();

        Random random = new Random();
        Doctor tempDoctor = new Doctor(random.nextInt(), name, birthday, specialization, contactNumber);//Creating a temp doctor instance
        // Similar to calling the doctor method else constructor

        allDoctors.add(tempDoctor);
        // Everytime we create a temp doctor instance, it gets added to the array list
    }

    public static void addAvailability(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("add a doctor availability");
        System.out.println(" ");

        //Week 8 - Adding Doctor availability
        System.out.println("Enter Doctor ID: ");
        int docId = scanner.nextInt();

        Doctor selectedDoctor = null;
        //fetch doctor id from the array list, if doctor id does not exist display as doctor not found, if available,
        // take the date and add availability

        for (Doctor doc : allDoctors) {
            if(doc.getDoctorId() == docId){
                selectedDoctor = doc; // assign to selected Doctor
            }
        }

        if (selectedDoctor == null){
            System.out.println("No doctor found");// I need to exit and stop the code from here if true
            return;
        }

        System.out.println("Enter the date: ");
        int day = scanner.nextInt();
        System.out.println("Enter the month: ");
        int month = scanner.nextInt();
        System.out.println("Enter the year: ");
        int year = scanner.nextInt(); // Taking separately to convert as a date object

        Date bookingDate = new Date(year, month, day);

        selectedDoctor.setAvailability(bookingDate);
    }

    public static void viewAllDoctors(){
        System.out.println("View doctors");
        System.out.println(" ");

        for (Doctor doc: allDoctors){
            System.out.println(doc.getName() + " has a specialization of " + doc.getSpecialization() + " --> Doctor ID is " + doc.getDoctorId() + " and has an availability on " + doc.getAvailabilities().toString()); /// dates may differ I enter 08(Jul) as month it gets set up as Sep(09) -- since similar to arrays starts from 0 index
            System.out.println(" ");
        }
    }

    public static void registerPatient(){

        System.out.println("\n"+"---------Patient information---------");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patient's name: ");
        String name = scanner.next();
        System.out.println("Enter patient's ID: ");
        String id = scanner.next();
        System.out.println("Enter patient's DOB: ");
        String dob = scanner.next();
        System.out.println("Enter patient's contact no: ");
        String contactNo = scanner.next();

        Patient tempPatient = new Patient(id, name, contactNo); //creating new patient
        allPatients.add(tempPatient);

        System.out.println(allPatients.toString());
    }

    public static void makeAppointment() {
        Scanner scanner = new Scanner(System.in);

        // Ask user for appointment type (Referral or General)
        System.out.println("Enter 'R' for Referral or 'G' for General: ");
        String appointmentType = scanner.nextLine();

        if (!appointmentType.equalsIgnoreCase("R") && !appointmentType.equalsIgnoreCase("G")) {
            System.out.println("Invalid input. Please enter 'R' for Referral or 'G' for General.");
            return; // Exit the method early if input is invalid
        }

        // Common inputs for both referral and general appointments
        System.out.println("Enter the doctor's ID to meet: ");
        int docId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the patient's ID: ");
        String patientId = scanner.nextLine();

        // Get the patient and doctor
        Patient selectedPatient = getPatientById(patientId);
        Doctor selectedDoctor = getDoctorById(docId);

        if (selectedDoctor == null || selectedPatient == null) {
            System.out.println("No Doctor or Patient found!");
            return;
        }

        System.out.println("Enter the date you want to make the appointment: ");
        String date = scanner.next();
        System.out.println("Enter the month you want to make the appointment: ");
        String month = scanner.next();
        System.out.println("Enter the year you want to make the appointment: ");
        String year = scanner.next();


//create an appointment date, parseInt converts what's inside to int
        Date appointmentDate = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(date));

        // Check availability
        Boolean isAvailable = checkAvailability(selectedDoctor, appointmentDate);
        if (!isAvailable) {
            System.out.println("Doctor is not available on the selected date");
            System.out.println("");
            return;
        }

        String appTime = getTimeForBooking(selectedDoctor, appointmentDate);
        if (appTime == null) {
            System.out.println("ALL SLOTS ARE FILLED");
            System.out.println("");
            return;
        }

        // Now, handle the specific inputs and appointment creation based on type
        if (appointmentType.equalsIgnoreCase("R")) {
            // Handle referral appointment: ask for referral doctor ID
            System.out.println("Enter the referral doctor's ID: ");
            scanner.nextLine();  // This ensures the newline is consumed
            String referralDoctorId = scanner.nextLine();  // Now it correctly waits for input

            // Create Referral Appointment
            RefferalAppointments referralAppointment = new RefferalAppointments(
                    selectedDoctor, selectedPatient, appointmentDate, appTime, referralDoctorId, "Referral"
            );
            selectedDoctor.setAppointment(referralAppointment, appointmentDate);
            System.out.println("Referral appointment created: " + referralAppointment + " referred by doctor having ID: " + referralDoctorId);


        } else if (appointmentType.equalsIgnoreCase("G")) {
            // Handle general appointment: ask for patient notes
            System.out.println("Enter patient notes: ");
            String patientNotes = scanner.nextLine();

            // Create General Appointment
            GeneralAppointments generalAppointment = new GeneralAppointments(
                    selectedDoctor, selectedPatient, appointmentDate, appTime, patientNotes
            );
            selectedDoctor.setAppointment(generalAppointment, appointmentDate);
            System.out.println("General appointment created: " + generalAppointment);

        } else {
            System.out.println("Invalid input. Please enter 'R' for Referral or 'G' for General.");
            System.out.println("");
            return;
        }

        // Print all appointments for the doctor
        System.out.println(selectedDoctor.getAllAppointments().toString());
    }

    public static void selectedBooking(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the doctor's ID to meet: ");
        int docId = scanner.nextInt();
        scanner.nextLine();  // Handle newline

        Doctor selectedDoctor = getDoctorById(docId);
        System.out.println(selectedDoctor.getAllAppointments().toString());

        if (selectedDoctor == null) {
            System.out.println("Invalid Doctor ID");
            return;
        }
    }

    private static String getTimeForBooking(Doctor selectedDoctor, Date dateOfBooking){
        for (Map.Entry<Date,ArrayList<Appointment>> appointment: selectedDoctor.getAllAppointments().entrySet()) {
            if(appointment.getKey().equals(dateOfBooking)){
                int numberOfSlots = appointment.getValue().size();
                if(numberOfSlots > NUMBER_OF_SLOTS-1){
                    return null;
                }
                System.out.println("We can make a booking");
                int time = 17 + appointment.getValue().size();
                String strTime = time + " : 00";
                return strTime;
            }
        }
        return "17: 00";
    }

    private static Boolean checkAvailability(Doctor selectedDoctor, Date dateOfBooking){
        for (Date day: selectedDoctor.getAvailabilities()) {
            if(day.equals(dateOfBooking)){
                return true;
            }
        }

        return false;
    }

    public static Patient getPatientById(String id){
        for(Patient patient : allPatients){
            if(patient.getPatientId().equals(id)){
                return patient;
            }
        }
        return null;
    }
    public static Doctor getDoctorById(int id){
        for(Doctor doc : allDoctors){
            if(doc.getDoctorId() == id){
                return doc;
            }
        }
        return null;
    }


}
