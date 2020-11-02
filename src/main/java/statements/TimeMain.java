package statements;

import java.util.Scanner;

public class TimeMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour,minute,sec;
        System.out.println("Add meg az első időpont óra részét: ");
        hour = scanner.nextInt();
        System.out.println("Add meg az első időpont perc részét: ");
        minute = scanner.nextInt();
        System.out.println("Add meg az első időpont másodperc részét: ");
        sec = scanner.nextInt();
        Time firsTime = new Time(hour,minute,sec);

        System.out.println("Add meg az második időpont óra részét: ");
        hour = scanner.nextInt();
        System.out.println("Add meg az második időpont perc részét: ");
        minute = scanner.nextInt();
        System.out.println("Add meg az második időpont másodperc részét: ");
        sec = scanner.nextInt();
        Time secondTime = new Time(hour,minute,sec);

        System.out.println("Az első időpont: " + firsTime.toString() + " = " + firsTime.getInMinutes() + " perc.");
        System.out.println("Az második időpont: " + secondTime.toString() + " = " + secondTime.getInSeconds() + " másodperc.");

        boolean isEarlier = firsTime.earlierThan(secondTime);
        System.out.println("Az első időpont " + (isEarlier  ? "korábbi" : "későbbi") + ",mint a második.");
    }
}
