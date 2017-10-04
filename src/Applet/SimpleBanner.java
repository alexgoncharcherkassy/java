package Applet;

import java.applet.Applet;
import java.awt.*;

public class SimpleBanner extends Applet implements Runnable {
    private String msg = "A Simple Moving Banner";
    private Thread t = null;
    private volatile boolean stopFlag;

    public void init() {
        setBackground(Color.cyan);
        setForeground(Color.red);
    }

    public void start() {
        t = new Thread(this);
        stopFlag = false;
        t.start();
    }

    public void run() {
        for ( ; ; ) {
            try {
                repaint();
                Thread.sleep(250);
                if (stopFlag) {
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void stop() {
        stopFlag = true;
        t = null;
    }

    public void paint(Graphics g) {
        char ch;

        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;

        g.drawString(msg, 50, 30);
        showStatus("Status window");
    }
}
