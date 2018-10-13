package Assignment3;

import java.util.ArrayList;
import java.util.Comparator;


public class Company implements Comparator<Employee> {

    //test

    // ArrayList - to allow you to search for an employee based on the index (position)
    private ArrayList<Employee> employees;
    private static double directorBenefit;

    // Constructor method - initialising the ArrayList
    public Company() {
        this.employees = new ArrayList<>();
        directorBenefit = 0;

    }


    // Creates a new Employee object
    public void registerEmployee(int id, String name, double grossSalary) {

        // Declares an reference of type Employee
        // Creates an object of type Employee
        // Connects the reference to the object

        if (retrieveEmployee(id) == null) {

            Employee newEmployee = new Employee(id, name, grossSalary);
            employees.add(newEmployee);
        }

    }

    // Creates a new Manager object
    public void registerManager(int id, String name, double grossSalary, String degree) {

        // Declares an reference of type Employee
        // Creates an object of type Employee
        // Connects the reference to the object

        if (retrieveEmployee(id) == null) {

            Employee newEmployee = new Manager(id, name, grossSalary, degree);
            employees.add(newEmployee);

        }

    }

    // Creates a new Director object
    public void registerDirector(int id, String name, double grossSalary, String degree, String department) {

        // Declares an reference of type Employee
        // Creates an object of type Employee
        // Connects the reference to the object

        if (retrieveEmployee(id) == null) {

            Employee newEmployee = new Director(id, name, grossSalary, degree, department);
            employees.add(newEmployee);

        }

    }

    // Creates a new Intern object
    public void registerIntern(int id, String name, double grossSalary, double gpa) {

        // Declares an reference of type Employee
        // Creates an object of type Employee
        // Connects the reference to the object

        if (retrieveEmployee(id) == null) {

            Employee newEmployee = new Intern(id, name, grossSalary, gpa);
            employees.add(newEmployee);

        }

    }

    // USed to search for a employee, given the employee ID
    public Employee retrieveEmployee(int id) {

        // Iterate through the list of employees
        for (Employee currentEmployee : employees) {
            // Check if the ID entered is the same as an ID in the list

            if (id == currentEmployee.getID()) {
                // Returns the employee object reference of the matching employee
                return currentEmployee;
            }
        }
        // Not possible to
        System.out.println("An employee of " + id + " is not registered in the system.");
        return null;
    }


    // Takes ID number via user input (menu)
    public void removeEmployee(int id) {

        boolean removed = false;

        // Calls method to check if there is an employee with the ID entered
        Employee removeEmp = retrieveEmployee(id);

        // If there IS an employee with this ID, remove from ArrayList
        if (removeEmp != null) {
            removed = employees.remove(removeEmp);
        }

        if(removed){
            System.out.println(id + " removal is successful.");
        }else{
            System.out.println(id + " could not be removed.");
        }
    }

    // Takes ID number and new name via user input (menu)
    public void updateName(int id, String name) {

        // Calls method to check if there is an employee with the ID entered
        Employee updateEmp = retrieveEmployee(id);

        // If there IS an employee with this ID, calls setName method and passes new name as a parameter
        if (updateEmp != null) {
            updateEmp.setName(name);
        }

    }

    public void updateSalary(int id, double salary) {

        // Calls method to check if there is an employee with the ID entered
        Employee updateEmp = retrieveEmployee(id);

        // If there IS an employee with this ID, calls setName method and passes new gross salary as a parameter
        if (updateEmp != null) {
            updateEmp.setGrossSalary(salary);
        }

    }

    public double getTotalGross() {

        double totalGross = 0.0;

        // For each loop - for each Employee object in the list of employees
        for (Employee employee : employees) {

            // Sum each employees gross salary by calling the getter for gross salary
            totalGross += employee.getActualGrossSalary();
        }
        return totalGross;
    }

    public double getTotalNet() {

        double totalNet = 0.0;

        // For each loop - for each Employee object in the list of employees
        for (Employee employee : employees) {

            // Sum each employees gross salary by calling the getter for gross salary
            totalNet += employee.getNetSalary();
        }
        return totalNet;
    }

    public int numberOfEmployees() {
        // Size method returns the number of elements in a list
        return employees.size();

    }


