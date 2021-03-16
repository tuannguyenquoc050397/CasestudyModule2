package employee;

public class Employee {
    private String employeeCode;
    private String nameEmployee;
    private byte ageEmployee;
    private String addressEmployee;

    public Employee(String employeeCode, String nameEmployee, byte ageEmployee, String addressEmployee) {
        this.employeeCode = employeeCode;
        this.nameEmployee = nameEmployee;
        this.ageEmployee = ageEmployee;
        this.addressEmployee = addressEmployee;
    }

    public Employee() {
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public byte getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(byte ageEmployee) {
        this.ageEmployee = ageEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode=" + employeeCode +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", ageEmployee=" + ageEmployee +
                ", addressEmployee='" + addressEmployee + '\'' +
                '}';
    }
}
