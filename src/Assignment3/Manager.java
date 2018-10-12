package Assignment3;

public class Manager extends Employee {

    private String degree;
    private double salaryWithBonus;
    private final double BSC_BONUS = 0.1;
    private final double MSC_BONUS = 0.2;
    private final double PHD_BONUS = 0.35;

    public Manager(int ID, String name, double grossSalary, String degree){
        super(ID, name, grossSalary);
        this.degree = degree;
    }

    public String getDegree(){
        return this.degree;
    }

    public void setDegree(String newDegree){
        this.degree = newDegree;
    }

    public double getBonus() {
        double percentage = 0.0;
        if(this.degree.equalsIgnoreCase("bsc")){
            percentage = BSC_BONUS;
        }else if(this.degree.equalsIgnoreCase("msc")){
            percentage = MSC_BONUS;
        }else if(this.degree.equalsIgnoreCase("phd")){
            percentage = PHD_BONUS;
        }

        return super.getGrossSalary() * percentage;
    }

    @Override
    public double getActualGrossSalary() {
        return super.getGrossSalary() + this.getBonus();
    }

    @Override
    public double getNetSalary() {
        return super.getNetSalary() + this.getBonus() * (1 - INCOME_TAX_PROPORTION);
    }

    @Override
    public String toString() {
        String info = this.getName() + "'s gross salary is " + (super.getGrossSalary() + this.getBonus()) + " SEK per month.";
        // System.out.println(info);
        return info;
    }
}
