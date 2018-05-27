package pop.richards;

import java.util.Arrays;

/**
 * Created by porichar on 20-5.
 */
public class LinearSearch implements SearchInterface {
    @Override
    public int searchTest(int[] list, int find) {
//        System.out.println(Arrays.toString(list));
//        System.out.println(find);

        for(int i = 0; i < list.length; i++) {
            if (list[i] == find) {
                return (i + 1);
            }
        }
        return -1;
    }
}
