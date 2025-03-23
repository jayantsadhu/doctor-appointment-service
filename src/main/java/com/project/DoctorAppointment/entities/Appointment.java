package com.project.DoctorAppointment.entities;

import com.project.DoctorAppointment.entities.Ids.AppointmentId;

public class Appointment {
    private AppointmentId id;
    private int patientId;
    private int slotId;
    private int doctorId;

    public int getPatientId() {
        return patientId;
    }

    public AppointmentId getId() {
        return id;
    }

    public void setId(AppointmentId id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Appointment(AppointmentId id, int patientId, int slotId, int doctorId) {
        this.id = id;
        this.patientId = patientId;
        this.slotId = slotId;
        this.doctorId = doctorId;
    }
}
