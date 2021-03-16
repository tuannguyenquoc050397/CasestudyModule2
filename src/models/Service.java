package models;

public abstract class Service {
        private String id;
        private String nameOfServices;
        private double usableArea;
        private double dayRents;
        private int numberOfPeople;
        private String typeOfRents;

    public Service() {
    }

    public Service(String id, String typeOfService, double usableArea, double dayRents, int numberOfPeople, String typeOfRents) {
        this.id = id;
        this.nameOfServices = typeOfService;
        this.usableArea = usableArea;
        this.dayRents = dayRents;
        this.numberOfPeople = numberOfPeople;
        this.typeOfRents = typeOfRents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfServices() {
        return nameOfServices;
    }

    public void setNameOfServices(String nameOfServices) {
        this.nameOfServices = nameOfServices;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getDayRents() {
        return dayRents;
    }

    public void setDayRents(double dayRents) {
        this.dayRents = dayRents;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getTypeOfRents() {
        return typeOfRents;
    }

    public void setTypeOfRents(String typeOfRents) {
        this.typeOfRents = typeOfRents;
    }
    public abstract String showInfor();

}
