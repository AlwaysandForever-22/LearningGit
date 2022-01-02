import java.util.Random;

class NumberProducer extends Thread{
    public static Random random = new Random();
    public static final int MAX_VALUE = 10;
    public NumberConsumer consumer;
    private SharedQueue queue;

    NumberProducer(SharedQueue q, NumberConsumer cons)
    {
        queue = q;
        consumer = cons;
    }

    @Override
    public void run()
    {
        while(true)
        {
            queue.enqueue(random.nextInt(20));
            System.out.println("Number Produced");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
