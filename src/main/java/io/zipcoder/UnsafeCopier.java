package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    @Override
    public void run() {
        while (stringIterator.hasNext()){
            String nextWord = stringIterator.next();
            super.copied += nextWord + " ";
//            System.out.printf("Index = %s\n", nextWord);
        }
    }
}
