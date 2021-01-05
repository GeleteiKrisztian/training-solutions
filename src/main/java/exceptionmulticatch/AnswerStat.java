package exceptionmulticatch;

public class AnswerStat {

    private BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String ans) {
        boolean[] bools;
        try {
            bools = binaryStringConverter.binaryStringToBooleanArray(ans);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidBinaryStringException("binaryString null", e);
        }
        return bools;
    }

    public int answerTruePercent(String answers) {
        boolean[] bools = convert(answers);
        int counter = 0;
        for (boolean item : bools) {
            if (item == true) {
                ++counter;
            }
        }
        return counter * 100 / bools.length;
    }

}
