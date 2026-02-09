package uc6.service;

import uc6.dao.AdminDao;

public class AdminService {
    private AdminDao dao;

    public AdminService() {
        dao = new AdminDao();
    }

    public boolean addSpecialty(String name) {
        return dao.addSpecialty(name);
    }

    // Other service methods (delete/update specialty) can go here
}
