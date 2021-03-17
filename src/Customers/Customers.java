package Customers;
import controllers.GetListServices;
import controllers.MainController;
import file.FileUtils;
import models.House;
import models.Room;
import models.Villa;
import sort.CustomerSort;
import validate_exception.*;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Customers {
    public static void addNewCustomer() {
        ValidateCheckChoice checkChoice = new ValidateCheckChoice();
        InputDataCustomerValidate inputCustomer = new InputDataCustomerValidate();
        MainController mainController = new MainController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap ten khach hang");
        String nameCustomer;
        while (true) {
            try {
                nameCustomer = inputCustomer.inputNameCustomer();
                break;
            } catch (NameException e) {
                e.printStackTrace();
            }
        }
        System.out.println("nhap ngay sinh");
        String dayOfBirth = null;
        try {
            dayOfBirth = inputCustomer.inputDateOfBirth();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("nhap gioi tinh");
        String gender;
        while (true) {
            try {
                gender = inputCustomer.inputGenderCustomer();
                break;
            } catch (GenderException e) {
                e.printStackTrace();
            }
        }

        System.out.println("nhap cmnd");
        String cmnd;
        while (true) {
            try {
                cmnd = inputCustomer.inputIdCardCustomer();
                break;
            } catch (IdCardException e) {
                e.printStackTrace();
            }
        }

        System.out.println("nhap so dien thoai");
        String numberPhone = scanner.nextLine();
        System.out.println("nhap email");
        String email;
        while (true) {
            try {
                email = inputCustomer.inputEmailCustomer();
                break;
            } catch (EmailException e) {
                e.printStackTrace();
            }
        }
        System.out.println("nhap loai khach hang");
        String typeOfCustomer = scanner.nextLine();
        System.out.println("nhap dia chi");
        String address = scanner.nextLine();
        String line = nameCustomer + "," + dayOfBirth + "," + gender + "," + cmnd + "," + numberPhone + "," + email + "," + typeOfCustomer + "," +
                address;
        File file = new File("D:\\caseStudy_module2\\src\\file\\Customer.csv");
        List<String> listCustomerString = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Customer.csv");
        listCustomerString.add(line);
        file.delete();
        for (String s : listCustomerString) {
            FileUtils.writeFile("D:\\caseStudy_module2\\src\\file\\Customer.csv", s);
        }
        System.out.println("them thanh cong!");
        System.out.println("1. tiep tuc them customer" +
                "\n2. quay lai menu" +
                "\n3. Thoat");

        String choiceAddCustomer;
        do {
            choiceAddCustomer = scanner.nextLine();
        } while (!checkChoice.checkChoice(choiceAddCustomer, 3));
        switch (choiceAddCustomer) {
            case "1":
                Customers.addNewCustomer();
                break;
            case "2":
                mainController.disPlayMainMenu();
                break;
            case "3":
                break;
        }
    }

    public static List<Customer> showInformationCustomer() {
        List<Customer> listCustomer = new ArrayList<>();
        List<String> listCustomerString = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Customer.csv");
        for (String s : listCustomerString) {
            String[] lineSplit = s.split(",");
            listCustomer.add(new Customer(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3],
                    lineSplit[4], lineSplit[5], lineSplit[6], lineSplit[7]));
        }
        Collections.sort(listCustomer, new CustomerSort());
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println(i + 1 + ": " + listCustomer.get(i).showInFor());
        }
        return listCustomer;
    }

    public static void addNewBooking() {
        GetListServices getList = new GetListServices();
        MainController mainController = new MainController();
        ValidateCheckChoice checkChoice = new ValidateCheckChoice();
        Scanner scanner = new Scanner(System.in);
        List<Customer> listCustomer = showInformationCustomer();
        System.out.println("an so thu tu cua customer ban chon: ");
        String index;
        String choiceBooking;
        do {
            index = scanner.nextLine();
        } while (!checkChoice.checkChoice(index, listCustomer.size()));
        Customer customer = listCustomer.get(Integer.parseInt(index) - 1);
        String lineBooking = customer.getNameCustomer() + "," + customer.getDayOfBirth() + "," + customer.getGender() + "," + customer.getIdCard()
                + "," + customer.getNumberPhone() + "," + customer.getEmail() + "," + customer.getTypeOfCustomer() + "," + customer.getAddress();
        System.out.println("them dich vu cho khach hang " + customer.getNameCustomer());
        System.out.println("1. Booking Villa" +
                "\n2. Booking House" +
                "\n3. Booking Room");
        do {
            choiceBooking = scanner.nextLine();
        } while (!checkChoice.checkChoice(choiceBooking, 3));
        switch (choiceBooking) {
            case "1":
                List<Villa> listVilla = getList.getListVilla();
                System.out.println("chon so thu tu cua dich vu villa muon booking: ");
                String indexVilla;
                do {
                    indexVilla = scanner.nextLine();
                } while (!checkChoice.checkChoice(indexVilla, listVilla.size()));
                customer.setUseServices(listVilla.get(Integer.parseInt(indexVilla) - 1));
                lineBooking += "," + customer.getUseServices().showInfor();
                FileUtils.writeFile("D:\\caseStudy_module2\\src\\file\\Booking.csv", lineBooking);
                System.out.println("them thanh cong");
                break;
            case "2":
                List<House> listHouse = getList.getListHouse();
                System.out.println("chon so thu tu cua dich vu house muon booking: ");
                String indexHouse;
                do {
                    indexHouse = scanner.nextLine();
                } while (!checkChoice.checkChoice(indexHouse, listHouse.size()));
                customer.setUseServices(listHouse.get(Integer.parseInt(indexHouse) - 1));
                lineBooking += "," + customer.getUseServices().showInfor();
                FileUtils.writeFile("D:\\caseStudy_module2\\src\\file\\Booking.csv", lineBooking);
                System.out.println("them thanh cong");

                break;
            case "3":
                List<Room> listRoom = getList.getListRoom();
                System.out.println("chon so thu tu cua dich vu house muon booking: ");
                String indexRoom;
                do {
                    indexRoom = scanner.nextLine();
                } while (!checkChoice.checkChoice(indexRoom, listRoom.size()));
                customer.setUseServices(listRoom.get(Integer.parseInt(indexRoom) - 1));
                lineBooking += "," + customer.getUseServices().showInfor();
                FileUtils.writeFile("D:\\caseStudy_module2\\src\\file\\Booking.csv", lineBooking);
                System.out.println("them thanh cong");
                break;
            default:
                System.out.println("1. tiep tuc them booking" +
                        "\n2. quay lai menu" +
                        "\n3. Thoat");

                String choiceAddBooking;
                do {
                    choiceAddBooking = scanner.nextLine();
                } while (!checkChoice.checkChoice(choiceAddBooking, 3));
                switch (choiceAddBooking) {
                    case "1":
                        Customers.addNewBooking();
                        break;
                    case "2":
                        mainController.disPlayMainMenu();
                        break;
                    case "3":
                        break;
                }
        }
    }

    public static void main(String[] args) {
//        Customers.addNewCustomer();
        //  Customers.showInformationCustomer();
        //   Customers.addNewBooking();
    }
}
