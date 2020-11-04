package array;

public class ArrayHandler {

    public boolean contains(int[] source, int itemToFind) {
        for (int item : source) {
            if (item == itemToFind) {
                return true;
            }
        }
        return false;
    }

    public int find(int[] source, int itemToFind) {
        for(int i = 0;i< source.length;i++) {
            if (source[i] == itemToFind) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayHandler handler = new ArrayHandler();
        int[] arr = {1, 2, 4, 5, 7};
        System.out.println(handler.contains(arr,7));
        System.out.println(handler.contains(arr,9));

        System.out.println(handler.find(arr,4));
        System.out.println(handler.find(arr,6));
    }
}
