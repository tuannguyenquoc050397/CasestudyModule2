package validate_exception;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDataCustomerValidate {
    Scanner scanner = new Scanner(System.in);

    public String inputNameCustomer() throws NameException {
        String regex = "^([A-Z][a-z]*\\s)+[A-Z][a-z]*$";
        Pattern pattern = Pattern.compile(regex);
        String name;
        name = scanner.nextLine();
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new NameException("Ten phai viet hoa chu cai dau, chi co 1 khoang trang o giua 2 tu" +
                    "\n vidu: Nguyen Quoc Tuan");
        }
        return name;
    }

    public String inputEmailCustomer() throws EmailException {
        String regex = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$";
        Pattern pattern = Pattern.compile(regex);
        String email;
        email = scanner.nextLine();
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new EmailException("email co duy nhat 1 '@' va co 1 den 2 dau '.' " +
                    "\nvidu: abc@gmail.com.vn ");
        }
        return email;
    }

    public String inputGenderCustomer() throws GenderException {
        String gender;
        String genderResult;
        gender = scanner.nextLine();
        String genderTrim = gender.trim();
        if (genderTrim.length() == 4 || genderTrim.length() == 6) {
            String genderUp = genderTrim.toUpperCase();
            switch (genderUp) {
                case "MALE":
                    genderResult = "Male";
                    break;
                case "FEMALE":
                    genderResult = "Female";
                    break;
                case "UNKNOW":
                    genderResult = "Unknow";
                    break;
                default:
                    throw new GenderException("gioi tinh phai la male, female hoac unknow");
            }
            System.out.println(genderResult);
        } else {
            throw new GenderException("gioi tinh phai la male, female hoac unknow");
        }

        return genderResult;
    }

    public String inputIdCardCustomer() throws IdCardException {
        String regex = "^\\d{3}[ ]\\d{3}[ ]\\d{3}$";
        Pattern pattern = Pattern.compile(regex);
        String idCard;
        idCard = scanner.nextLine();
        Matcher matcher = pattern.matcher(idCard);
        if (!matcher.matches()) {
            throw new IdCardException("idCard phai theo format XXX XXX XXX" +
                    "\n vidu: 197 003 011");
        }
        return idCard;
    }

    public String inputDateOfBirth() throws ParseException {
        String regex = "^([0][1-9]|[1-2][0-9]|[3][0-1])[/]([0][1-9]|[1][0-2])[/]\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String birthDay;
        boolean check;
        do {
            check = true;
            birthDay = scanner.nextLine();
            matcher = pattern.matcher(birthDay);
            if (!matcher.matches()) {
                System.out.println("nhap sai format dd/MM/yyyy hoac sai ngay thang gi day (31 ngay, 12 thang)" +
                        "\n hay nhap lai");
                check = false;
                continue;
            }
            String month = birthDay.substring(3, 5);
            String day = birthDay.substring(0, 2);
            String year = birthDay.substring(6);
            if (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) {
                if (Integer.parseInt(day) > 30) {
                    System.out.println("thang 4, 6, 9, 11 co toi da 30 ngay thoi" +
                            "\n hay nhap lai");
                    check = false;

                } else {
                    if (!CheckYear.checkYearUpTo1900AndUpTo18Age(day, month, year)) {
                        check = false;
                    }
                }
            } else if (month.equals("02")) {
                boolean isLeapYear = CheckYear.isLeapYear(year);
                if (!isLeapYear) {
                    if (Integer.parseInt(day) > 28) {
                        System.out.println("nam " + year + " ko phai nam nhuan. cao nhat 28 ngay thoi" +
                                "\n hay nhap lai");
                        check = false;
                        continue;
                    }
                }
                if (isLeapYear) {
                    if (Integer.parseInt(day) > 29) {
                        System.out.println("nam " + year + " la nam nhuan. cao nhat 29 ngay thoi" +
                                "\n hay nhap lai");
                        check = false;
                        continue;
                    }
                }
                if (!CheckYear.checkYearUpTo1900AndUpTo18Age(day, month, year)) {
                    check = false;
                }
            } else {
                if (!CheckYear.checkYearUpTo1900AndUpTo18Age(day, month, year)) {
                    check = false;
                }
            }
        } while (!check);

        return birthDay;
    }

    public static void main(String[] args) {
        InputDataCustomerValidate a = new InputDataCustomerValidate();
        try {
            a.inputDateOfBirth();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
