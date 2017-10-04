package JoinFork;

import java.util.concurrent.ForkJoinPool;

public class FJExperiment {
    public static void main(String args[]) {
        int pLevel = 2;
        int threshold = 1000;
        long beginT, endT;

        ForkJoinPool fjp = new ForkJoinPool(pLevel);

        double[] nums = new double[1000000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        Transform task = new Transform(nums, 0, nums.length, threshold);
        beginT = System.nanoTime();
        fjp.invoke(task);
        endT = System.nanoTime();

        System.out.println("Paralel level: " + pLevel);
        System.out.println("Posledov obrab: " + threshold);
        System.out.println("Job time: " + (endT - beginT) + " ns");
    }
}
