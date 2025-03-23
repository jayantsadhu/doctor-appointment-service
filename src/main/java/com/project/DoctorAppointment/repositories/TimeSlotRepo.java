package com.project.DoctorAppointment.repositories;

import com.project.DoctorAppointment.entities.TimeSlot;
import com.project.DoctorAppointment.exceptions.TimeSlotNotFoundException;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeSlotRepo {
    private Map<Integer, TimeSlot> timeSlots;
    private Print print;

    public TimeSlotRepo() {
        this.timeSlots = new HashMap<>();
        print = ConsolePrint.getInstance();
    }

    public TimeSlot getTimeSLotById(int slotId) {
        if(!timeSlots.containsKey(slotId)) {
            throw new TimeSlotNotFoundException();
        }
        return timeSlots.get(slotId);
    }

    public void addTimeSlots(TimeSlot timeSlot) {
        if(this.timeSlots.containsKey(timeSlot.getId())) {
            print.printData("TimeSlot is already present!");
            return;
        }
        this.timeSlots.put(timeSlot.getId(), timeSlot);
    }

    public List<TimeSlot> getAllSlots() {
        List<TimeSlot> slots = new ArrayList<>();
        for(Integer id : timeSlots.keySet())
            slots.add(timeSlots.get(id));
        return slots;
    }
}
