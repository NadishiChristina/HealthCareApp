import javax.print.Doc;
import java.util.*;

    public class Main {
        //----------> Option 1
        public static void adminMenu(){
            boolean adminAccess = true;

            while (adminAccess) {
                System.out.println("Press 1 to add a doctor, press 2 to add a doctor availability, and press 3 to exit: ");

                Scanner scanner = new Scanner(System.in);
                int opt_1 = scanner.nextInt();

                if (opt_1 == 1) {
                    Controller.addDoctor();
                    System.out.println("SUCCESSFULLY ADDED A DOCTOR");
                    System.out.println(" ");

                } else if (opt_1 == 2) {
                    Controller.addAvailability();
                    System.out.println("SUCCESSFUL");
                    System.out.println(" ");


                } else if (opt_1 == 3) {
                    adminAccess = false;
                    System.out.println("EXITED");
                    System.out.println(" ");

                } else {
                    System.out.println("Invalid input, Please try again!");
                }
            }
        }

        // ----------->Option 2
        public static void patientMenu() {
            boolean patientAccess = true;

            while (patientAccess) {
                System.out.println("Press 1 to view doctors, press 2 to book a appointment, press 3 to view a selected doctor's booking, and 4 to register a patient and press 5 to exit: ");

                Scanner scanner = new Scanner(System.in);
                int opt_2 = scanner.nextInt();

                if (opt_2 == 1) {
                    Controller.viewAllDoctors();

                } else if (opt_2 == 2) {
                    System.out.println("Book an appointment");
                    System.out.println(" ");
                    Controller.makeAppointment();

                } else if (opt_2 == 3) {
                    System.out.println("View a selected doctor's booking");
                    System.out.println(" ");
                    Controller.selectedBooking();

                } else if (opt_2 == 4) {
                    Controller.registerPatient();
                    System.out.println("SUCCESSFULLY ADDED A PATIENT");
                    System.out.println(" ");

                } else if (opt_2 == 5) {
                    patientAccess = false;
                    System.out.println("EXITED");
                    System.out.println(" ");

                } else {
                    System.out.println("Invalid input, Please try again!");
                }
            }

        }

        //MAIN MENU

        public static void run() {

            boolean mainMenu = true;
            while (mainMenu) {
                try{
                    System.out.print("If you are a hospital administrator please press 1, if you are a patient please press 2, Press 3 to exit : ");

                    Scanner scanner = new Scanner(System.in);
                    int option = scanner.nextInt();

                    if (option == 1) {
                        adminMenu();

                    } else if (option == 2) {
                        patientMenu();

                    } else if (option == 3) {
                        mainMenu = false; // The main menu selection won't run again, ENDS!
                        System.out.println();
                        System.out.println("-----Thank you for using our health services, Have a good day!-----");
                        System.exit(0);

                        // -----------> Invalid option
                    } else {
                        System.out.println("Invalid input, Please enter a number between 1-3");
                        System.out.println("");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please enter a valid number.");
                    System.out.println("");
                }
            }
        }

        //Sample data for Doctor and Patient

        public static void main(String[] args) {
            Doctor sampleDoc = new Doctor(223,"Harsha Perera","22.05.1982","Cardiologist","077-321-9755");
            Patient samplePatient = new Patient("T-12", "Dilki Fernando",  "077-210-4567");
            Controller.allDoctors.add(sampleDoc);
            Controller.allPatients.add(samplePatient);

            run();

        }
    }


