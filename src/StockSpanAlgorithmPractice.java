public class StockSpanAlgorithmPractice {

    private static final int DATA_COUNT = 100_000_000;

    private static int[] stockData;
    private static int[] spansWithArray;
    private static int[] spansWithStack;

    public static void main(String[] args) {
//        new StockDataGenerator(1000).generate("/Users/cih/sortPractice/src/stock_data.txt");

        long startTime;
        long endTime;

        stockData = new StockDataGenerator(DATA_COUNT).generate();
        spansWithArray = new int[DATA_COUNT];
        spansWithStack = new int[DATA_COUNT];

        startTime = System.nanoTime();
        getSpanWithArray();
        endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000_000.0;

        startTime = System.nanoTime();
        getSpanWithStack();
        endTime = System.nanoTime();
        double stackTime = (endTime - startTime) / 1_000_000_000.0;

//        for (int i : quotes) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        for (int i : spansWithArray) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        for (int i : spansWithStack) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        System.out.println("getSpanWithArray duration: " + arrayTime + " s");
        System.out.println("getSpanWithStack duration: " + stackTime + " s");
    }

    private static void getSpanWithArray() {
        int k;
        boolean spanEnd;

        for (int i = 0; i < DATA_COUNT; i++) {
            k = 1;
            spanEnd =  false;
            while (i - k >= 0 && !spanEnd) {
                if (stockData[i - k] <= stockData[i]) {
                    k++;
                } else {
                    spanEnd = true;
                }
            }
            spansWithArray[i] = k;
        }
    }


    private static void getSpanWithStack() {

        MyStack stack = new MyStack();

        spansWithStack[0] = 1;
        stack.push(0);

        for (int i = 1; i < DATA_COUNT; i++) {
            while (!stack.isEmpty() && stockData[stack.peek()] <= stockData[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                spansWithStack[i] = i + 1;
            } else {
                spansWithStack[i] = i - stack.peek();
            }

            stack.push(i);
        }
    }
}
