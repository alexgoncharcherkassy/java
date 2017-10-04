package JoinFork;

import java.util.concurrent.RecursiveAction;

public class Transform extends RecursiveAction {
    private int seqThreshold;
    private double[] data;
    private int start, end;

    Transform(double[] vals, int s, int e, int t) {
        data = vals;
        start = s;
        e = e;
        seqThreshold = t;
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0)
                    data[i] = Math.sqrt(data[i]);
                else
                    data[i] = Math.cbrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;

            invokeAll(new Transform(data, start, middle, seqThreshold),
                    new Transform(data, middle, end, seqThreshold));
        }
    }
}
