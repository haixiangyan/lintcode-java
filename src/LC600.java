public class LC600 {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0) {
            return 0;
        }
        if (image[0] == null || image[0].length == 0) {
            return 0;
        }

        int row = image.length;
        int col = image[0].length;

        int left = findLeft(image, 0, y);
        int right = findRight(image, y, col - 1);
        int up = findUp(image, 0, x);
        int down = findDown(image, x, row - 1);

        return (right - left + 1) * (down - up + 1);
    }

    private int findLeft(char[][] image, int start, int end) {
        int left = start, right = end;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isColEmpty(image, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (!isColEmpty(image, left)) {
            return left;
        }
        if (!isColEmpty(image, right)) {
            return right;
        }
        return -1;
    }

    private int findRight(char[][] image, int start, int end) {
        int left = start, right = end;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isColEmpty(image, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (!isColEmpty(image, right)) {
            return right;
        }
        if (!isColEmpty(image, left)) {
            return left;
        }

        return -1;
    }

    private int findUp(char[][] image, int start, int end) {
        int up = start, down = end;
        while (up + 1 < down) {
            int mid = up + (down - up) / 2;
            if (isRowEmpty(image, mid)) {
                up = mid;
            } else {
                down = mid;
            }
        }

        if (!isRowEmpty(image, up)) {
            return up;
        }
        if (!isRowEmpty(image, down)) {
            return down;
        }

        return -1;
    }

    private int findDown(char[][] image, int start, int end) {
        int up = start, down = end;
        while (up + 1 < down) {
            int mid = up + (down - up) / 2;
            if (isRowEmpty(image, mid)) {
                down = mid;
            }
            else {
                up = mid;
            }
        }

        if (!isRowEmpty(image, down)) {
            return down;
        }
        if (!isRowEmpty(image, up)) {
            return up;
        }

        return -1;
    }

    private boolean isColEmpty(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }

        return true;
    }

    private boolean isRowEmpty(char[][] image, int row) {
        for (int i = 0; i < image[row].length; i++) {
            if (image[row][i] == '1') {
                return false;
            }
        }

        return true;
    }
}
