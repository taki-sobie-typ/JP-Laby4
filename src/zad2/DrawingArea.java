package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingArea extends JPanel {
    DrawingArea(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Get the X and Y access of a mouse
                //And put it into text-fields
            }
        });
    }
    protected void paintComponent(Graphics graphicsElement){
        super.paintComponent(graphicsElement);
        graphicsElement.setColor(new Color(0xfefefe));
        graphicsElement.fillRect(0, 0,this.getWidth(),this.getHeight());
    }

}
