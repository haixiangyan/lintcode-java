class FlipTool {
    public static void flip(int[] arr, int i) {

    }
}

public class LC894 {
    public void pancakeSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        int size = array.length;

        for (int i = 0; i < array.length; i++) {
            // Find index of maximum value for given size
            int maxIndex = findMax(array, size);
            // Do flipping to flip the maximum element to the end
            FlipTool.flip(array, maxIndex + 1);
            FlipTool.flip(array, array.length);
            // Change the size
            size --;
        }
    }

    private int findMax(int[] array, int size) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
