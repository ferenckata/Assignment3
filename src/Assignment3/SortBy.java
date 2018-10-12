package Assignment3;

import java.util.Comparator;

public class SortBy implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        int result1 = employee1.getName().compareTo(employee2.getName());
        if (result1 == 0){
            if(employee1.getGrossSalary() < employee2.getGrossSalary()){
                return -1;
            }else if(employee1.getGrossSalary() > employee2.getGrossSalary()){
                return 1;
            }else{
                return 0;
            }
        }else{
            return result1;
        }
    }

}
