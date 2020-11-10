package controlselection.month;

public class DayInMonth {

    public int monthDaysFromYearAndName(int year,String monthName) {
        boolean isFebruar29 = false;
        int returnvalue = -1;

        if(year % 4 == 0) {
            if( year % 100 == 0) {
                if ( year % 400 == 0)
                    isFebruar29 = true;
                else
                    isFebruar29 = false;
            }
            else
                isFebruar29 = true;
        }
        else
            isFebruar29 = false;

        switch (monthName.toLowerCase()) {
            case "január":
            case "március":
            case "május":
            case "július":
            case "augusztus":
            case "október":
            case "december":
                returnvalue = 31;
                break;
            case "február":
                if(isFebruar29) {
                    returnvalue = 29;
                    break;
                }
                returnvalue = 28;
                break;
            case "április":
            case "június":
            case "szeptember":
            case "november":
                returnvalue = 30;
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + monthName);
        }
        return returnvalue;
    }

    public static void main(String[] args) {
        DayInMonth dayInMonth = new DayInMonth();
        System.out.println(dayInMonth.monthDaysFromYearAndName(2000,"február"));
    }

}
