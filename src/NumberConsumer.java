import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class NumberConsumer extends Thread {
    SharedQueue queue;
    FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;

    NumberConsumer(SharedQueue q) {

        queue = q;
        initialize();
    }

    private void initialize() {
        try {
            fileWriter = new FileWriter("factorial.txt", true);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public long calculateFactorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else if (num == 2) {
            return 2;
        } else {
            int j = 2;
            for (int i = 3; i <= num; i++) {
                j *= i;
            }
            return j;
        }
    }

    public void writeToFile(int num, long factorialOfNum) {
        try {
            bufferedWriter.write("" + num + "," + factorialOfNum);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while(true)
        {
            int number = queue.dequeue();
            System.out.println("Number Consumed");
            long factorial = calculateFactorial(number);
            writeToFile(number, factorial);
        }
    }
}
