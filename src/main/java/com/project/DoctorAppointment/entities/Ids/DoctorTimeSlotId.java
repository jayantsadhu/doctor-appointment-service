package com.project.DoctorAppointment.entities.Ids;

import java.util.Objects;

public class DoctorTimeSlotId implements Comparable<DoctorTimeSlotId> {

    private int doctorId;
    private int slotId;

    public DoctorTimeSlotId(int doctorId, int slotId) {
        this.doctorId = doctorId;
        this.slotId = slotId;
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

    @Override
    public String toString() {
        return "DoctorTimeSlotId{" +
                "doctorId=" + doctorId +
                ", slotId=" + slotId +
                '}';
    }

    @Override
    public int compareTo(DoctorTimeSlotId o) {
        if(this.slotId!=o.getSlotId()) return this.slotId-o.getSlotId();
        return this.doctorId-o.getDoctorId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorTimeSlotId that = (DoctorTimeSlotId) o;
        return doctorId == that.doctorId && slotId == that.slotId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, slotId);
    }
}
