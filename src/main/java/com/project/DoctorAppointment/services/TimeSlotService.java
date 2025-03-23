package com.project.DoctorAppointment.services;

import com.project.DoctorAppointment.entities.TimeSlot;
import com.project.DoctorAppointment.repositories.TimeSlotRepo;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.util.List;

public class TimeSlotService {
    private final TimeSlotRepo timeSlotRepo;
    private final Print print;

    public TimeSlotService(TimeSlotRepo timeSlotRepo) {
        this.timeSlotRepo = timeSlotRepo;
        print = ConsolePrint.getInstance();
    }

    public boolean isTimeSlotPresent(int slotId) {
        try {
            timeSlotRepo.getTimeSLotById(slotId);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        if(!isTimeSlotPresent(timeSlot.getId()))
            timeSlotRepo.addTimeSlots(timeSlot);
        else
            print.printData("TimeSlot already present");
    }

    public TimeSlot getTimeSlot(int slotId) {
        TimeSlot timeSlot = null;
        try {
            timeSlot = timeSlotRepo.getTimeSLotById(slotId);
        } catch(Exception e) {
            print.printData("TimeSlot Not Found Exception!");
        }
        return timeSlot;
    }

    public List<TimeSlot> getAllTimeSlot() {
        return timeSlotRepo.getAllSlots();
    }
}
