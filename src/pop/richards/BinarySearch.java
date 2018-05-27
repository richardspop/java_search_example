package pop.richards;

/**
 * Created by porichar on 23-5.
 */
public class BinarySearch implements SearchInterface {

    public int binarySearch(int[] list, int idxStart, int idxEnd, int find) {
        int cnt = 1;
        //int mid = (idxStart + idxEnd) / 2;
        int mid = idxStart + (idxEnd - idxStart) / 2;
        //System.out.printf("start: %d, end: %d, mid: %d \n", idxStart, idxEnd, mid);
        if (list[mid] == find) {
            cnt = 1;
        } else if (list[mid] > find) {
            cnt += binarySearch(list, idxStart, (mid -1), find);
        } else {
            cnt += binarySearch(list, (mid + 1), idxEnd, find);
        }
        return cnt;
    }
    @Override
    public int searchTest(int[] list, int find) {
        int loops = binarySearch(list, 0, (list.length - 1), find);
        //System.out.println(loops);
        return loops;
    }
}
