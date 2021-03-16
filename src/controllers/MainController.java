package controllers;

import Customers.Customers;
import employee.EmployeeTask9;
import file.FileUtils;
import models.House;
import models.Room;
import models.Villa;
import sort.SortNameServices;
import validate_input_data.ExceptionCheckChoice;
import validate_input_data.InputDataServicesValidate;

import java.io.File;
import java.util.*;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    private InputDataServicesValidate inputValidate = new InputDataServicesValidate();

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
        } while (!checkChoice(choice, 7));
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

    public void validateChoice(int numOfChoice, int numIn) throws ExceptionCheckChoice {
        if (numIn <= 0 || numIn > numOfChoice) {
            throw new ExceptionCheckChoice("co cac lua chon tu 1 den " + numOfChoice);
        }
    }

    public boolean checkChoice(String choice, int numOfChoice) {
        try {
            validateChoice(numOfChoice, Integer.parseInt(choice));
            return true;
        } catch (ExceptionCheckChoice m) {
            System.out.println(m + "\n-----" +
                    "\nhay nhap lai");
            return false;
        } catch (Exception e) {
            System.out.println("loi nhap" +
                    "\nhay nhap lai");
            return false;
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
        } while (!checkChoice(choice, 5));
        switch (choice) {
            case "1":
                addNewVilla();

                System.out.println("1. tiep tuc them dich vu" +
                        "\n2. quay lai menu" +
                        "\n3. Thoat");

                String choiceVilla;
                do {
                    choiceVilla = scanner.nextLine();
                } while (!checkChoice(choiceVilla, 3));
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
                addNewHouse();

                System.out.println("1. tiep tuc them dich vu" +
                        "\n2. quay lai menu" +
                        "\n3. Thoat");

                String choiceHouse;
                do {
                    choiceHouse = scanner.nextLine();
                } while (!checkChoice(choiceHouse, 3));
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
                addNewRoom();
                System.out.println("1. tiep tuc them dich vu" +
                        "\n2. quay lai menu" +
                        "\n3. Thoat");

                String choiceRoom;
                do {
                    choiceRoom = scanner.nextLine();
                } while (!checkChoice(choiceRoom, 3));
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

    public void addNewHouse() {
        System.out.println("nhap Id:");
        String id = inputValidate.inputIdServices("House");
        System.out.println("nhap ten dich vu");
        String name = inputValidate.inputNameServices();
        System.out.println("nhap tieu chuan phong:");
        String typeOfRoom = (inputValidate.inputTypeOfRoom());
        System.out.println("nhap tien nghi khac:");
        String describe = scanner.nextLine();
        System.out.println("nhap so tang: ");
        int floor = inputValidate.inputFloor();
        System.out.println("nhap gia dich vu:");
        double dayRents = inputValidate.inputDayRents();
        String line = id + "," + name + "," + typeOfRoom + "," + describe +
                "," + floor + "," + dayRents;

        File file = new File("D:\\caseStudy_module2\\src\\file\\House.csv");
        List<String> ListLine = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\House.csv");
        ListLine.add(line);
        file.delete();
        for (String s : ListLine) {
            FileUtils.writeFile("D:\\caseStudy_module2\\src\\file\\House.csv", s);
        }
        System.out.println("them thanh cong!");
    }

    public void addNewRoom() {
        System.out.println("nhap Id:");
        String id = inputValidate.inputIdServices("Room");
        System.out.println("nhap ten dich vu");
        String name = inputValidate.inputNameServices();
        System.out.println("Nhap dich vu mien phi di kiem: ");
        String freeServices = inputValidate.inputFreeServices();
        System.out.println("nhap gia dich vu:");
        double dayRents = inputValidate.inputDayRents();
        String line = id + "," + name + "," + freeServices + "," + dayRents;
        File file = new File("D:\\caseStudy_module2\\src\\file\\Room.csv");
        List<String> ListLine = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Room.csv");
        ListLine.add(line);
        file.delete();
        for (String s : ListLine) {
            FileUtils.writeFile("D:\\caseStudy_module2\\src\\file\\Room.csv", s);
        }
        System.out.println("them thanh cong!");

    }

    public void addNewVilla() {
        System.out.println("nhap Id:");
        String id = inputValidate.inputIdServices("Villa");
        System.out.println("nhap ten dich vu");
        String name = inputValidate.inputNameServices();
        System.out.println("nhap tieu chuan phong:");
        String typeOfRoom = inputValidate.inputTypeOfRoom();
        System.out.println("nhap dien tich ho boi:");
        double areaPool = inputValidate.inputAreaPool();
        System.out.println("nhap so tang:");
        int floor = inputValidate.inputFloor();
        System.out.println("nhap tien nghi khac:");
        String describe = scanner.nextLine();
        System.out.println("nhap gia dich vu: ");
        double dayRents = inputValidate.inputDayRents();
        String line = id + "," + name + "," + typeOfRoom + "," + areaPool + "," + floor +
                "," + describe + "," + dayRents;
        File file = new File("D:\\caseStudy_module2\\src\\file\\Villa.csv");
        List<String> ListLine = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Villa.csv");
        ListLine.add(line);
        file.delete();
        for (String s : ListLine) {
            FileUtils.writeFile("D:\\caseStudy_module2\\src\\file\\Villa.csv", s);
        }
        System.out.println("them thanh cong!");
    }

    public List<Villa> showVilla() {
        List<Villa> listVilla = new ArrayList<>();
        List<String> listVillaString = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Villa.csv");
        for (String s : listVillaString) {
            String[] lineSplit = s.split(",");
            listVilla.add(new Villa(lineSplit[0], lineSplit[1], lineSplit[2], Double.parseDouble(lineSplit[3]), Integer.parseInt(lineSplit[4]),
                    lineSplit[5], Double.parseDouble(lineSplit[6])));
        }
        for (int i = 0; i < listVilla.size(); i++) {
            System.out.println(i + 1 + ": " + listVilla.get(i).showInfor());
        }
        return listVilla;
    }

    public List<Room> showRoom() {
        List<Room> listRoomShow = new ArrayList<>();
        List<String> listRoomString = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Room.csv");
        for (String s : listRoomString) {
            String[] lineSplit = s.split(",");
            listRoomShow.add(new Room(lineSplit[0], lineSplit[1], lineSplit[2], Double.parseDouble(lineSplit[3])));
        }
        for (int i = 0; i < listRoomShow.size(); i++) {
            System.out.println(i + 1 + ": " + listRoomShow.get(i).showInfor());
        }
        return listRoomShow;
    }

    public List<House> showHouse() {
        List<House> listHouseShow = new ArrayList<>();
        List<String> listHouseString = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\House.csv");
        for (String s : listHouseString) {
            String[] lineSplit = s.split(",");
            listHouseShow.add(new House(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], Integer.parseInt(lineSplit[4]), Double.parseDouble(lineSplit[5])));
        }
        for (int i = 0; i < listHouseShow.size(); i++) {
            System.out.println(i + 1 + ": " + listHouseShow.get(i).showInfor());
        }
        return listHouseShow;
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
        } while (!checkChoice(choice, 8));
        switch (choice) {
            case "1":
                showVilla();
                break;
            case "2":
                showHouse();
                break;
            case "3":
                showRoom();
                break;
            case "4":
                showNameVilla();
                break;
            case "5":
                showNameHouse();
                break;
            case "6":
                showNameRoom();
                break;
            case "7":
                disPlayMainMenu();
                break;
            case "8":
                break;
            default:
        }
    }

    public void showNameVilla() {
        TreeSet<String> listNameVilla = new TreeSet<>();
        List<String> listVilla = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Villa.csv");
        for (String s : listVilla) {
            String[] lineSplit = s.split(",");
            listNameVilla.add(lineSplit[1]);
        }
       // Collections.sort(listNameVilla, new SortNameServices());
        System.out.println(listNameVilla);
    }

    public void showNameHouse() {
        TreeSet<String> listNameHouse = new TreeSet<>();
        List<String> listHouse = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\House.csv");
        for (String s : listHouse) {
            String[] lineSplit = s.split(",");
            listNameHouse.add(lineSplit[1]);
        }
        System.out.println(listNameHouse);
    }

    public void showNameRoom() {
        TreeSet<String> listNameRoom = new TreeSet<>();
        List<String> listRoom = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Room.csv");
        for (String s : listRoom) {
            String[] lineSplit = s.split(",");
            listNameRoom.add(lineSplit[1]);
        }
        System.out.println(listNameRoom);
    }

    public static void main(String[] args) {
        MainController a = new MainController();
        a.disPlayMainMenu();
    }
}

