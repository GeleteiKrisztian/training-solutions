package week03d05;

public class Operation {

    private int leftOperand;
    private int rightOperand;

    public Operation(String s) {
        if (isNullOrEmpty(s)) {
            throw new IllegalArgumentException("Argument is null or empty.");
        }
        String[] split = s.split("\\+");
        leftOperand = Integer.parseInt(split[0]);
        rightOperand = Integer.parseInt(split[1]);
    }

    public int getResult() {
        return leftOperand + rightOperand;
    }

    private boolean isNullOrEmpty(String s) {
        if(s == null || s.isBlank()) {
            return true;
        }
        return false;
    }

}
