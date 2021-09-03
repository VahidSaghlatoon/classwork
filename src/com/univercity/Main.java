package com.univercity;

public class Main {
    public static void main(String[] args) {
        Location loc = new Location(113,26151);
        Location loc1 = new Location(1512,5421);

      /*  Employee emp = new Employee(true, "Ali", "Alavi", 123, loc);

        Employee emp1 = new Employee(false, "Zahra", "Rezayi",12354,loc1);

        emp.setWife(emp1);
        emp1.setWife(emp);

        System.out.println(emp);
        System.out.println(emp1);*/
        University university = new University();
        university.menu();
//        System.out.println(Location.distance(35.7036,35.3,51.3515,51.3));
    }
}
