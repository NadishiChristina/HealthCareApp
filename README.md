# 🩺 Healthcare Booking Application

## Project Objective

This is a healthcare management system built using Java and core Object-Oriented Programming (OOP) principles. The system is designed to streamline the process of managing doctor availabilities and booking appointments for patients.

## Core Features

### Doctor Availability Management
- Doctors can input their available dates (day, month, year).
- Default available hours on selected dates are from **5 PM to 10 PM**.
- The system supports different availability dates and times per doctor.

### Appointment Slots
- Two appointment types:
  - **General Appointment**
  - **Referral Appointment** (requires referring doctor info and notes)
- Appointments are arranged in **1-hour time slots**.
- Appointment time is dynamically assigned based on booked slots.

### Patient Booking
- Patients can:
  - Select a doctor
  - Choose a preferred date
  - View available slots for all doctors on that date
  - Book an available time slot (system prevents double-booking)

### Doctor and Patient Info Management
- The system maintains a list of all registered doctors.
- Doctors can view their list of scheduled patients for a selected date.

## 🛠️ Technologies Used

- **Java** – Core programming language
- **Object-Oriented Programming (OOP)** – Design and logic implementation

