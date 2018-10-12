package Assignment3;

public class Intern extends Employee {

    private double GPA;

    private double lowGPALimit = 5.0;
    private double middleGPALimit = 8.0;
    private double studyBenefit = 1000;

    public Intern(int ID, String name, double grossSalary, double GPA){
        super(ID, name, grossSalary);
        this.GPA = GPA;
    }

    public void setGPA(double newGPA){
        this.GPA = newGPA;
    }

    public double getFinalSalary() {
        double finalSalary;
        if(this.GPA < lowGPALimit){
            finalSalary = 0.0;
        } else if(this.GPA < middleGPALimit){
            finalSalary = super.getGrossSalary();
        }else{
            finalSalary = super.getGrossSalary() + this.studyBenefit;
        }
        return finalSalary;
    }

    @Override
    public double getActualGrossSalary() {
        return getFinalSalary();
    }

    @Override
    public double getNetSalary() {
        return this.getFinalSalary();
    }

    @Override
    public String toString() {
        String info = this.getName() + "'s gross salary is " + this.getFinalSalary() + " SEK per month.";
        // System.out.println(info);
        return info;
    }
}
