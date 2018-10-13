package Assignment3;

public class Menu {

    private Company reusax;


    // Constants for the menu choices
    private final int REGISTER_EMPLOYEE = 1;
    private final int CHANGE_NAME = 2;
    private final int CHANGE_SALARY = 3;
    private final int CHANGE_DEGREE = 4;
    private final int CHANGE_GPA = 5;
    private final int CHANGE_DIRECTOR_BENEFIT = 6;
    private final int PROMOTE_EMPLOYEE = 7;
    private final int REMOVE_EMPLOYEE = 8;
    private final int PRINT_ALL = 9;
    private final int PRINT_ONE = 10;
    private final int SORT = 11;
    private final int SORT2 = 12;


    // Creates a new Company object
    public Menu() {

        this.reusax = new Company();
    }


    private void printMenuOptions() {

        System.out.println("Welcome to Reusax Corp");
        System.out.println("Choose an option");
        System.out.println();
        System.out.println("--options here--");

    }

    // Navigate through the different features of the program
    public void menuOptions() {

        // Variable to navigate to each item on the menu. Exits when user chooses 0
        int option;

        do {
            printMenuOptions();

            option = UserInput.readInt("Option:");

            switch (option) {

                case REGISTER_EMPLOYEE:

                    // Input from user - employee name, ID and gross salary
                    System.out.println("Please provide the following to register a new employee:");
                    int currentID = UserInput.readInt("Reusax Employee ID");
                    String name = UserInput.readString("Reusax Employee name");
                    double grossSalary = UserInput.readDouble("Reusax Employee Gross salary");
                    String empType = UserInput.readString("Type the employee type (either regular, manager, director or intern");

                    if( empType.equalsIgnoreCase("regular")) {
                        reusax.registerEmployee(currentID, name, grossSalary);
                    } else if (empType.equalsIgnoreCase("manager")) {
                        String degree = UserInput.readString("Enter the degree level (BSc, MSc or PhD)");
                        reusax.registerManager(currentID, name, grossSalary, degree);
                    } else if (empType.equalsIgnoreCase("director")) {
                        String degree = UserInput.readString("Enter the degree level (BSc, MSc or PhD)");
                        String  department = UserInput.readString("Enter the department");
                        reusax.registerDirector(currentID, name, grossSalary, degree, department);
                    } else if (empType.equalsIgnoreCase("intern")) {
                        double gpa = UserInput.readDouble("Enter the gpa");
                        reusax.registerIntern(currentID, name, grossSalary, gpa);
                    }

                    break;

                case CHANGE_NAME:

                    currentID = UserInput.readInt("Provide ID");
                    name = UserInput.readString("Please type the new name");
                    reusax.updateName(currentID, name);
                    break;

                case CHANGE_SALARY:

                    currentID = UserInput.readInt("Provide ID");
                    grossSalary = UserInput.readDouble("Please type the new salary");
                    reusax.updateSalary(currentID, grossSalary);
                    break;

                case CHANGE_DEGREE:

                    currentID = UserInput.readInt("Provide ID");
                    String degree = UserInput.readString("Please type the new degree");
                    reusax.changeManagerDegree(currentID,degree);
                    break;

                case CHANGE_GPA:

                    currentID = UserInput.readInt("Provide ID");
                    double GPA = UserInput.readDouble("Please type the new GPA");
                    reusax.changeInternGPA(currentID,GPA);
                    break;

                case CHANGE_DIRECTOR_BENEFIT:

                    double benefit = UserInput.readDouble("Please type the new director benefit");
                    reusax.setDirectorBenefit(benefit);
                    break;

                case PROMOTE_EMPLOYEE:

                    int promoteEmp = UserInput.readInt("Provide the ID of the employee to promote");
                    String typeEmployee = UserInput.readString("Promote the employee to ('regular', 'manager', 'director' or 'intern':");

                    if (typeEmployee.equalsIgnoreCase("regular")) {
                        reusax.promoteToEmployee(reusax.retrieveEmployee(promoteEmp));

                    } else if (typeEmployee.equalsIgnoreCase("manager")) {
                        degree = UserInput.readString("Enter the manager's degree");
                        reusax.promoteToManager(reusax.retrieveEmployee(promoteEmp), degree);

                    } else if (typeEmployee.equalsIgnoreCase("director")) {
                        degree = UserInput.readString("Enter the director's degree");
                        String department = UserInput.readString("Enter the department");
                        reusax.promoteToDirector(reusax.retrieveEmployee(promoteEmp), degree, department);

                    } else if (typeEmployee.equalsIgnoreCase("intern")) {
                        double gpa = UserInput.readDouble("Enter the intern's GPA");
                        reusax.promoteToIntern(reusax.retrieveEmployee(promoteEmp), gpa);

                    }
                    break;

                case REMOVE_EMPLOYEE:

                    currentID = UserInput.readInt("Provide the ID of the employee to remove");
                    reusax.removeEmployee(currentID);
                    break;

                case PRINT_ALL:

                    System.out.println("Total gross: " + reusax.getTotalGross());
                    System.out.println("Total net: " + reusax.getTotalNet());
                    System.out.println("No. employees: " + reusax.numberOfEmployees());
                    break;

                case PRINT_ONE:

                    currentID = UserInput.readInt("Provide ID");
                    Employee currentEmployee = reusax.retrieveEmployee(currentID);
                    System.out.println(currentEmployee.toString());
                    break;

                case SORT:

                    reusax.printEmployees();
                    reusax.sortBy();
                    break;

                case SORT2:

                    reusax.printEmployees();
                    String sorttype = UserInput.readString("Sort type (net salary or name)");
                    String sortorder = UserInput.readString("Sort order (up or down)");
                    reusax.sortBy(sorttype, sortorder);
                    break;

                default:
                    System.out.println("Option " + option + " is not valid.");
                    System.out.println();
                    break;
            }


        } while (option != 0);


    }


}