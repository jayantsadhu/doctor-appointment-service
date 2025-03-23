package com.project.DoctorAppointment.repositories;

import com.project.DoctorAppointment.entities.Appointment;
import com.project.DoctorAppointment.entities.Ids.AppointmentId;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentsRepo {
    private final Map<AppointmentId, Appointment> map;
    Print print;

    public AppointmentsRepo() {
        map = new HashMap<>();
        print = ConsolePrint.getInstance();
    }

    public void createAppointment(int patientId, int slotId, int doctorId, String bookingTime) {
        AppointmentId appointmentId = new AppointmentId(patientId, slotId);
        if(map.containsKey(appointmentId)) {
            print.printData("An Appointment already exists for the patient at the given timeslot!");
            return;
        }
        Appointment appointmentDetails = new Appointment(appointmentId, patientId, slotId, doctorId);
        map.put(appointmentId, appointmentDetails);
    }

    public Appointment cancelAppointment(int patientId, int slotId) {
        AppointmentId appointmentId = new AppointmentId(patientId, slotId);
        if(!map.containsKey(appointmentId)) {
            print.printData("No appointment available in this slot!");
            return null;
        }
        return map.remove(appointmentId);
    }

    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        List<Appointment> appointments = new ArrayList<>();
        for(AppointmentId id : map.keySet()) {
            if(map.get(id).getPatientId()==patientId)
                appointments.add(map.get(id));
        }
        return appointments;
    }

    public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        for(AppointmentId id : map.keySet()) {
            if(map.get(id).getDoctorId()==doctorId)
                appointments.add(map.get(id));
        }
        return appointments;
    }
}


