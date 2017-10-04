package CalculateTest;

public class FactoryCalc implements Runnable {
    private String name;
    private Thread t;

    FactoryCalc(String name) {
        this.name = name;
        this.t = new Thread(this, name);
        this.t.start();
    }

    FactoryCalc(String name, int priority) {
        this.name = name;
        this.t = new Thread(this, name);
        this.t.setPriority(priority);
        this.t.start();
    }

    @Override
    public void run() {
        Calc calc = new Calc(this.t);
        System.out.println(calc.sum(10, 50));
        System.out.println(calc.sub(10, 50));
        System.out.println("Thread name " + this.name);
        System.out.println("Thread priority " + this.t.getPriority());
    }
}
