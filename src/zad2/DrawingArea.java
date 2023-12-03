package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingArea extends JPanel {
    private ArrayList<Point> points = new ArrayList<>();
    private int mouseX, mouseY;
    DrawingArea(){
        setDoubleBuffered(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                mouseX = e.getX();
                mouseY = e.getY();
                requestFocusInWindow();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getX() - mouseX;
                int deltaY = e.getY() - mouseY;

                setLocation(getX()+deltaX, getY()+deltaY);


            }
        });
    }


    protected void paintComponent(Graphics graphicsElement){
        Graphics2D graphics2D = (Graphics2D) graphicsElement;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,getWidth(),getHeight());
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(new BasicStroke(5));
        for (int i=0 ; i < points.size()-1 ; i++){
            Point p1 = points.get(i);
            Point p2 = points.get(i+1);
            graphics2D.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

}
