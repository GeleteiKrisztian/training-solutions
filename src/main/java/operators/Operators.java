package operators;

public class Operators {

    public boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    public void multiplyByPowerOfTwo(int num,int multipleNum) {
        System.out.println((num << 1) * multipleNum);
    }

}
