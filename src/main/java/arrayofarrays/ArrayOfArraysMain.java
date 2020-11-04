package arrayofarrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {
        int [][] arrOfArr = new int[size][size];
                for (int i = 0;i < arrOfArr.length;i++) {
                    for (int j = 0;j < arrOfArr[i].length;j++) {
                        arrOfArr[i][j] = (i+1) * (j+1);
                    }
                }
                return arrOfArr;
        }

    public void printArrayOfArrays(int[][] a) {
        for (int i = 0;i < a.length;i++) {
            for (int j = 0;j< a[i].length;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] triangularMatrix(int size) {
        int[][] arrOfArr = new int[size][];
        for (int i = 0;i < size;i++) {
            arrOfArr[i] = new int[i+1];
            for (int j = 0;j < arrOfArr[i].length;j++) {
                arrOfArr[i][j] = i;
            }
        }
        return arrOfArr;
    }

    public int[][] getValues() {
        int[][] arrOfArr = new int[12][];
        arrOfArr[0] = new int[31];
        arrOfArr[1] = new int[28];
        arrOfArr[2] = new int[31];
        arrOfArr[3] = new int[30];
        arrOfArr[4] = new int[31];
        arrOfArr[5] = new int[30];
        arrOfArr[6] = new int[31];
        arrOfArr[7] = new int[31];
        arrOfArr[8] = new int[30];
        arrOfArr[9] = new int[31];
        arrOfArr[10] = new int[30];
        arrOfArr[11] = new int[31];
        return arrOfArr;
    }

    public static void main(String[] args) {
        ArrayOfArraysMain arrOfArrMain = new ArrayOfArraysMain();

        int[][] arrOfArr = arrOfArrMain.multiplicationTable(4);
        arrOfArrMain.printArrayOfArrays(arrOfArr);

        arrOfArr = arrOfArrMain.triangularMatrix(9);
        arrOfArrMain.printArrayOfArrays(arrOfArr);

        //arrOfArr = arrOfArrMain.getValues();
    }
}
