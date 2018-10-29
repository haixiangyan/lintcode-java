public class LC894 {
    static class FlipTool {
        public static void flip(int[] arr, int i) {

        }
    }
    public void pancakeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int bound = array.length - 1;
        while (bound > 0) {
            for (int i = 0; i <= bound; i++) {
                if (array[0] < array[i]) {
                    FlipTool.flip(array, i);
                }
            }

            FlipTool.flip(array, bound);
            bound--;
        }
    }
}
