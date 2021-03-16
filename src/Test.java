import java.util.Scanner;

public class Test {
    Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
//        boolean check=false;
        Test test=new Test();
//        String a;
//        char b;
//        do {
//            System.out.println("an 1 hoac 2");
//              a=scanner.nextLine();
//              if(a.length()==1){
//               b=a.charAt(0);
//              }else {
//                  b='q';
//              }
//            if (b=='1'||b=='2'){
//                check=true;
//            }
//        }while (!check);
//        switch (b){
//            case '2':
//                test.add();
//                break;
//            case '1':
//                break;
//            default:
//
//        }

        System.out.println("1. Add New Services" +
                "\n2. Show Services" +
                "\n3. Add New Customer" +
                "\n4. Show Information of Customer" +
                "\n5. Add New Booking" +
                "\n6. Show Information of Employee"+
                "\n7. Exit"+
                "\n");
        String choice=scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("1. Add New Villa"+
                        "\n2. Add New House"+
                        "\n3. Add New Room" +
                        "\n4. Back to menu" +
                        "\n5. Exit");
                byte choice1=scanner.nextByte();
                switch (choice1){
                    case 1:
                        System.out.println("Nhap thong tin");
                        String c=scanner.nextLine();
                        System.out.println("nhap d");
                        String d=scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("22");
                        break;
                    default:
                        System.out.println("55");
                }
                break;
            case "2":
                System.out.println("nhap c");
                int c=scanner.nextInt();
            default:
        }

    }
    public void add(){
        System.out.println("1. Add New Villa"+
                "\n2. Add New House"+
                "\n3. Add New Room" +
                "\n4. Back to menu" +
                "\n5. Exit");
        byte choice=scanner.nextByte();
        switch (choice){
            case 1:
                System.out.println("Nhap thong tin");
                String c=scanner.nextLine();
                System.out.println("nhap d");
                String d=scanner.nextLine();
        }
    }
}
