package zad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

public class DrawingArea extends JPanel {
    private Rectangle draggableRectange = new Rectangle(50,50,200,350);
    private Rectangle draggableRectange2 = new Rectangle(150,250,200,30);
    private Rectangle draggableRectange3 = new Rectangle(550,500,100,100);
    private Point mousePt;
    private long startTime;
    private long stopTime;
    private long delay;

    private int witch = 0;
    DrawingArea(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if(draggableRectange.contains(e.getPoint())){
                    witch = 1;
                    mousePt = e.getPoint();
                    startTime = System.currentTimeMillis();
                }
                if(draggableRectange2.contains(e.getPoint())){
                    witch = 2;
                    mousePt = e.getPoint();
                    startTime = System.currentTimeMillis();
                }
                if(draggableRectange3.contains(e.getPoint())){
                    witch = 3;
                    mousePt = e.getPoint();
                    startTime = System.currentTimeMillis();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e){
                if (mousePt != null) {
                    stopTime = System.currentTimeMillis();
                    delay = stopTime-startTime;
                    Point targetPoint = e.getPoint();

                    try {
                        if(witch==1) moveObj(draggableRectange, delay, targetPoint);
                        if(witch==2) moveObj(draggableRectange2, delay, targetPoint);
                        if(witch==3) moveObj(draggableRectange3, delay, targetPoint);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        });

    }

    private void moveObj(Rectangle name, long delay, Point targetPoint) throws InterruptedException {
        Thread.sleep(delay);
        name.setLocation(targetPoint);
        repaint();
    }

    protected void paintComponent(Graphics graphicsElement){
        super.paintComponent(graphicsElement);
        Graphics2D graphics2D = (Graphics2D) graphicsElement;
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(Color.black);
        graphics2D.fillRect(draggableRectange.x,draggableRectange.y,draggableRectange.width,draggableRectange.height);
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(draggableRectange2.x,draggableRectange2.y,draggableRectange2.width,draggableRectange2.height);
        graphics2D.setColor(Color.ORANGE);
        graphics2D.fillRect(draggableRectange3.x,draggableRectange3.y,draggableRectange3.width,draggableRectange3.height);
        graphics2D.setColor(Color.black);
        graphics2D.drawString(String.valueOf(delay),20,30);
    }

}
