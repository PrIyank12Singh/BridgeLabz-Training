package uc5.service;

import uc5.dao.BillDao;
import uc5.model.Bill;

import java.util.List;

public class BillingService {
    private BillDao dao = new BillDao();

    public boolean addBill(Bill b) {
        return dao.addBill(b);
    }

    public List<Bill> getAllBills() {
        return dao.getAllBills();
    }

    public boolean markPaid(int billId) {
        return dao.markPaid(billId);
    }
}
