package Applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class AppletListeners extends Applet implements MouseMotionListener, MouseListener, ActionListener {
    private String msg = "";
    private int mouseX = 0, mouseY = 0;
    private Button yes, clear;
    private TextField name, pass;

    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
        Label namep = new Label("Name: ", Label.RIGHT);
        Label passp = new Label("Password: ", Label.RIGHT);
        yes = new Button("Save");
        clear = new Button("Clear");
        name = new TextField(12);
        pass = new TextField(8);
        pass.setEchoChar('*');
        add(namep);
        add(name);
        add(passp);
        add(pass);
        name.addActionListener(this);
        pass.addActionListener(this);
        add(yes);
        yes.addActionListener(this);
        add(clear);
        clear.addActionListener(this);
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse clicked";
        repaint();
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse entered";
        repaint();
    }

    public void mouseExited(MouseEvent mouseEvent) {
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse exited";
        repaint();
    }

    public void mousePressed(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();
        msg = "Down";
        repaint();
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();
        msg = "Up";
        repaint();
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();
        msg = "*";
        showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
        repaint();
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();
        showStatus("Moving mouse at " + mouseX + ", " + mouseY);
        repaint();
    }

    public void paint(Graphics graphics) {
        graphics.drawString(msg, mouseX, mouseY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if (btn.equals("Save")) {
            showStatus("You pressed Save button");
            msg = "Your name = " + name.getText() + " Pass = " + pass.getText();
        } else {
            name.setText("");
            pass.setText("");
        }

        repaint();
    }
}
