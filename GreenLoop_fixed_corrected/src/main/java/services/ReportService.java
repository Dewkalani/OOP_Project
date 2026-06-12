package services;

import dao.ReportDB;
import java.util.List;

public class ReportService {

    private final ReportDB dao = new ReportDB();

    public List<String[]> getMonthlySalesReport(int year) {
        return dao.getMonthlySalesReport(year);
    }

    public List<String[]> getLowStockReport() {
        return dao.getLowStockReport();
    }

    public List<String[]> getOrderStatusSummary() {
        return dao.getOrderStatusSummary();
    }
}
