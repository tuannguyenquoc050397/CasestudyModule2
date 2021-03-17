package controllers;

import file.FileUtils;
import validate_exception.InputDataServicesValidate;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class AddServices {
    Scanner scanner = new Scanner(System.in);
    InputDataServicesValidate inputValidate = new InputDataServicesValidate();

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
}
