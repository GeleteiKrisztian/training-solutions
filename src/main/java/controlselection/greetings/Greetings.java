package controlselection.greetings;

import java.time.LocalTime;

public class Greetings {

    public void greetingMessage(LocalTime time) {
        String greeting = null;
        int hourToMin = time.getHour() * 60 + time.getMinute();

        if ((hourToMin > 20 * 60) || (hourToMin < 5 * 60)){
            greeting = "Jó éjt!";
        } else if(hourToMin < 9 * 60) {
            greeting = "Jó reggelt!";
        } else if (hourToMin < 18 * 60 + 30) {
            greeting = "Jó napot!";
        } else if (hourToMin < 20 * 60) {
            greeting = "Jó estét!";
        }
        System.out.println(greeting);
    }

    public static void main(String[] args) {
        Greetings greetings = new Greetings();
        greetings.greetingMessage(LocalTime.now());
    }
}
