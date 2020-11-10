package controlselection.week;

public class DayOfWeeks {

    public String stringFromWeekNames(String dayName) {

        String returnData = "";
        switch (dayName.toLowerCase()) {
            case "hétfő":
                returnData = "Hét eleje";
                break;
            case "kedd":
            case "szerda":
            case "csütörtök":
                returnData = "Hét közepe";
                break;
            case "péntek":
                returnData = "Majdnem hétvége";
                break;
            case "szombat":
            case "vasárnap":
                returnData = "Hét vége";
                break;
            default:
                throw new IllegalArgumentException("Invalid day: " + dayName);
        }
        return returnData;
    }

    public static void main(String[] args) {
        DayOfWeeks dayOfWeeks = new DayOfWeeks();
        System.out.println(dayOfWeeks.stringFromWeekNames("Péntek"));
    }

}
