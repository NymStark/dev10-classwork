import java.util.Random;

public class Exercise16 {
    // makeRandomAscendingArray creates a random array with a capacity between 50 and 150.
    // Its elements are guaranteed to be sorted ascending.
    // 1. Create a new int[] with capacity for all elements from `one` and `two`.
    // 2. "Merge" elements from `one` and `two` into the new array so that its values are sorted.

         /* Pseudocode:
         Create an integer index for `one`, `two`, and the result array, all starting at 0.
         Loop resultIndex from 0 to result.length - 1:
           if one[oneIndex] is less than two[twoIndex], add it to the result and increment oneIndex.
           if two[twoIndex] is less than one[oneIndex], add it to the result and increment twoIndex.
           determine how to settle ties
           if oneIndex >= one.length, there are no `one` elements remaining so use elements from two
           if twoIndex >= two.length, there are no `two` elements remaining so use elements from one
          */
    public static void main(String[] args) {
        // MERGE
        int[] one = makeRandomAscendingArray(); //first random ascending array
        int[] two = makeRandomAscendingArray(); //second random ascending array.

        int lenOne = one.length;
        int lenTwo = two.length;
        int[] result = new int[lenOne+lenTwo];

        int oneIndex = 0;
        int twoIndex = 0;
        int resultIndex = 0;
        while (resultIndex < result.length) {
            if (oneIndex<lenOne && ( twoIndex >= lenTwo || one[oneIndex]<= two[twoIndex])){
                result[resultIndex] = one[oneIndex];
                oneIndex++;
            } else if ( twoIndex<lenTwo) {
                result[resultIndex] = two[twoIndex];
                twoIndex++;
            }
            resultIndex++;
        }
        System.out.println("Array One: ");
        for (int num : one) {
            System.out.print(num + "->");
        }

        System.out.println();
        System.out.println("Array Two: ");
        for (int num : two) {
            System.out.print(num + "->");
        }

        System.out.println();
        System.out.println("Merged Array!: ");
        for (int num : result) {
            System.out.print(num + "->");
        }


    }

    public static int[] makeRandomAscendingArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        int current = random.nextInt(11);
        for (int i = 0; i < result.length; i++) {
            result[i] = current;
            current += random.nextInt(4);
        }
        return result;
    }
}
