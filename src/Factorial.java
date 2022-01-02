public class Factorial {
    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();
        NumberConsumer consumer = new NumberConsumer(queue);
        NumberProducer producer = new NumberProducer(queue, consumer);

        producer.start();
        consumer.start();

    }
}
