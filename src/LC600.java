public class LC600 {
    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0) {
            return 0;
        }

        int topIndex = findTop(image, x);
        int bottomIndex = findBottom(image, x);
        int leftIndex = findLeft(image, y);
        int rightIndex = findRight(image, y);

        if (topIndex == -1 || bottomIndex == -1 || leftIndex == -1 || rightIndex == -1) {
            return 0;
        }

        return (bottomIndex - topIndex + 1) * (rightIndex - leftIndex + 1);
    }

    private boolean isEmptyRow(char[][] image, int row) {
        for (int i = 0 ; i < image[row].length ; i++) {
            if (image[row][i] == '1') {
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyCol(char[][] image, int col) {
        for (int i = 0 ; i < image.length ; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }

        return true;
    }

    private int findLeft(char[][] image, int y) {
        int start = 0;
        int end = y;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (isEmptyCol(image, mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (!isEmptyCol(image, start)) {
            return start;
        }
        if (!isEmptyCol(image, end)) {
            return end;
        }

        return -1;
    }

    private int findRight(char[][] image, int y) {
        int start = y;
        int end = image[0].length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (isEmptyCol(image, mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if (!isEmptyCol(image, end)) {
            return end;
        }
        if (!isEmptyCol(image, start)) {
            return start;
        }

        return -1;
    }

    private int findTop(char[][] image, int x) {
        int start = 0;
        int end = x;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (isEmptyRow(image, mid)) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (!isEmptyRow(image, start)) {
            return start;
        }
        if (!isEmptyRow(image, end)) {
            return end;
        }

        return -1;
    }

    private int findBottom(char[][] image, int x) {
        int start = x;
        int end = image.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (isEmptyRow(image, mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if (!isEmptyRow(image, end)) {
            return end;
        }
        if (!isEmptyRow(image, start)) {
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] image = {
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'}
        };

        int x = 0;
        int y = 2;

        LC600 lc600 = new LC600();

        System.out.println(lc600.minArea(image, x, y));
    }
}
