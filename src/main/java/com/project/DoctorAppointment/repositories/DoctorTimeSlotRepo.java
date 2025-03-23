package com.project.DoctorAppointment.repositories;

import com.project.DoctorAppointment.entities.DoctorTimeSlotInfo;
import com.project.DoctorAppointment.entities.Ids.DoctorTimeSlotId;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorTimeSlotRepo {
    Map<DoctorTimeSlotId, DoctorTimeSlotInfo> map;
    Print print;

    public DoctorTimeSlotRepo() {
        this.map = new HashMap<>();
        print = ConsolePrint.getInstance();
    }

    public DoctorTimeSlotInfo getDoctorSlotById(DoctorTimeSlotId id) {
        return map.get(id);
    }

    public void addDoctorSlot(DoctorTimeSlotId id, DoctorTimeSlotInfo details) {
        map.put(id, details);
    }

    public void removeDoctorSlot(DoctorTimeSlotId id) {
        map.remove(id);
    }

    public List<DoctorTimeSlotInfo> getBookedSlotsByDoctorId(int doctorId) {
        List<DoctorTimeSlotInfo> timeSlotList = new ArrayList<>();
        for(DoctorTimeSlotId id : map.keySet()) {
            if(map.get(id).getDoctorId()==doctorId && !map.get(id).isAvailable()) {
                timeSlotList.add(map.get(id));
            }
        }
        return timeSlotList;
    }
}



