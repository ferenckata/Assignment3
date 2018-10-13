package Assignment3;

public class Main {

    public  static void main (String[]args){

    /*    Menu menu = new Menu();
        menu.menuOptions();*/
        Company reusax = new Company();

        reusax.registerEmployee(1,"a",100);
        reusax.registerEmployee(2,"b",100);
        reusax.registerEmployee(3,"a",50);
        reusax.registerEmployee(4,"c",200);
        reusax.registerEmployee(5,"b",100);
        reusax.registerEmployee(6,"a",200);

        reusax.printEmployees();
        reusax.sortBy("net salary","up");

    }
}
