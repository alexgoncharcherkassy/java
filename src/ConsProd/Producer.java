package ConsProd;

public class Producer implements Runnable {
    private Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        try {
            while (i < 5) {
                q.put(i++);
                System.out.println("Putted " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
