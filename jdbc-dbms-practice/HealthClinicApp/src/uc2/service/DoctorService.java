package uc2.service;

import uc2.dao.DoctorDao;
import uc2.model.Doctor;
import java.util.List;

public class DoctorService {
    private DoctorDao dao = new DoctorDao();

    public boolean addDoctor(Doctor d) {
        return dao.addDoctor(d);
    }

    public List<Doctor> getAllDoctors() {
        return dao.getAllDoctors();
    }
}
