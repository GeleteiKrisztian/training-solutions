package week16d05;

import java.time.LocalDate;

public class Country {

    private LocalDate date;
    private String yearWeek;
    private int casesWeekly;
    private int deathsWeekly;
    private String countriesAndTerritiories;
    private String geoId;
    private String countryTerritoryCode;
    private int popData2019;
    private String continentExp;
    private int notificationRatePer100_000population14Days;
    private double populationPerCaseRate;

    public Country(LocalDate date, String yearWeek, int casesWeekly, int deathsWeekly, String countriesAndTerritiories, String geoId, String countryTerritoryCode, int popData2019, String continentExp, int notificationRatePer100_000population14Days, double populationPerCaseRate) {
        this.date = date;
        this.yearWeek = yearWeek;
        this.casesWeekly = casesWeekly;
        this.deathsWeekly = deathsWeekly;
        this.countriesAndTerritiories = countriesAndTerritiories;
        this.geoId = geoId;
        this.countryTerritoryCode = countryTerritoryCode;
        this.popData2019 = popData2019;
        this.continentExp = continentExp;
        this.notificationRatePer100_000population14Days = notificationRatePer100_000population14Days;
        this.populationPerCaseRate = populationPerCaseRate;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getYearWeek() {
        return yearWeek;
    }

    public int getCasesWeekly() {
        return casesWeekly;
    }

    public int getDeathsWeekly() {
        return deathsWeekly;
    }

    public String getCountriesAndTerritiories() {
        return countriesAndTerritiories;
    }

    public String getGeoId() {
        return geoId;
    }

    public String getCountryTerritoryCode() {
        return countryTerritoryCode;
    }

    public int getPopData2019() {
        return popData2019;
    }

    public String getContinentExp() {
        return continentExp;
    }

    public int getNotificationRatePer100_000population14Days() {
        return notificationRatePer100_000population14Days;
    }

    public double getPopulationPerCaseRate() {
        return populationPerCaseRate;
    }
}
