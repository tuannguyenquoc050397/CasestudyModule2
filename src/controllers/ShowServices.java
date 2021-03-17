package controllers;

import file.FileUtils;
import models.House;
import models.Room;
import models.Villa;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class ShowServices {
    Scanner scanner = new Scanner(System.in);
    GetListServices getList = new GetListServices();

    public void showVilla() {
        List<Villa> listVilla = getList.getListVilla();
        for (int i = 0; i < listVilla.size(); i++) {
            System.out.println(i + 1 + ": " + listVilla.get(i).showInfor());
        }
    }

    public void showRoom() {
        List<Room> listRoomShow = getList.getListRoom();
        for (int i = 0; i < listRoomShow.size(); i++) {
            System.out.println(i + 1 + ": " + listRoomShow.get(i).showInfor());
        }
    }

    public void showHouse() {
        List<House> listHouseShow = getList.getListHouse();
        for (int i = 0; i < listHouseShow.size(); i++) {
            System.out.println(i + 1 + ": " + listHouseShow.get(i).showInfor());
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


}
