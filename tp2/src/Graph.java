import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {

    public static void main(String[] args) {
        int[] datasetSizes = {100, 500, 1000, 10000, 100000, 1000000};
        double[] timeDurations = new double[datasetSizes.length];

        for (int i = 0; i < datasetSizes.length; i++) {
            List<Integer> randomDataList = createRandomList(datasetSizes[i]);

            long start = System.nanoTime();
            Main._mult(randomDataList);
            long finish = System.nanoTime();
            timeDurations[i] = (finish - start) / 1000000.0;
        }
        displayGraph(datasetSizes, timeDurations);
    }

    private static List<Integer> createRandomList(int size) {
        Random randomGen = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomList.add(randomGen.nextInt(1000));
        }
        return randomList;
    }

    private static void displayGraph(int[] sizes, double[] durations) {
        int maxBars = 50;
        double peakDuration = average(durations);

        for (int i = 0; i < sizes.length; i++) {
            int barLength = (int) ((durations[i] / peakDuration) * maxBars);
            System.out.printf("%-7d | %s\n", sizes[i], "O".repeat(barLength));
        }
    }

    public static double average(double[] array) {
        double sum = 0;
        int c = 0;
        for (double num : array) {
            sum += num;
            c += 1;
        }
        return sum / c;
    }
}