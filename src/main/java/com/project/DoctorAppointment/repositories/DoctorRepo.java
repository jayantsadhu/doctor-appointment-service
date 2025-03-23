package com.project.DoctorAppointment.repositories;

import com.project.DoctorAppointment.entities.Doctor;
import com.project.DoctorAppointment.entities.Speciality;
import com.project.DoctorAppointment.exceptions.DoctorNotFoundException;
import com.project.DoctorAppointment.util.ConsolePrint;
import com.project.DoctorAppointment.util.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepo {
    private Map<Integer, Doctor> map;
    Print print;

    public DoctorRepo() {
        this.map = new HashMap<>();
        print = ConsolePrint.getInstance();
    }

    public void addDoctor(Doctor doctor) {
        map.put(doctor.getId(), doctor);
    }

    public Doctor getDoctorById(int doctorId) {
        if(!map.containsKey(doctorId)) {
            throw new DoctorNotFoundException();
        }
        return map.get(doctorId);
    }

    public List<Doctor> getDoctorsBySpeciality(Speciality speciality) {
        List<Doctor> doctors = new ArrayList<>();
        for(Integer id : map.keySet()) {
            if(map.get(id).getSpeciality()==speciality)
                doctors.add(map.get(id));
        }
        return doctors;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        for(Integer id : map.keySet()) {
            doctors.add(map.get(id));
        }
        return doctors;
    }
}
