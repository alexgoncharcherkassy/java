package Promote;

import static java.lang.System.*;

public class Promote {
    public static void main(String args[]) {
        byte b = 42;
        char c = 'z';
        short s = 1024;
        int i = 50000;
        float f = 5.67f;
        double d = .1234;
        double result = (f * b) + (i / c) - (d * s);
        out.println((f * b) + " + " + (i / c) + " - " + (d * s));
        out.println("result = " + result);
    }
}
