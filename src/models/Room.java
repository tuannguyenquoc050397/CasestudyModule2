package models;

public class Room extends Service {
    private String freeService="22";

    public Room() {
    }

    public Room(String id, String nameServices, String freeService, double dayRents) {
        this.freeService = freeService;
        this.setId(id);
        this.setDayRents(dayRents);
        this.setNameOfServices(nameServices);
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
    @Override
    public String showInfor() {
//        this.setId("1");
//        this.setDayRents(10);
        this.setNameOfServices("Room");

        return "- Id: "+this.getId()+
                "--- Ten dich vu: "+this.getNameOfServices()+
                "--- Loai dich vu: "+this.getNameOfServices()+
                "--- Gia dich vu: "+this.getDayRents()+
                "--- Dich vu mien phi: "+ this.getFreeService();
    }

}
