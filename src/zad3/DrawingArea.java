package zad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawingArea extends JPanel {
    private Rectangle draggableRectange = new Rectangle(50,50,200,350);
    private Point mousePt;
    DrawingArea(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if(draggableRectange.contains(e.getPoint())){
                    mousePt = e.getPoint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e){
                if (mousePt != null) {
                    int deltaX = e.getX() - mousePt.x;
                    int deltaY = e.getY() - mousePt.y;
                    draggableRectange.setLocation(draggableRectange.x + deltaX, draggableRectange.y + deltaY);
                    mousePt = null;
                    repaint();
                }
            }
        });
    }

    protected void paintComponent(Graphics graphicsElement){
        super.paintComponent(graphicsElement);
        Graphics2D graphics2D = (Graphics2D) graphicsElement;
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(Color.black);
        graphics2D.fillRect(draggableRectange.x,draggableRectange.y,draggableRectange.width,draggableRectange.height);
    }

}
