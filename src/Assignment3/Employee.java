package Assignment3;

public class Employee {

    // Employee attributes
    private int ID;
    private String name;
    private double grossSalary;

    // Proportion subtracted from gross salary to get net salary
    protected static final double INCOME_TAX_PROPORTION = 0.1;

    // Constructor method - initialising
    public Employee(int ID, String name, double grossSalary) {

        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;

    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return this.grossSalary;
    }

    public double getActualGrossSalary(){
        return this.grossSalary;
    }

    // This is also am attribute of the Employee class
    // Calculates the net salary from the gross salary
    public double getNetSalary() {
        double netSalary = this.getGrossSalary() *( 1 - INCOME_TAX_PROPORTION);
        return netSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    // Checks if two employees are equal (have the same ID number)
    // Receives an object and checks if it is of type Employee
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Employee) {
            // Casts the object to type Employee to allow comparison
            Employee otherEmployee = (Employee) otherObject;
            // Checks if object is the same as current Employee object, based on ID only
            return this.getID() == (otherEmployee.getID());
        } else {
            return false;
        }
    }


    // Returns the Employee information as a string
    // Returns Employee name and gross salary
    public String toString() {
        String info = this.getName() + "'s gross salary is " + this.getGrossSalary() + " SEK per month.";
        // System.out.println(info);
        return info;
    }


}

