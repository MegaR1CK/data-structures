package datastructures.stacksandqueues.processors;

import datastructures.stacksandqueues.exceptions.FullQueueException;
import datastructures.stacksandqueues.structures.Queue;

import java.util.Random;

public class QueueEmulator {

    Random random = new Random();
    Queue[] queues = new Queue[3];
    private int ticks = 0;

    public QueueEmulator() {
        for (int i = 0; i < 3; i++) {
            queues[i] = new Queue(10);
            for (int j = 0; j < 10; j++) {
                try {
                    queues[i].insert(random.nextInt(10));
                } catch (FullQueueException exception) {
                    break;
                }
            }
        }
    }

    public void tick() {
        if (++ticks % 5 == 0) {
            Queue shortestQueue = queues[0];
            for (int i = 1; i < 3; i++) {
                if (queues[i].getSize() < shortestQueue.getSize()) {
                    shortestQueue = queues[i];
                }
            }
            try {
                shortestQueue.insert(random.nextInt(10));
            } catch (FullQueueException ignored) {
            }
        }
    }
}
