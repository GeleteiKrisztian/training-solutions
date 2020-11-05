package week02;

import java.util.Scanner;

public class InputNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[5];

        for (int i = 0; i < names.length;i++) {
            System.out.println("Add meg a(z) " + (i+1) + ". nevet: ");
            String nameInp = scanner.nextLine();
            names[i] = nameInp;
        }

        for (String item : names) {
            System.out.println(item);
        }
    }
}
