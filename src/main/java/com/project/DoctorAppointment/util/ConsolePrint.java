package com.project.DoctorAppointment.util;

public class ConsolePrint implements Print {

    private ConsolePrint() {
    }

    public static ConsolePrint getInstance() {
        return SingletonConsolePrint.INSTANCE;
    }

    @Override
    public void printData(String message) {
        System.out.println(message);
    }

    static class SingletonConsolePrint {
        public final static ConsolePrint INSTANCE = new ConsolePrint();
    }
}
