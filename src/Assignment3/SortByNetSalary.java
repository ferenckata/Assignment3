package Assignment3;

import java.util.Comparator;

public class SortByNetSalary implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        if(employee1.getNetSalary() < employee2.getNetSalary()){
            return -1;
        }else if(employee1.getNetSalary() > employee2.getNetSalary()){
            return 1;
        }else{
            return 0;
        }
    }

}
