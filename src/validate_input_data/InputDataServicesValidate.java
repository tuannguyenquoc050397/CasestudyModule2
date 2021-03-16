package validate_input_data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDataServicesValidate {
    Scanner scanner = new Scanner(System.in);

    public String inputIdServices(String nameServices) {
        String regex;
        switch (nameServices) {
            case "Villa":
                regex = "^[S][V][V][L][-]\\d{4}$";
                break;
            case "House":
                regex = "^[S][V][H][O][-]\\d{4}$";
                break;
            case "Room":
                regex = "^[S][V][R][O][-]\\d{4}$";
                break;
            default:
                regex = "";
                System.out.println("viet sai ten dich vu nameServices = " + nameServices + "?????" +
                        "\n Enter de thoat");
        }
        Pattern pattern = Pattern.compile(regex);
        boolean check = true;
        String idService;
        do {
            idService = scanner.nextLine();
            Matcher matcher = pattern.matcher(idService);
            check = matcher.matches();
            if (!check) {
                System.out.println("ban da nhap sai, hay nhap theo format SVXX-YYYY, hay nhap lai");
            }
        } while (!check);
        return idService;
    }

    public String inputNameServices() {
        String regex = "[A-Z][a-z0-9]+";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex);
        String nameServices;
        do {
            nameServices = scanner.nextLine();
            matcher = pattern.matcher(nameServices);
            if (!matcher.matches()) {
                System.out.println("ban da nhap sai, viet hoa chu cai dau, hay nhap lai");
            }

        } while (!matcher.matches());
        return nameServices;
    }

    public String inputTypeOfRents() {
        String regex = "[A-Z][a-z]+";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex);
        String typeOfRents;
        do {
            typeOfRents = scanner.nextLine();
            matcher = pattern.matcher(typeOfRents);
            if (!matcher.matches()) {
                System.out.println("ban da nhap sai, viet hoa chu cai dau, hay nhap lai");
            }

        } while (!matcher.matches());
        return typeOfRents;
    }

    public String inputTypeOfRoom() {
        String regex = "[A-Z][a-z]+";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex);
        String typeOfRoom;
        do {
            typeOfRoom = scanner.nextLine();
            matcher = pattern.matcher(typeOfRoom);
            if (!matcher.matches()) {
                System.out.println("ban da nhap sai, hay viet hoa chu cai dau, hay nhap lai");
            }

        } while (!matcher.matches());
        return typeOfRoom;
    }

    public double inputAreaPool() {
        String areaPool;
        while (true) {
            try {
                areaPool = scanner.nextLine();
                if (Double.parseDouble(areaPool) < 30) {
                    throw new Exception("dien tich >30m2");
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Double.parseDouble(areaPool);
    }

    public double inputDayRents() {
        String dayRents;
        while (true) {
            try {
                dayRents = scanner.nextLine();
                if (Double.parseDouble(dayRents) <= 0) {
                    throw new Exception("chi phi thue phai >0");
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Double.parseDouble(dayRents);
    }

    public int inputNumberOfPeople() {
        String numberOfPeople;
        while (true) {
            try {
                numberOfPeople = scanner.nextLine();
                if (Integer.parseInt(numberOfPeople) < 0 || Integer.parseInt(numberOfPeople) > 20) {
                    throw new Exception("so nguoi di cung phai >0 va <20");
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Integer.parseInt(numberOfPeople);
    }

    public String inputFreeServices() {
        String freeServices;
        do {
            freeServices = scanner.nextLine();
            if (freeServices.equals("massage") || freeServices.equals("karaoke")
                    || freeServices.equals("car") || freeServices.equals("food") || freeServices.equals("drink")) {
                break;
            } else {
                System.out.println("Dịch vụ đi kèm phải là các giá trị: massage, karaoke, food, drink, car");
            }
        } while (true);
        return freeServices;
    }

    public int inputFloor() {
        String floor;
        while (true) {
            try {
                floor = scanner.nextLine();
                if (Integer.parseInt(floor) <= 0) {
                    throw new Exception("so tang phai la so nguyen duong");
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Integer.parseInt(floor);
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

    public static void main(String[] args) {
        InputDataServicesValidate a = new InputDataServicesValidate();
        // a.inputIdServices("House");
        //  a.inputAreaPool();
        try {
            String b = a.inputDateOfBirth();
            System.out.println(b);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
