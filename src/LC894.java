public class LC894 {
    static class FlipTool {
        public static void flip(int[] arr, int i) {

        }
    }
    public void pancakeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int bound = array.length;
        while (bound > 0) {
            for (int j = 0; j < bound; j++) {
                if (array[0] < array[j]) {
                    FlipTool.flip(array, j);
                }
            }

            FlipTool.flip(array, bound - 1);
            bound--;
        }
    }
}
