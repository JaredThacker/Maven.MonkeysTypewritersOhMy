package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);

        int NUM_UNSAFE_MONKEYS = 5;
        ArrayList<Thread> unsafeMonkeyThreads = new ArrayList<>();
        for (int i = 0; i < NUM_UNSAFE_MONKEYS; i++) {
            Thread monkeyThread = new Thread(unsafeCopier);
            unsafeMonkeyThreads.add(monkeyThread);
            monkeyThread.start();
        }

        for (int i = 0; i < NUM_UNSAFE_MONKEYS; i++) {
            try {
                unsafeMonkeyThreads.get(i).join();
            } catch (Exception e) {

            }
        }

        System.out.println(unsafeCopier.copied);

        // INTERMISSION

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }


        System.out.println("\n\n\nSAFE PRINTING\n\n\n");

        ReentrantLock threadLock = new ReentrantLock();
        SafeCopier safeCopier = new SafeCopier(introduction, threadLock);

        int NUM_MONKEYS = 5;
        ArrayList<Thread> monkeyThreads = new ArrayList<>();
        for (int i = 0; i < NUM_MONKEYS; i++) {
            Thread monkeyThread = new Thread(safeCopier);
            monkeyThreads.add(monkeyThread);
            monkeyThread.start();
        }

        for (int i = 0; i < NUM_MONKEYS; i++) {
            try {
                monkeyThreads.get(i).join();
            } catch (InterruptedException exception) {
                System.out.printf("Thread %d exception", i);
            }
        }

        System.out.println(safeCopier.copied);

    }
}