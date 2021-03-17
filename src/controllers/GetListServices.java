package controllers;

import file.FileUtils;
import models.House;
import models.Room;
import models.Service;
import models.Villa;

import java.util.ArrayList;
import java.util.List;

public class GetListServices {
    List<Service> listService=new ArrayList<>();
    public List<Villa> getListVilla() {
        List<Villa> listVilla=new ArrayList<>();
        List<String> listVillaString = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Villa.csv");
        for (String s : listVillaString) {
            String[] lineSplit = s.split(",");
            listVilla.add(new Villa(lineSplit[0], lineSplit[1], lineSplit[2], Double.parseDouble(lineSplit[3]), Integer.parseInt(lineSplit[4]),
                    lineSplit[5], Double.parseDouble(lineSplit[6])));
        }
        return  listVilla;
    }

    public List<House> getListHouse() {
        List<House> listHouseShow = new ArrayList<>();
        List<String> listHouseString = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\House.csv");
        for (String s : listHouseString) {
            String[] lineSplit = s.split(",");
            listHouseShow.add(new House(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], Integer.parseInt(lineSplit[4]), Double.parseDouble(lineSplit[5])));
        }
        return listHouseShow;
    }

    public List<Room> getListRoom() {
        List<Room> listRoomShow = new ArrayList<>();
        List<String> listRoomString = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Room.csv");
        for (String s : listRoomString) {
            String[] lineSplit = s.split(",");
            listRoomShow.add(new Room(lineSplit[0], lineSplit[1], lineSplit[2], Double.parseDouble(lineSplit[3])));
        }
        return listRoomShow;
    }

    public static void main(String[] args) {
//        GetListServices a=new GetListServices();
//        ShowServices b=new ShowServices();
//        List<Service> list=a.getListVilla();

    }
}
