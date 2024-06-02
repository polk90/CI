import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private final List<Integer> sampleData = Arrays.asList(-1, 0, 4, 12);
    @Test
    public void verifyMinFunction() {
        assertEquals(-1, Main._min(sampleData));
    }
    @Test
    public void verifyMaxFunction() {
        assertEquals(12, Main._max(sampleData));
    }
    @Test
    public void verifySumFunction() {
        assertEquals(15, Main._sum(sampleData));
    }
    @Test
    public void verifyMultFunction() {
        assertEquals(-48, Main._mult(sampleData));
    }
    @Test
    public void verifySAverageFunction() {
        assertEquals(3.75, Main._average(sampleData));
    }
    private static List<Integer> createLargeRandomList() {
        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            randomList.add(random.nextInt(1000));
        }
        return randomList;
    }
    private final List<Integer> largeRandomList = createLargeRandomList();
    @Test
    public void measureMinPerformance() {
        long start = System.nanoTime();
        Main._min(largeRandomList);
        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000_000.0;
        System.out.println("min function took " + duration + " seconds");
    }
    @Test
    public void measureMaxPerformance() {
        long start = System.nanoTime();
        Main._max(largeRandomList);
        long end = System.nanoTime();
        double duration = (end - start) / 100000000.0;
        System.out.println(duration);
    }
    @Test
    public void measureSumPerformance() {
        long start = System.nanoTime();
        Main._sum(largeRandomList);
        long end = System.nanoTime();
        double duration = (end - start) / 100000000.0;
        System.out.println(duration);
    }
    @Test
    public void measureAveragePerformance() {
        long start = System.nanoTime();
        Main._average(largeRandomList);
        long end = System.nanoTime();
        double duration = (end - start) / 100000000.0;
        System.out.println(duration);
    }
    @Test
    public void measureMultPerformance() {
        long start = System.nanoTime();
        Main._mult(largeRandomList);
        long end = System.nanoTime();
        double duration = (end - start) / 100000000.0;
        System.out.println(duration);
    }
    @Test
    public void testMaxTimeout() {
        assertTimeout(Duration.ofMillis(15), () -> Main._max(largeRandomList));
    }
    @Test
    public void testMinTimeout() {
        assertTimeout(Duration.ofMillis(15), () -> Main._min(largeRandomList));
    }
    @Test
    public void testSumTimeout() {
        assertTimeout(Duration.ofMillis(15), () -> Main._sum(largeRandomList));
    }
    @Test
    public void testMultTimeout() {
        assertTimeout(Duration.ofMillis(15), () -> Main._sum(largeRandomList));
    }
    @Test
    public void validateNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            Main._sum(null);
        });
    }
}