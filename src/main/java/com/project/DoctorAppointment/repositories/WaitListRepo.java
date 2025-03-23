package com.project.DoctorAppointment.repositories;

import com.project.DoctorAppointment.entities.Ids.DoctorTimeSlotId;
import com.project.DoctorAppointment.entities.WaitList;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.util.HashMap;
import java.util.Map;

public class WaitListRepo {
    Map<DoctorTimeSlotId, WaitList> map;
    Print print;

    public WaitListRepo() {
        map = new HashMap<>();
        print = ConsolePrint.getInstance();
    }

    public void addToWaitList(DoctorTimeSlotId doctorTimeSlotId, WaitList waitList) {
        if(map.containsKey(doctorTimeSlotId)) {
            print.printData("This slot is already added to queue");
            return;
        }
        map.put(doctorTimeSlotId, waitList);
    }
}
