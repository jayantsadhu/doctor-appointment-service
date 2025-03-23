package com.project.DoctorAppointment.entities.Ids;

import java.util.Objects;

public class AppointmentId implements Comparable<AppointmentId> {
    private int patientId;
    private int slotId;

    public AppointmentId(int patientId, int slotId) {
        this.patientId = patientId;
        this.slotId = slotId;
    }

    public int getPatientId() {
        return patientId;
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

    @Override
    public int compareTo(AppointmentId o) {
        if(this.slotId!=o.getSlotId()) return this.slotId-o.getSlotId();
        return this.patientId-o.getPatientId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentId that = (AppointmentId) o;
        return patientId == that.patientId && slotId == that.slotId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, slotId);
    }
}
