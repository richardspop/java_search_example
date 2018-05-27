package pop.richards;
import java.util.Random;

public class Main {

    private SearchInterface srchAlog;

    public static void main(String[] args) {
        Main currObj = new Main();
        System.out.println("Test for linear search - O(n)");
        currObj.setSearchAlgo(new LinearSearch());
        currObj.srchCaller(10, false);
        System.out.println("Test for Binary search - O(log n)");
        currObj.setSearchAlgo(new BinarySearch());
        currObj.srchCaller(10, false);
        System.out.println("Test for Jump search - O((n)^1/2)");
        currObj.setSearchAlgo(new JumpSearch());
        currObj.srchCaller(10, false);
        System.out.println("Test for Interpolation search - O(log log n)");
        currObj.setSearchAlgo(new InterpolationSearch());
        currObj.srchCaller(10, false);
        System.out.println("Test for Exponential search - O(log n)");
        currObj.setSearchAlgo(new ExponentialSearch());
        currObj.srchCaller(10, false);
        System.out.println("Test for Fibonacci search - O(log n)");
        currObj.setSearchAlgo(new FibonacciSearch());
        currObj.srchCaller(10, false);

    }
    
    public void setSearchAlgo(SearchInterface srchAlog) {
        this.srchAlog = srchAlog;
    }
    
    public void srchCaller(int arrLength, boolean isRand) {
        //Random rand = new Random();
        int[] arrTest = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arrTest[i] = i;
        }
 //       System.out.println(this.srchAlog.searchTest(arrTest, 5));
        float totLoops = 0;
        int maxLoop = 0;
        int minLoop = 0;
        for (int i = 0; i < arrLength; i++) {
            int currLoop = this.srchAlog.searchTest(arrTest, arrTest[i]);
            if (currLoop != -1) {
                totLoops += currLoop;
                if ( minLoop == 0 || minLoop > currLoop) {
                    minLoop = currLoop;
                }
                if (maxLoop < currLoop) {
                    maxLoop = currLoop;
                }
            } else {
                System.out.println("element not found : " + Integer.toString(arrTest[i]));
            }
        }
        System.out.println("Avg number of loops : " + Float.toString(totLoops / arrLength));
        System.out.println("Min loop is : " + Integer.toString(minLoop) + ", Max loop is : " + Integer.toString(maxLoop));
    }
}
