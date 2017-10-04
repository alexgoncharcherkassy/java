package CalculateTest;

public class Calc {
    Thread t;

    Calc(Thread thread) {
        this.t = thread;
    }

    public int sum(int x, int y) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return x + y;
    }

    public int sub(int x, int y) {
        return x * y;
    }
}
