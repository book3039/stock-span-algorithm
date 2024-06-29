import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StockDataGenerator {
    private int count;
    private final int[] stockData;

    public StockDataGenerator(int count) {
        this.count = count;
        stockData = new int[count];
    }

    public int[] generate() {
        createRandomNumbers(count);
        return stockData;
    }

    public void generate(String path) {
        createRandomNumbers(count);
        writeToFile(path);
    }


    private void createRandomNumbers(int count) {
        for (int i = 0; i < count; i++) {
            stockData[i] = (int) (Math.random() * 100) + 1;
        }
    }

    private void writeToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < count; i++) {
                writer.write(String.valueOf(stockData[i]));
                writer.newLine();
            }
            System.out.println("Data generated and saved to " + path);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
