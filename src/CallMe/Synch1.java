package CallMe;

public class Synch1 {
    public static void main(String args[]) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "mes 1");
        Caller ob2 = new Caller(target, "mes 2");
        Caller ob3 = new Caller(target, "mes 3");

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Stoped");
        }
    }
}
