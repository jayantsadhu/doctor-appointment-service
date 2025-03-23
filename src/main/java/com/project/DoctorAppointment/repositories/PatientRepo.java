package com.project.DoctorAppointment.repositories;

import com.project.DoctorAppointment.entities.Patient;
import com.project.DoctorAppointment.exceptions.PatientNotFoundException;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.util.HashMap;
import java.util.Map;

public class PatientRepo {
    private final Map<Integer, Patient> map;
    private final Print print;

    public PatientRepo() {
        map = new HashMap<>();
        print = ConsolePrint.getInstance();
    }

    public void addPatient(Patient patient) {
        map.put(patient.getId(), patient);
    }

    public Patient getPatientById(int patientId) {
        if(!map.containsKey(patientId)) {
            throw new PatientNotFoundException();
        }
        return map.get(patientId);
    }
}
