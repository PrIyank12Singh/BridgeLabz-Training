package uc1.service;

import uc1.dao.PatientDao;
import uc1.model.Patient;
import java.util.List;

public class PatientService {
    private PatientDao dao = new PatientDao();

    public boolean addPatient(Patient p) {
        return dao.addPatient(p);
    }

    public List<Patient> getAllPatients() {
        return dao.getAllPatients();
    }
}
