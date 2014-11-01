package companies.zillow.commonmanager;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public String name;
    public Employee manager;
    public List<Employee> reports = new ArrayList<Employee>();

    public Employee(String name) {
        this.name = name;
    }

    public void addReports(List<Employee> list) {
        for(Employee r:list){
            r.manager = this;
            this.reports.add(r);
        }

    }
}
