package validate_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckYear {
    public static boolean isLeapYear(String year){
        boolean isLeapYear = false;
        boolean isDivisibleBy4 = Integer.parseInt(year) % 4 == 0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = Integer.parseInt(year) % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = Integer.parseInt(year) % 400 == 0;
                if (isDivisibleBy400) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        return isLeapYear;
    }
    public static boolean checkYearUpTo1900AndUpTo18Age(String day, String month, String year) throws ParseException {
        Date dateNow=new Date();
    boolean check=true;
        if (Integer.parseInt(year) < 1900) {
            System.out.println("nhap nam sinh lon hon 1900 nha!" +
                    "\n hay nhap lai");
            check = false;

        }
        int yearInt = Integer.parseInt(year) + 18;
        String yearCheck = String.valueOf(yearInt);
        String birthDayCheck = day + "/" + month + "/" + yearCheck;
        Date birthDayTypeDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDayCheck);

        if (birthDayTypeDate.compareTo(dateNow) > 0) {
            System.out.println("chua du 18 tuoi" +
                    "\n hay nhap lai");
            check = false;
        }
        return check;
    }


}
