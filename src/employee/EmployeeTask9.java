package employee;

import file.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeTask9 {
    public static void showEmployeeMap() {
        List<String> listEmployeeStr = FileUtils.readFile("D:\\caseStudy_module2\\src\\file\\Employee.csv");
        Map<String, Employee> mapEmployee = new HashMap<>();
        for (String s : listEmployeeStr) {
            String[] lineSplit = s.split(",");
            mapEmployee.put(lineSplit[0], new Employee(lineSplit[0], lineSplit[1], Byte.parseByte(lineSplit[2]), lineSplit[3]));
        }
        for (String key : mapEmployee.keySet()) {
            System.out.println(mapEmployee.get(key));
        }
    }

}
