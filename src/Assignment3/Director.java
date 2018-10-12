package Assignment3;

public class Director extends Manager {

    private String department;

    private final double MIDDLE_INCOME_TAX_PROPORTION = 0.2;
    private final double HIGH_INCOME_TAX_PROPORTION = 0.4;

    private final double LOW_TAX_LIMIT = 30000;
    private final double MIDDLE_TAX_LIMIT = 50000;


    public Director(int ID, String name, double grossSalary,String degree, String department){
        super(ID,name,grossSalary,degree);
        this.department = department;
    }

    @Override
    public double getActualGrossSalary() {
        return super.getGrossSalary() + Company.getDirectorBenefit();
    }

    @Override
    public String toString() {
        String info = this.getName() + "'s gross salary is " + (super.getGrossSalary() + Company.getDirectorBenefit()) + " SEK per month.";
        // System.out.println(info);
        return info;
    }

    @Override
    public double getNetSalary() {
        double fullsum;
        if(super.getNetSalary() < LOW_TAX_LIMIT){
            fullsum = super.getNetSalary();
        }else if (super.getNetSalary() < MIDDLE_TAX_LIMIT){
            fullsum = super.getGrossSalary() * ( 1 - MIDDLE_INCOME_TAX_PROPORTION);
        }else{
            fullsum = (LOW_TAX_LIMIT * (1 - MIDDLE_INCOME_TAX_PROPORTION)) + ((super.getGrossSalary() - LOW_TAX_LIMIT) * (1 - HIGH_INCOME_TAX_PROPORTION));
        }
        return fullsum;
    }
}
