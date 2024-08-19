package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    ReentrantLock reentrantLock;

    public SafeCopier(String toCopy, ReentrantLock lock) {
        super(toCopy);
        this.reentrantLock = lock;
    }


    @Override
    public void run() {
        if (!this.reentrantLock.isLocked()) {
            this.reentrantLock.lock();
            try {
                while (stringIterator.hasNext()) {
                    String nextWord = stringIterator.next();
                    copied += nextWord + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
