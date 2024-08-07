package io.zipcoder;

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

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        UnsafeCopier unsafeCopier1 = new UnsafeCopier(introduction);
        unsafeCopier1.run();
        UnsafeCopier unsafeCopier2 = new UnsafeCopier(introduction);
        unsafeCopier2.run();
        UnsafeCopier unsafeCopier3 = new UnsafeCopier(introduction);
        unsafeCopier3.run();
        UnsafeCopier unsafeCopier4 = new UnsafeCopier(introduction);
        unsafeCopier4.run();
        UnsafeCopier unsafeCopier5 = new UnsafeCopier(introduction);
        unsafeCopier5.run();

        SafeCopier safeCopier1 = new SafeCopier(introduction);
        safeCopier1.run();
        SafeCopier safeCopier2 = new SafeCopier(introduction);
        safeCopier2.run();
        SafeCopier safeCopier3 = new SafeCopier(introduction);
        safeCopier3.run();
        SafeCopier safeCopier4 = new SafeCopier(introduction);
        safeCopier4.run();
        SafeCopier safeCopier5 = new SafeCopier(introduction);
        safeCopier5.run();

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.

        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println(unsafeCopier1.copied);
        System.out.println(unsafeCopier2.copied);
        System.out.println(unsafeCopier3.copied);
        System.out.println(unsafeCopier4.copied);
        System.out.println(unsafeCopier5.copied);

        System.out.println(safeCopier1.copied);
        System.out.println(safeCopier2.copied);
        System.out.println(safeCopier3.copied);
        System.out.println(safeCopier4.copied);
        System.out.println(safeCopier5.copied);
    }
}