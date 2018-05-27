package pop.richards;

/**
 * Created by porichar on 23-5.
 */
public class InterpolationSearch implements SearchInterface {

    private int interpolationSearch(int[] list, int idxStart, int idxEnd, int find) {
        int pos = idxStart + (((find - list[idxStart]) * ((idxEnd - 1) - idxStart)) / (list[idxEnd - 1] - list[idxStart]));
        int loopCnt = 1;
        if (list[pos] == find) {
            return loopCnt;
        } else if (list[pos] > find) {
            loopCnt += interpolationSearch(list, idxStart, (pos -1), find);
        } else {
            loopCnt += interpolationSearch(list, (pos + 1), idxEnd, find);
        }
        return loopCnt;
    }

    @Override
    public int searchTest(int[] list, int find) {
        return interpolationSearch(list, 0, list.length, find);
    }
}
