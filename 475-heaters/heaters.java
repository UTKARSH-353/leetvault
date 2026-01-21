import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);

            if (idx < 0) {
                idx = -(idx + 1); 
            }

            int distRight = (idx < heaters.length)
                    ? Math.abs(heaters[idx] - house)
                    : Integer.MAX_VALUE;

            int distLeft = (idx - 1 >= 0)
                    ? Math.abs(house - heaters[idx - 1])
                    : Integer.MAX_VALUE;

            int closest = Math.min(distLeft, distRight);
            radius = Math.max(radius, closest);
        }

        return radius;
    }
}
