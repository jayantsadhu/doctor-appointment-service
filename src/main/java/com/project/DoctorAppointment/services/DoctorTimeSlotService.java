package com.project.DoctorAppointment.services;

import com.project.DoctorAppointment.entities.DoctorTimeSlotInfo;
import com.project.DoctorAppointment.entities.Ids.DoctorTimeSlotId;
import com.project.DoctorAppointment.repositories.DoctorTimeSlotRepo;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.util.List;

public class DoctorTimeSlotService {
    private final DoctorTimeSlotRepo doctorTimeSlotRepo;
    private final Print print;

    public DoctorTimeSlotService(DoctorTimeSlotRepo doctorTimeSlotRepo) {
        this.doctorTimeSlotRepo = doctorTimeSlotRepo;
        print = ConsolePrint.getInstance();
    }

    public boolean isDoctorSlotValid(int doctorId, int slotId) {
        DoctorTimeSlotId doctorTimeSlotId = new DoctorTimeSlotId(doctorId, slotId);
        return doctorTimeSlotRepo.getDoctorSlotById(doctorTimeSlotId) != null;
    }

    public boolean isDoctorSlotAvailable(int doctorId, int slotId) {
        DoctorTimeSlotId doctorTimeSlotId = new DoctorTimeSlotId(doctorId, slotId);
        return doctorTimeSlotRepo.getDoctorSlotById(doctorTimeSlotId).isAvailable();
    }

    public void addDoctorSlot(int doctorId, int slotId, boolean availability) {
        if(isDoctorSlotValid(doctorId, slotId)) {
            print.printData("Doctor already has this slot!");
            return;
        }
        DoctorTimeSlotId doctorTimeSlotId = new DoctorTimeSlotId(doctorId, slotId);
        DoctorTimeSlotInfo doctorTimeSlotInfo = new DoctorTimeSlotInfo(doctorTimeSlotId, doctorId, slotId, availability);
        doctorTimeSlotRepo.addDoctorSlot(doctorTimeSlotId, doctorTimeSlotInfo);
        System.out.println(doctorId+": "+slotId+": added!");
    }

//    public void removeDoctorSlot(int doctorId, int slotId) {
//        if(!isDoctorSlotValid(doctorId, slotId)) {
//            print.printData("Doctor does not have this slot listed!");
//            return;
//        }
//        DoctorTimeSlotId doctorTimeSlotId = new DoctorTimeSlotId(doctorId, slotId);
//        doctorTimeSlotRepo.removeDoctorSlot(doctorTimeSlotId);
//    }

    public List<DoctorTimeSlotInfo> getBookedSlotsByDoctorId(int doctorId) {
        return doctorTimeSlotRepo.getBookedSlotsByDoctorId(doctorId);
    }
}
