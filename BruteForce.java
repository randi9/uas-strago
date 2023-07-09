import java.util.ArrayList;
import java.util.List;

public class BruteForce {
    public static void getMinimumStops(int[] distances, int[] stops, int currentDist, int currentStops, int[] minStops, List<Integer> result) {
        if (currentDist == 140) {
            if (currentStops < minStops[0]) {
                minStops[0] = currentStops;
                result.clear();
                for (int i = 0; i < stops.length; i++) {
                    if (stops[i] == 1) {
                        result.add(distances[i]);
                    }
                }
            }
            return;
        }

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] > currentDist) {
                break;
            }

            if (stops[i] == 1) {
                continue;
            }

            stops[i] = 1;
            getMinimumStops(distances, stops, currentDist + distances[i], currentStops + 1, minStops, result);
            stops[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] distances = {10, 25, 30, 40, 50, 75, 80, 110, 130};
        int[] stops = new int[distances.length];
        int[] minStops = {Integer.MAX_VALUE};
        List<Integer> result = new ArrayList<>();

        getMinimumStops(distances, stops, 0, 0, minStops, result);

        System.out.print("Tono akan berhenti pada kilometer: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println("140");
    }
}
