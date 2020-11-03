package statements;

public class Investment {

    private double cost = 0.3;
    private int fund;
    private int interestRate;
    private boolean active = true;

    public Investment (int fund,int interestRate) {
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public int getFund() {
        return fund;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public double getYield(int days) {
        double convhelper = interestRate / 100.0;
        double yield = (fund * convhelper) / 365 * days;
        return yield;
    }

    public double close(int days) {
        if (active == false) {
            return 0;
        }
        active = false;
        double alapHozamOsszeg = (fund + getYield(days));
        double convCostToPercentage = cost / 100.0;
        return  alapHozamOsszeg - (alapHozamOsszeg * convCostToPercentage);
    }
}
