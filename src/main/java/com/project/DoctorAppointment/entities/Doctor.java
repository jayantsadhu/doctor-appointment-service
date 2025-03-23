package com.project.DoctorAppointment.entities;

public class Doctor {
    private int id;
    private String name;
    private Speciality speciality;
    private double ratings;

    public Doctor(int id, String name, Speciality speciality, double ratings) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speciality=" + speciality +
                ", ratings=" + ratings +
                '}';
    }
}
