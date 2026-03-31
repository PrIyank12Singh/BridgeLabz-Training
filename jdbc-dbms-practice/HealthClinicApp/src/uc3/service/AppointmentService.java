package uc3.service;

import uc3.dao.AppointmentDao;
import uc3.model.Appointment;

import java.util.List;

public class AppointmentService {
    private AppointmentDao dao = new AppointmentDao();

    public boolean addAppointment(Appointment appt) {
        return dao.addAppointment(appt);
    }

    public List<Appointment> getAllAppointments() {
        return dao.getAllAppointments();
    }
}
