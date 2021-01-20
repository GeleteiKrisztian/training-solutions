package week12d03;

public class AgeSorter {

    int[] sortAges(int[] ages) {
        int[] res = new int[ages.length];
        for (int i = 0; i < ages.length; i++) {
            res[i] = ages[i];
        }

        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < res.length - j; i++) {
                if (res[i] > res[i + 1]) {
                    tmp = res[i];
                    res[i] = res[i + 1];
                    res[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        return res;
    }

}
