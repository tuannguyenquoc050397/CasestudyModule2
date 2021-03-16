package employee;

import controllers.MainController;
import file.FileUtils;

import java.util.*;

public class EmployeeTask11 {
    private Stack<Employee> stackEmployee = new Stack<>();
    Scanner scanner = new Scanner(System.in);


    public Stack<Employee> getStackEmployee() {
        return stackEmployee;
    }

    public void addEmployeeInStack(Employee employee) {
        this.stackEmployee.push(employee);
    }

    public void searchNameEmployee() {
        System.out.println("nhap ten nhan vien");
        String name = scanner.nextLine();
        for (int i = 0; i < stackEmployee.size(); i++) {
            if (name.equals(stackEmployee.get(i).getNameEmployee())) {
                System.out.println(stackEmployee.get(i).toString());
            }
        }
    }

    public void searchCodeEmployee() {
        System.out.println("nhap ma nhan vien");
        String code = scanner.nextLine();
        for (int i = 0; i < stackEmployee.size(); i++) {
            if (code.equals(stackEmployee.get(i).getEmployeeCode())) {
                System.out.println(stackEmployee.get(i).toString());
                break;
            }
        }
    }

    public static void main(String[] args) {
//        EmployeeTask11 employeeTask11=new EmployeeTask11();
//        List<String> listEmployeeStr= FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Employee.csv");
//        for (String s:listEmployeeStr){
//            String[] lineSplit=s.split(",");
//            employeeTask11.addEmployeeInStack(new Employee(lineSplit[0],lineSplit[1],Byte.parseByte(lineSplit[2]),lineSplit[3]));
//        }
//        employeeTask11.searchCodeEmployee();
//        employeeTask11.searchNameEmployee();
    }

}
