package pop.richards;

/**
 * Created by porichar on 27-5.
 */
public class FibonacciSearch implements SearchInterface {
    @Override
    public int searchTest(int[] list, int find) {
        int arrLenght = list.length;
        int fibm2 = 0;
        int fibm1 = 1;
        int fibm = fibm2 + fibm1;

        while (fibm < arrLenght) {
            fibm2 = fibm1;
            fibm1 = fibm;
            fibm = fibm2 + fibm1;
        }

        int offset = -1;

        int loopCnt = 1;
        while (fibm > 1) {
            int i = Math.min((offset + fibm2), (arrLenght -1));

            if (list[i] < find) {
                fibm = fibm1;
                fibm1 = fibm2;
                fibm2 = fibm - fibm1;
                offset = i;
            } else if (list[i] > find) {
                fibm = fibm2;
                fibm1 = fibm1 - fibm2;
                fibm2 = fibm - fibm1;
            } else {
                return loopCnt;
            }
            loopCnt++;
        }
        if (fibm == 1 && list[offset + 1] == find) {
            return loopCnt;
        }
        System.out.println("value not found " + Integer.toString(find));
        return -1;
    }
}
