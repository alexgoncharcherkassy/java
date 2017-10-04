package ConsProd;

import static java.lang.System.*;

class Q {
    private int n;
    private boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                out.println(e.getMessage());
            }
        }

        valueSet = false;
        notify();

        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                out.println(e.getMessage());
            }
        }

        this.n = n;
        valueSet = true;
        notify();
    }
}
