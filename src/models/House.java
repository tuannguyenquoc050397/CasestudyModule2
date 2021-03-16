package models;

public class House extends Service {
    private String typeOfRoom;
    private String describe;
    private int Floor;

    public House() {
    }

    public House(String id,String nameServices, String typeOfRoom, String describe, int floor, double dayRents) {
        this.typeOfRoom = typeOfRoom;
        this.describe = describe;
        Floor = floor;
        this.setId(id);
        this.setDayRents(dayRents);
        this.setNameOfServices(nameServices);
    }

    public House(String id, String typeOfService, double usableArea, double dayRents, int numberOfPeople, String typeOfRents, String typeOfRoom, String describe, int floor) {
        super(id, typeOfService, usableArea, dayRents, numberOfPeople, typeOfRents);
        this.typeOfRoom = typeOfRoom;
        this.describe = describe;
        Floor = floor;
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

    public int getFloor() {
        return Floor;
    }

    public void setFloor(int floor) {
        this.Floor = floor;
    }

    @Override
    public String showInfor() {

//        this.setTypeOfRoom("Vip");
//        this.setDescribe("Tien nghi vip");
//        this.setSoTang("2");
//        this.setId("3");
//        this.setDayRents(50);
        this.setNameOfServices("House");
        return "- Id: "+this.getId()+
                "--- ten dich vu"+this.getNameOfServices()+
                "--- Tieu chuan phong: "+this.getTypeOfRoom()+
                "--- Tien nghi khac: "+this.getDescribe()+
                "--- So tang: "+ this.getFloor()+
        "--- Gia dich vu: "+this.getDayRents();
    }
}
