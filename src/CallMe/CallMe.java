package CallMe;

import static java.lang.System.*;

class CallMe {
    void call(String msg) {
        out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            out.println("Stoped");
        }
        out.println("]");
    }
}
