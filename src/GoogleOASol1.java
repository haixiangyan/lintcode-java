import java.util.Arrays;

public class GoogleOASol1 {
    public int[] solution(int[] stores, int[] houses) {
        if (stores == null || stores.length == 0 || houses == null || houses.length == 0) {
            return new int[0];
        }

        int[] closestLocations = new int[houses.length];

        // Sort stores locations
        Arrays.sort(stores);

        for (int i = 0; i < houses.length; i++) {
            closestLocations[i] = findClosestLocation(stores, houses[i]);
        }

        return closestLocations;
    }

    private int findClosestLocation(int[] stores, int house) {
        int start = 0, end = stores.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (stores[mid] <= house) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        return (Math.abs(house - stores[start]) < Math.abs(house - stores[end])) ? stores[start] : stores[end];
    }
}
