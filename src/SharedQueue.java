import java.util.ArrayDeque;
import java.util.Queue;

public class SharedQueue {
    private static Queue<Integer> queue;

    public SharedQueue()
    {
        queue = new ArrayDeque<>();
    }

    synchronized public void enqueue(int num)
    {
        while(queue.size() > 20)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.offer(num);
        notifyAll();
    }

    synchronized public int dequeue()
    {
        while(queue.size() <= 5)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return queue.poll();
    }

    synchronized public int getSize()
    {
        return queue.size();
    }
}
