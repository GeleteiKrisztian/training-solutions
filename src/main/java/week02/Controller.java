package week02;

import java.util.Scanner;

public class Controller {

    private Office office;

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }

    public void readOffice() {
        office = new Office();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a rögzíteni kívánt tárgyalók számát:");
        int numberOfMeetingRooms = scanner.nextInt();
        scanner.nextLine(); //Ez fárasztó

        for (int i = 0; i < numberOfMeetingRooms; i++) {
            System.out.println("Add meg a(z) " + (i + 1) + ". tárgyaló nevét:");
            String name = scanner.nextLine();
            System.out.println("Add meg a(z) " + (i + 1) + ". tárgyaló szélességét:");
            int width = scanner.nextInt();
            System.out.println("Add meg a(z) " + (i + 1) + ". tárgyaló hosszát:");
            int length = scanner.nextInt();
            scanner.nextLine();

            MeetingRoom meetingRoom = new MeetingRoom(name,length,width);
            office.addMeetingRoom(meetingRoom);
        }
    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben\n" +
        "2. Tárgyalók visszafele sorrendben\n" +
        "3. Minden második tárgyaló\n" +
        "4. Területek\n" +
        "5. Keresés pontos név alapján\n" +
        "6. Keresés névtöredék alapján\n" +
        "7. Keresés terület alapján\n");
    }

    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek válassz menüpontot:\n");
        int menuSelected = scanner.nextInt();
        scanner.nextLine();

        switch (menuSelected) {
            case 1:
                System.out.println("Tárgyalók sorrendben...");
                office.printNames();
                break;
            case 2:
                System.out.println("Tárgyalók visszafele sorrendben...");
                office.printNamesReverse();
                break;
            case 3:
                System.out.println("Minden második tárgyaló...");
                office.printEventNames();
                break;
            case 4:
                System.out.println("Területek...");
                office.printAreas();
                break;
            case 5:
                System.out.println("Keresés pontos név alapján...");
                System.out.println("Kérlek add meg a tárgyaló pontos nevét:");
                String nameInp = scanner.nextLine();
                office.printMeetingRoomsWithName(nameInp);
                break;
            case 6:
                System.out.println("Keresés névtöredék alapján...");
                System.out.println("Kérlek adj meg egy részt a tárgyaló nevéből:");
                String nameInput = scanner.nextLine();
                office.printMeetingRoomsContains(nameInput);
                break;
            case 7:
                System.out.println("Keresés terület alapján...");
                System.out.println("Kérlek add meg a szükséges területet:");
                int areaInp = scanner.nextInt();
                office.printAreasLargerThan(areaInp);
                break;
        }

    }

}
