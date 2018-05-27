package pop.richards;

/**
 * Created by porichar on 23-5.
 */
public class JumpSearch implements SearchInterface{
    @Override
    public int searchTest(int[] list, int find) {
        int jumpSize = (int) Math.sqrt((double) list.length);
        int loopCnt = 0;
        int i = 0;
        int j = jumpSize;
        int idxStart = i;
        int idxEnd = j;
        while (j < list.length) {
            loopCnt++;
            if (list[i] == find || list[j] == find) {
//                System.out.printf("jump size: %d, curr start %d, curr end %d \n", jumpSize, i, j);
                return loopCnt;
            }
            if (list[i] < find && list[j] > find) {
                break;
            }
            i += jumpSize;
            j += jumpSize;
            idxStart = i;
            idxEnd = j;
        }
        if (idxEnd >= list.length) {
            idxEnd = list.length;
        }
//        System.out.printf("Identified start: %d and end: %d, loop cnt %d\n", idxStart, idxEnd, loopCnt);
        for (int k = (idxStart + 1 ); k < idxEnd ; k++) {
            loopCnt++;
            if (list[k] == find) {
                return loopCnt;
            }
        }
        return -1;
    }
}
