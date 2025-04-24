package model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
    private int id;
    private int patientId;
    private String doctorName;
    private Date appointmentDate;
    private Time appointmentTime;

    public Appointment(int id, int patientId, String doctorName, Date date, Time time) {
        this.id = id;
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.appointmentDate = date;
        this.appointmentTime = time;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id + ", Patient ID: " + patientId + ", Doctor: " + doctorName +
                ", Date: " + appointmentDate + ", Time: " + appointmentTime;
    }
}
