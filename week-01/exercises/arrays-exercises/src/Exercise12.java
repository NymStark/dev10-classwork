import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();

        // 1. Count the number of positive and non-positive elements in `values`.
        // 2. Create two new int[]s, one for positive elements and one for non-positive.
        // (We count first to determine the capacity to allocate.)
        // 3. Loop through `values` a second time. If an element is positive, add it to the positive array.
        // If it is non-positive, add it to the non-positive array.
        // 4. Confirm that your secondary arrays are properly populated either by debugging or printing their elements.

        int countPositive = 0;
        for (int val: values){
            if (val > 0) {
                countPositive++;
            }
        }


//        Could also easily do for (int i = 0; i <values.length; i++) {
//                if (values[i] > 0) countPositive++;
//            }


        int countNonPositive = values.length - countPositive;

        int[] positiveArray     = new int[countPositive];
        int[] nonPositiveArray  = new int[countNonPositive];


    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }
}
