package ioprintwriter;

public enum Titles {
    DR(500_000), MR(200_000), MRS(200_000), OTHER(100_000);

    private int salary;

    Titles(int i) {
        salary = i;
    }

    public int getSalary() {
        return salary;
    }
}
