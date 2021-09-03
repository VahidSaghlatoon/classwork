package com.univercity;

import java.util.Scanner;

public class University {

    private static final double LATITUDE = 35.7036;
    private static final double LONGITUDE = 51.3515;

    private final Employee[] employee = new Employee[10];
    private static int count;

    public void menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("(1)add employee (2)add partner (3)check married (4)check invited (5)list invited employee (0)EXIT : ");
            int choice = input.nextInt();
            if (choice == 1) {
                addEmployee();
            } else if (choice == 2) {
                addPartner();
            } else if (choice == 3) {
                checkMarried();
            } else if (choice == 4) {
                invitedList();
            } else if (choice == 5) {
                listEmployee();
            } else if (choice == 0) {
                break;
            }

        }
    }

    public void addEmployee() {
        Scanner input = new Scanner(System.in);
        employee[count] = new Employee();
        //set id
        System.out.print("Enter id : ");
        employee[count].setId(input.nextInt());
        // set firstName
        System.out.print("Enter firstName : ");
        employee[count].setFirstName(input.next());
        // set lastName
        System.out.print("Enter lastName : ");
        employee[count].setLastName(input.next());
        //set gender
        System.out.print("Enter gender (0)->male (1)->female : ");
        int gender = input.nextInt();
        if (gender == 0)
            employee[count].setGender("male");
        else if (gender == 1)
            employee[count].setGender("female");
        //set partner
        System.out.print("partner (0)->have (1)->don't have : ");
        employee[count].setCheckPartner(input.nextInt());
        //set location
        System.out.print("Enter location latitude : ");
        employee[count].setLatitude(input.nextDouble());
        System.out.print("Enter location longitude : ");
        employee[count].setLongitude(input.nextDouble());
        // set distance
        employee[count].setDistance(Location.distance(University.LATITUDE, employee[count].getLatitude(), University.LONGITUDE, employee[count].getLongitude()));
        // increase counter
        count++;


    }

    public void addPartner() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee id : ");
        int id = input.nextInt();
        for (int i = 0; i < count; i++) {
            if (employee[i].getId() == id) {
                if (employee[i].getGender().equals("male")) {
                    System.out.print("Enter wife name : ");
                    employee[i].setPartner(input.next());
                } else if (employee[i].getGender().equals("female")) {
                    System.out.print("Enter husband name : ");
                    employee[i].setPartner(input.next());
                }
            }
        }

    }

    public void listEmployee() {
        for (int i = 0; i < count; i++) {
            System.out.println(employee[i].toString());
        }
    }

    public void checkMarried() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter employee id : ");
        int id = input.nextInt();
        for (int i = 0; i < count; i++) {
            if (employee[i].getId() == id) {
                if (employee[i].getCheckPartner() == 0)
                    System.out.println("Married");
                else
                    System.out.println("Not Married");
            }
        }
    }

    public void invitedList() {
        for (int i = 0; i < count; i++) {
            if (employee[i].getDistance() < 30 && employee[i].getCheckPartner() == 0)
                System.out.println(employee[i].toString());
        }
    }


}
