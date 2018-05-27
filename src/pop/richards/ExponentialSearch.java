package pop.richards;

/**
 * Created by porichar on 26-5.
 */
public class ExponentialSearch implements SearchInterface {
    @Override
    public int searchTest(int[] list, int find) {
        int idxExpo = 1;
        int loopCnt = 1;
        for(;idxExpo < list.length; idxExpo = idxExpo * 2) {
            if (list[Math.min(idxExpo, list.length)] > find) {
                break;
            } else if (list[Math.min(idxExpo, list.length)] == find) {
                return loopCnt;
            }
        }
        BinarySearch bs = new BinarySearch();
        loopCnt = bs.binarySearch(list, ((idxExpo / 2)), (Math.min(idxExpo, list.length)), find);
        return loopCnt;
    }
}
