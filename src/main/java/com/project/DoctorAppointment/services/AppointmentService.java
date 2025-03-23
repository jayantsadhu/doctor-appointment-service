package com.project.DoctorAppointment.services;

import com.project.DoctorAppointment.entities.Appointment;
import com.project.DoctorAppointment.entities.Ids.DoctorTimeSlotId;
import com.project.DoctorAppointment.entities.WaitList;
import com.project.DoctorAppointment.repositories.AppointmentsRepo;
import com.project.DoctorAppointment.repositories.WaitListRepo;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AppointmentService {
    private final AppointmentsRepo appointmentsRepo;
    private final WaitListRepo waitListRepo;
    private final PatientService patientService;
    private final DoctorTimeSlotService doctorTimeSlotService;
    private final Print print;

    public AppointmentService(AppointmentsRepo appointmentsRepo,
                              WaitListRepo waitListRepo,
                              PatientService patientService,
                              DoctorTimeSlotService doctorTimeSlotService) {
        this.appointmentsRepo = appointmentsRepo;
        this.patientService = patientService;
        this.doctorTimeSlotService = doctorTimeSlotService;
        this.waitListRepo = waitListRepo;
        print = ConsolePrint.getInstance();
    }

    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        return appointmentsRepo.getAppointmentsByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        return appointmentsRepo.getAppointmentsByDoctorId(doctorId);
    }

    public void bookAppointment(int patientId, int doctorId, int slotId) {
        if(!patientService.isPatientRegistered(patientId) || !doctorTimeSlotService.isDoctorSlotValid(doctorId, slotId)) {
            print.printData("Patient or Doctor is not registered or a incorrect timeslot provided!");
            return;
        }
        if(doctorTimeSlotService.isDoctorSlotAvailable(doctorId, slotId)) {
            LocalDateTime timeNow = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");
            String bookedTime = timeNow.format(formatter);
            appointmentsRepo.createAppointment(patientId, slotId, doctorId, bookedTime);
            print.printData("Appointment booked with doctorId: "+doctorId);
        } else {
            DoctorTimeSlotId doctorTimeSlotId = new DoctorTimeSlotId(doctorId, slotId);
            WaitList waitList = new WaitList(doctorTimeSlotId, patientId, doctorId, slotId);
            waitListRepo.addToWaitList(doctorTimeSlotId, waitList);
            print.printData("Appointment has been waitlisted and will be confirmed once there is a cancellation!");
        }
    }
}
