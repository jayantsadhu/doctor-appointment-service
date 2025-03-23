package com.project.DoctorAppointment.services;

import com.project.DoctorAppointment.entities.Doctor;
import com.project.DoctorAppointment.entities.DoctorTimeSlotInfo;
import com.project.DoctorAppointment.entities.Speciality;
import com.project.DoctorAppointment.repositories.DoctorRepo;
import com.project.DoctorAppointment.repositories.DoctorTimeSlotRepo;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.util.List;

public class DoctorService {
    private final DoctorRepo doctorRepo;
    private final DoctorTimeSlotRepo doctorTimeSlotRepo;
    private final Print print;

    public DoctorService(DoctorRepo doctorRepo, DoctorTimeSlotRepo doctorTimeSlotRepo) {
        this.doctorRepo = doctorRepo;
        this.doctorTimeSlotRepo = doctorTimeSlotRepo;
        print = ConsolePrint.getInstance();
    }

    public List<DoctorTimeSlotInfo> getBookedSlotInformation(int doctorId) {
        return doctorTimeSlotRepo.getBookedSlotsByDoctorId(doctorId);
    }

    public boolean isDoctorRegistered(int doctorId) {
        try {
            doctorRepo.getDoctorById(doctorId);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public void registerDoctor(Doctor doctor) {
        if(!isDoctorRegistered(doctor.getId()))
            doctorRepo.addDoctor(doctor);
        else {
            print.printData("Doctor id is already registered!");
        }
    }

    public Doctor getDoctorInfo(int doctorId) {
        Doctor doctor = null;
        try {
            doctor = doctorRepo.getDoctorById(doctorId);
        } catch (Exception e) {
            print.printData("Doctor Not found Exception!");
        }
        return doctor;
    }

    public List<Doctor> getDoctorBySpeciality(Speciality speciality) {
        return doctorRepo.getDoctorsBySpeciality(speciality);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.getAllDoctors();
    }

}