    // User enters id number and degree type
    public void changeManagerDegree (int id, String degree) {

        // Calls method to check if there is an employee with the ID entered
        Employee emp = retrieveEmployee(id);

        // Checks if the Employee object is also a Manager object
        if (emp instanceof Manager) {
            // Casts the object to type Manager to allow comparison
            Manager managerEmployee = (Manager) emp;

            // Calls set degree method, takes in new degree type as a parameter
            managerEmployee.setDegree(degree);
        }else{
            System.out.println(id + " is not a manager, degree change unsuccessful.");
        }
    }

    public void changeInternGPA(int id, double GPA){
        // Calls method to check if there is an employee with the ID entered
        Employee emp = retrieveEmployee(id);

        // Checks if the Employee object is also a Manager object
        if (emp instanceof Intern) {
            // Casts the object to type Manager to allow comparison
            Intern managerEmployee = (Intern) emp;

            // Calls set degree method, takes in new degree type as a parameter
            managerEmployee.setGPA(GPA);
        }else{
            System.out.println(id + " is not an intern, GPA change unsuccessful.");
        }
    }


    public void setDirectorBenefit(double directorBenefit) {
        Company.directorBenefit = directorBenefit;
    }

    public static double getDirectorBenefit(){ return directorBenefit;}

    public void promoteToEmployee(Employee employee){

        int saveId = employee.getID();
        String saveName = employee.getName();
        double saveGrossSalary = employee.getGrossSalary();

        employees.remove(employee);
        registerEmployee(saveId, saveName, saveGrossSalary);

    }
    public void promoteToManager(Employee employee, String degree){

        int saveId = employee.getID();
        String saveName = employee.getName();
        double saveGrossSalary = employee.getGrossSalary();

        employees.remove(employee);
        registerManager(saveId, saveName, saveGrossSalary, degree);

    }
    public void promoteToDirector(Employee employee, String degree, String department){

        int saveId = employee.getID();
        String saveName = employee.getName();
        double saveGrossSalary = employee.getGrossSalary();


        employees.remove(employee);
        registerDirector(saveId, saveName, saveGrossSalary, degree, department);

    }
    public void promoteToIntern(Employee employee, double gpa){

        int saveId = employee.getID();
        String saveName = employee.getName();
        double saveGrossSalary = employee.getGrossSalary();

        employees.remove(employee);
        registerIntern(saveId, saveName, saveGrossSalary, gpa);

    }

    public void printEmployees(){
        System.out.println(this.employees);
    }

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getName().compareTo(employee2.getName());
    }

    public void changeIndex(int i, int j){
        Employee temp = this.employees.get(i);
        this.employees.remove(i);
        this.employees.add(i,this.employees.get(j-1));
        this.employees.add(j,temp);
        this.employees.remove(j+1);
        System.out.println(this.employees);
    }

    public void sortBy(){
        for (int i = 0; i < this.employees.size(); i++) {
            for (int j = i+1; j < this.employees.size(); j++) {
                int result = compare(this.employees.get(i),this.employees.get(j));
                if(result>0){
                    changeIndex(i,j);
                }else if(result==0){
                    if(this.employees.get(i).getGrossSalary() > this.employees.get(j).getGrossSalary()){
                        changeIndex(i,j);
                    }
                }
            }
        }
    }

    public void sortBy(String type, String direction){

        if(type.equalsIgnoreCase("name")){
            for (int i = 0; i < this.employees.size(); i++) {
                for (int j = i+1; j < this.employees.size(); j++) {
                    int result = compare(this.employees.get(i),this.employees.get(j));
                    if(direction.equalsIgnoreCase("down")){
                        result = (-1)*result;
                    }
                    if(result>0){
                        changeIndex(i,j);
                    }
                }
            }
        }else if(type.equalsIgnoreCase("net salary")) {
            for (int i = 0; i < this.employees.size(); i++) {
                for (int j = i + 1; j < this.employees.size(); j++) {
                    if (direction.equalsIgnoreCase("up")) {
                        if (this.employees.get(i).getGrossSalary() > this.employees.get(j).getGrossSalary()) {
                            changeIndex(i, j);
                        }
                    } else {
                        if (this.employees.get(i).getGrossSalary() < this.employees.get(j).getGrossSalary()) {
                            changeIndex(i, j);
                        }
                    }
                }
            }
        }

    }

}