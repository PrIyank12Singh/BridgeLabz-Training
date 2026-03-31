package uc4.service;

import uc4.dao.VisitDao;
import uc4.model.Visit;
import uc4.model.Prescription;

import java.util.List;

public class VisitService {
    private VisitDao dao = new VisitDao();

    public boolean addVisit(Visit v) {
        return dao.addVisit(v);
    }

    public boolean addPrescription(Prescription p) {
        return dao.addPrescription(p);
    }

    public List<Visit> getAllVisits() {
        return dao.getAllVisits();
    }
}
