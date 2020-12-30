package week02d02;

import java.util.Scanner;

public class Phone {

    private String type;
    private int mem;

    public Phone(String type,int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a telefon típusát: ");
        String type = scanner.nextLine();
        System.out.println("Add meg a telefon méretét: ");
        int mem = scanner.nextInt();
        scanner.nextLine();

        Phone firstPhone = new Phone(type,mem);
        type = scanner.nextLine();
        mem = scanner.nextInt();
        scanner.nextLine();
        Phone secPhone = new Phone(type,mem);

        System.out.println("A első telefon típusa: " + firstPhone.type + ". A memória mérete: " + firstPhone.mem);
        System.out.println("A második telefon típusa: " + secPhone.type + ". A memória mérete: " + secPhone.mem);


    }
}
