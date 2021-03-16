package models;

public class Villa extends Service {
 private String typeOfRoom;
 private String describe;
 private double poolArea;
 private int floor;

    public Villa() {
    }

    public Villa(String id,String nameServices, String typeOfRoom, double poolArea,int floor, String describe,  double dayRents) {
        this.typeOfRoom = typeOfRoom;
        this.describe = describe;
        this.poolArea = poolArea;
        this.floor = floor;
        this.setId(id);
        this.setDayRents(dayRents);
        this.setNameOfServices(nameServices);
    }

    public Villa(String id, String typeOfService, double usableArea,double poolArea, int numberOfPeople, String typeOfRents, String typeOfRoom, String describe, int floor, double dayRents) {
        super(id, typeOfService, usableArea, dayRents, numberOfPeople, typeOfRents);
        this.typeOfRoom = typeOfRoom;
        this.describe = describe;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String showInfor() {
//        this.setTypeOfRoom("Vip");
//        this.setPoolArea("50m2");
//        this.setDescribe("Tien nghi vip");
//        this.setSoTang("3");
//        this.setId("2");
//        this.setDayRents(100);
   //     this.setTypeOfService("Villa");

        return "- Id: "+this.getId()+
                "--- Ten dich vu: "+this.getNameOfServices()+
                "--- Tieu chuan phong: "+this.getTypeOfRoom()+
                "--- Dien tich ho boi: "+this.getPoolArea()+
                "--- So tang: "+ this.getFloor()+
                "--- Tien nghi khac: "+this.getDescribe()+
                "--- Gia dich vu: "+this.getDayRents();
    }
}
