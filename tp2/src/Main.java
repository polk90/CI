import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/file.txt");
        try {
            Scanner scanner = new Scanner(file);
            String data = scanner.nextLine();
            String[] newData = data.split(" ");
            Stream<String> dataStream = Arrays.stream(newData);
            Stream<Integer> integerStream = dataStream.map(Integer::parseInt);
            List<Integer> dataList = integerStream.toList();
            System.out.println(_min(dataList));
            System.out.println(_max(dataList));
            System.out.println(_sum(dataList));
            System.out.println(_mult(dataList));
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int _min(List<Integer> data) {
        int min = Integer.MAX_VALUE;
        for (int num : data) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    public static int _max(List<Integer> data) {
        int max = Integer.MIN_VALUE;

        for (int num : data) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static int _sum(List<Integer> data) {
        int sum = 0;

        for (int num : data) {
            sum += num;
        }

        return sum;
    }

    public static int _mult(List<Integer> data) {
        int mult = 1;

        for (int num : data) {
            mult *= num;
        }

        return mult;
    }
    public static double _average(List<Integer> data) {
        double sum = 0;
        for (int num : data) {
            sum += num;
        }
        return sum / data.size();
    }
}
