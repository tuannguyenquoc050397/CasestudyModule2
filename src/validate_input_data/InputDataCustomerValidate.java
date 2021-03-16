package validate_input_data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDataCustomerValidate {
    Scanner scanner = new Scanner(System.in);

    public String inputNameCustomer() throws NameException {
        String regex = "^([A-Z][a-z]*\\s)+[A-Z][a-z]*$";
        Pattern pattern = Pattern.compile(regex);
        String name;
        while (true) {
            try {
                name = scanner.nextLine();
                Matcher matcher = pattern.matcher(name);
                if (!matcher.matches()) {
                    throw new NameException("Ten phai viet hoa chu cai dau, chi co 1 khoang trang o giua 2 tu" +
                            "\n vidu: Nguyen Quoc Tuan");
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    public String inputEmailCustomer() throws EmailException {
        String regex = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$";
        Pattern pattern = Pattern.compile(regex);
        String email;
        while (true) {
            try {
                email = scanner.nextLine();
                Matcher matcher = pattern.matcher(email);
                if (!matcher.matches()) {
                    throw new EmailException("email co duy nhat 1 '@' va co 1 den 2 dau '.' " +
                            "\nvidu: abc@gmail.com.vn ");
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return email;
    }

    public String inputGenderCustomer() throws GenderException {
        String gender;
        String genderResult;
        while (true) {
            try {
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
                    break;
                } else {
                    throw new GenderException("gioi tinh phai la male, female hoac unknow");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return genderResult;
    }

    public String inputIdCardCustomer() throws IdCardException {
        String regex = "^\\d{3}[ ]\\d{3}[ ]\\d{3}$";
        Pattern pattern = Pattern.compile(regex);
        String idCard;
        while (true) {
            try {
                idCard = scanner.nextLine();
                Matcher matcher = pattern.matcher(idCard);
                if (!matcher.matches()) {
                    throw new IdCardException("idCard phai theo format XXX XXX XXX" +
                            "\n vidu: 197 003 011");
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return idCard;
    }

    public String inputDateOfBirth() throws ParseException {
        Date dateNow = new Date();
        String regex = "^([0][1-9]|[1-2][0-9]|[3][0-1])[/]([0][1-9]|[1][0-2])[/]\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String birthDay;
        boolean check = true;
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
                }
            } else if (month.equals("02")) {
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
                if (Integer.parseInt(year) < 1900) {
                    System.out.println("nhap nam sinh lon hon 1900 nha!" +
                            "\n hay nhap lai");
                    check = false;
                    continue;
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
            } else {
                if (Integer.parseInt(year) < 1900) {
                    System.out.println("nhap nam sinh lon hon 1900 nha!" +
                            "\n hay nhap lai");
                    check = false;
                    continue;
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
            }

        } while (!check);

        return birthDay;
    }


    public static void main(String[] args) throws GenderException {
//        InputDataCustomerValidate a = new InputDataCustomerValidate();
//         a.inputGenderCustomer();
//        try {
//            a.inputDateOfBirth();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
}
