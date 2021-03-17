package controllers;

import Customers.Customers;
import employee.EmployeeTask9;
import validate_exception.ValidateCheckChoice;
import java.util.*;

public class MainController {
    ValidateCheckChoice checkChoice=new ValidateCheckChoice();
    AddServices addServices=new AddServices();
    ShowServices showServices =new ShowServices();
    Scanner scanner = new Scanner(System.in);
    public void disPlayMainMenu() {
        System.out.println("1. Add New Services" +
                "\n2. Show Services" +
                "\n3. Add New Customer" +
                "\n4. Show Information of Customer" +
                "\n5. Add New Booking" +
                "\n6. Show Information of Employee" +
                "\n7. Exit");
        String choice;
        do {
            choice = scanner.nextLine();
        } while (!checkChoice.checkChoice(choice, 7));
        switch (choice) {
            case "1":
                addNewServices();
                break;
            case "2":
                showServices();
                break;
            case "3":
                Customers.addNewCustomer();
                break;
            case "4":
                Customers.showInformationCustomer();
//                System.out.println("1. quay lai menu" +
//                        "\n2. Thoat");
//
//                String choiceShowInforCustomer;
//                do {
//                    choiceShowInforCustomer = scanner.nextLine();
//                } while (!checkChoice(choiceShowInforCustomer, 2));
//                switch (choiceShowInforCustomer) {
//                    case "1":
//                        disPlayMainMenu();
//                        break;
//                    case "2":
//                        break;
//                }
                break;
            case "5":
                Customers.addNewBooking();
                break;
            case "6":
                EmployeeTask9.showEmployeeMap();
                break;
            default:

        }
    }

    public void addNewServices() {

        System.out.println("1. Add New Villa" +
                "\n2. Add New House" +
                "\n3. Add New Room" +
                "\n4. Back to menu" +
                "\n5. Exit");
        String choice;
        do {
            choice = scanner.nextLine();
        } while (!checkChoice.checkChoice(choice, 5));
        switch (choice) {
            case "1":
                addServices.addNewVilla();

                System.out.println("1. tiep tuc them dich vu" +
                        "\n2. quay lai menu" +
                        "\n3. Thoat");

                String choiceVilla;
                do {
                    choiceVilla = scanner.nextLine();
                } while (!checkChoice.checkChoice(choiceVilla, 3));
                switch (choiceVilla) {
                    case "1":
                        addNewServices();
                        break;
                    case "2":
                        disPlayMainMenu();
                        break;
                    case "3":
                        break;
                }
                break;
            case "2":
                addServices.addNewHouse();

                System.out.println("1. tiep tuc them dich vu" +
                        "\n2. quay lai menu" +
                        "\n3. Thoat");

                String choiceHouse;
                do {
                    choiceHouse = scanner.nextLine();
                } while (!checkChoice.checkChoice(choiceHouse, 3));
                switch (choiceHouse) {
                    case "1":
                        addNewServices();
                        break;
                    case "2":
                        disPlayMainMenu();
                        break;
                    case "3":
                        break;
                }
                break;
            case "3":
                addServices.addNewRoom();
                System.out.println("1. tiep tuc them dich vu" +
                        "\n2. quay lai menu" +
                        "\n3. Thoat");

                String choiceRoom;
                do {
                    choiceRoom = scanner.nextLine();
                } while (!checkChoice.checkChoice(choiceRoom, 3));
                switch (choiceRoom) {
                    case "1":
                        addNewServices();
                        break;
                    case "2":
                        disPlayMainMenu();
                        break;
                    case "3":
                        break;
                }
                break;
            case "4":
                disPlayMainMenu();
                break;
            case "5":
                break;
            default:

        }

    }

    public void showServices() {
        System.out.println("1. Show all Villa" +
                "\n2. Show all House" +
                "\n3. Show all Room" +
                "\n4. Show All Name Villa Not Duplicate" +
                "\n5. Show All Name House Not Duplicate" +
                "\n6. Show All Name Room Not Duplicate" +
                "\n7. Back to menu" +
                "\n8. Exit");
        String choice;
        do {
            choice = scanner.nextLine();
        } while (!checkChoice.checkChoice(choice, 8));
        switch (choice) {
            case "1":
                showServices.showVilla();
                break;
            case "2":
                showServices.showHouse();
                break;
            case "3":
                showServices.showRoom();
                break;
            case "4":
               showServices.showNameVilla();
                break;
            case "5":
                showServices.showNameHouse();
                break;
            case "6":
                showServices.showNameRoom();
                break;
            case "7":
                disPlayMainMenu();
                break;
            case "8":
                break;
            default:
        }
    }


    public static void main(String[] args) {
        MainController a = new MainController();
        a.disPlayMainMenu();
    }
}

