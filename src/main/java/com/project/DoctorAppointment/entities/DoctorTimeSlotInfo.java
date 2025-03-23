package com.project.DoctorAppointment.entities;

import com.project.DoctorAppointment.entities.Ids.DoctorTimeSlotId;

public class DoctorTimeSlotInfo {
    private DoctorTimeSlotId id;
    private int doctorId;
    private int slotId;
    private boolean isAvailable;

    public DoctorTimeSlotInfo(DoctorTimeSlotId id, int doctorId, int slotId, boolean isAvailable) {
        this.id = id;
        this.doctorId = doctorId;
        this.slotId = slotId;
        this.isAvailable = isAvailable;
    }

    public DoctorTimeSlotId getId() {
        return id;
    }

    public void setId(DoctorTimeSlotId id) {
        this.id = id;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "DoctorTimeSlotInfo{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", slotId=" + slotId +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
