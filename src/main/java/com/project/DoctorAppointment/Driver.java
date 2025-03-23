package com.project.DoctorAppointment;

import com.project.DoctorAppointment.entities.Doctor;
import com.project.DoctorAppointment.entities.Patient;
import com.project.DoctorAppointment.entities.Speciality;
import com.project.DoctorAppointment.entities.TimeSlot;
import com.project.DoctorAppointment.repositories.*;
import com.project.DoctorAppointment.services.*;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        Print print = ConsolePrint.getInstance();
        print.printData("Driver class for FlipMed!");

        DoctorRepo doctorRepo = new DoctorRepo();
        PatientRepo patientRepo = new PatientRepo();
        AppointmentsRepo appointmentsRepo = new AppointmentsRepo();
        DoctorTimeSlotRepo doctorTimeSlotRepo = new DoctorTimeSlotRepo();
        TimeSlotRepo timeSlotRepo = new TimeSlotRepo();
        WaitListRepo waitListRepo = new WaitListRepo();

        DoctorService doctorService = new DoctorService(doctorRepo, doctorTimeSlotRepo);
        PatientService patientService = new PatientService(patientRepo);
        DoctorTimeSlotService doctorTimeSlotService = new DoctorTimeSlotService(doctorTimeSlotRepo);
        AppointmentService appointmentService = new AppointmentService(appointmentsRepo, waitListRepo, patientService, doctorTimeSlotService);
        TimeSlotService timeSlotService = new TimeSlotService(timeSlotRepo);

        doctorService.registerDoctor(new Doctor(1, "Sunil", Speciality.Orthopedic, 4.8));
        doctorService.registerDoctor(new Doctor(2, "Hemant", Speciality.Cardiologist, 4.6));
        doctorService.registerDoctor(new Doctor(3, "Kalyan", Speciality.General_Physician, 4.9));

        List<Doctor> allDoctors = doctorService.getAllDoctors();
        print.printData("All doctors: "+allDoctors.toString());

        LocalTime localTime = LocalTime.of(9, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        for(int i=1 ; i<=24 ; i++) {
            String startTime = localTime.format(formatter);
            localTime = localTime.plusMinutes(30);
            String endTime = localTime.format(formatter);
            timeSlotService.addTimeSlot(new TimeSlot(i, startTime, endTime));
        }

        print.printData("All time slots: "+timeSlotService.getAllTimeSlot().toString());

        doctorTimeSlotService.addDoctorSlot(1, 4, true);
        doctorTimeSlotService.addDoctorSlot(1, 5, true);
        doctorTimeSlotService.addDoctorSlot(1, 6, true);
        doctorTimeSlotService.addDoctorSlot(2, 4, true);
        doctorTimeSlotService.addDoctorSlot(2, 7, true);
        doctorTimeSlotService.addDoctorSlot(2, 6, true);
        doctorTimeSlotService.addDoctorSlot(3, 10, true);
        doctorTimeSlotService.addDoctorSlot(3, 12, true);
        doctorTimeSlotService.addDoctorSlot(3, 24, true);

        patientService.registerPatient(new Patient(1, "Jayant"));
        patientService.registerPatient(new Patient(2, "Abhishek"));
        patientService.registerPatient(new Patient(3, "Subhajit"));
        patientService.registerPatient(new Patient(4, "Sagar"));

        List<Doctor> doctors = doctorService.getDoctorBySpeciality(Speciality.Orthopedic);
        print.printData("Orthopedic doctors: "+doctors.toString());

        appointmentService.bookAppointment(1, 2, 3);
        appointmentService.bookAppointment(1, 2, 7);

    }
}
