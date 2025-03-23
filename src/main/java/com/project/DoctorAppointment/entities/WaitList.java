package com.project.DoctorAppointment.entities;

import com.project.DoctorAppointment.entities.Ids.DoctorTimeSlotId;

public class WaitList {
    private DoctorTimeSlotId id;
    private int patientId;
    private int doctorId;
    private int slotId;

    public WaitList(DoctorTimeSlotId id, int patientId, int doctorId, int slotId) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.slotId = slotId;
    }

    public DoctorTimeSlotId getId() {
        return id;
    }

    public void setId(DoctorTimeSlotId id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
}
