package com.project.DoctorAppointment.services;

import com.project.DoctorAppointment.entities.Patient;
import com.project.DoctorAppointment.repositories.PatientRepo;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

public class PatientService {
    private final PatientRepo patientRepo;
    private final Print print;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
        print = ConsolePrint.getInstance();
    }

    public boolean isPatientRegistered(int patientId) {
        try {
            patientRepo.getPatientById(patientId);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public void registerPatient(Patient patient) {
        if(!isPatientRegistered(patient.getId()))
            patientRepo.addPatient(patient);
        else
            print.printData("Patient id is already registered!");
    }

    public Patient getPatientInfo(int patientId) {
        Patient patient = null;
        try {
            patient = patientRepo.getPatientById(patientId);
        } catch(Exception e) {
            print.printData("Patient Not found Exception!");
        }
        return patient;
    }






}
