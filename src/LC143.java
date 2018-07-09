public class LC143 {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int start, int end, int colorFrom, int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }

        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int pivot = (colorFrom + colorTo) / 2;

        while (left <= right) {
            while (left <= right && colors[left] <= pivot) {
                left++;
            }
            while (left <= right && colors[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left++;
                right--;
            }
        }

        rainbowSort(colors, start, right, colorFrom, pivot);
        rainbowSort(colors, left, end, pivot + 1, colorTo);
    }

    public static void main(String[] args) {
        int[] colors = {3, 2, 3, 3, 4, 3, 3, 2, 4, 4, 1, 2, 1, 1, 1, 3, 4, 3, 4, 2};
        int k = 4;

        LC143 lc143 = new LC143();

        lc143.sortColors2(colors, k);

        for (int i : colors) {
            System.out.println(i);
        }
    }
}
