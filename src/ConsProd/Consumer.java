package ConsProd;

public class Consumer implements Runnable {
    private Q q;
    private int count;
    private int sum;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        try {
            while (this.count < 5) {
                this.count = q.get();
                this.sum += this.count;
                System.out.println("Got " + this.count);
                System.out.println("Total " + this.sum);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
