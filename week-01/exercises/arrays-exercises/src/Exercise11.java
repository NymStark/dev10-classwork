import java.util.Random;

public class Exercise11 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();



        // (We must count first to know the capacity to allocate.)
        // 3. Loop through `values` a second time. Add positive elements to the new array.
        // 4. Confirm the positive array is properly populated either by debugging or printing its elements.

        // 1. Count the number of positive elements in `values`.
        int posCount =0;
        for (int val: values) {
            if (val > 0) posCount++;
        }

        // 2. Create a new int[] to hold the positive elements.
        int[] positiveArray = new int[posCount];
        // 3. Loop through `values` a second time. Add positive elements to the new array.
        int resultIndex = 0;
        for (int val: values) {
            if (val > 0){
                positiveArray[resultIndex] = val;
                resultIndex++;
            }
        }

        System.out.println("Positive Array:");
        for (int num : positiveArray) {
            System.out.print(num + " ");
        }
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
