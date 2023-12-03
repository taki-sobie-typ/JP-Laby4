package zad4_zad5_zad6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingArea extends JPanel{
    private Rectangle draggableRectange = new Rectangle(50,50,200,350);
    private Color colorOfRec1 = Color.BLACK;
    private Rectangle draggableRectange2 = new Rectangle(150,250,200,30);
    private Color colorOfRec2 = Color.BLUE;
    private Rectangle draggableRectange3 = new Rectangle(550,500,100,100);
    private Color colorOfRec3 = Color.ORANGE;
    private int setFocusOn = 0;

    DrawingArea(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                System.out.println("MYSZ Złapana!");

                if(draggableRectange.contains(e.getPoint())){
                    setFocusOn = 1;
                    colorSetter(true,setFocusOn);
                }
                else if(draggableRectange2.contains(e.getPoint())){
                    setFocusOn = 2;
                    colorSetter(true,setFocusOn);
                }
                else if(draggableRectange3.contains(e.getPoint())){
                    setFocusOn = 3;
                    colorSetter(true,setFocusOn);
                }
                else {
                    setFocusOn = 0;
                    colorSetter(false,0);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e){
                System.out.println("MYSZ Puszczona!");
                colorSetter(false,0);
            }

            @Override
            public void mouseEntered(MouseEvent e){
                System.out.println("MYSZ POJAWIŁA SIĘ W OKNIE!");
            }

            @Override
            public void mouseExited(MouseEvent e){
                System.out.println("MYSZ UCIEKŁA Z OKNA!");
            }
        });

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_LEFT){
                    moveResObj(setFocusOn, -20, 0, 0);
                }
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_RIGHT){
                    moveResObj(setFocusOn, 20, 0, 0);
                }
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_UP){
                    moveResObj(setFocusOn, 0, -20, 0);
                }
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_DOWN){
                    moveResObj(setFocusOn, 0, 20, 0);
                }
                return false;
            }
        });

        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    moveResObj(setFocusOn, 0, 0, 10);
                } else {
                    moveResObj(setFocusOn, 0, 0, -10);
                }
            }
        });
    }

    private void moveResObj(int focusIsOn, int xAccess, int yAccess, int resValue) {
        switch (focusIsOn){
            case 1:
                draggableRectange.setLocation(draggableRectange.x+xAccess,draggableRectange.y+yAccess);
                draggableRectange.width+=resValue;
                draggableRectange.height+=resValue;
                break;
            case 2:
                draggableRectange2.setLocation(draggableRectange2.x+xAccess,draggableRectange2.y+yAccess);
                draggableRectange2.width+=resValue;
                draggableRectange2.height+=resValue;
                break;
            case 3:
                draggableRectange3.setLocation(draggableRectange3.x+xAccess,draggableRectange3.y+yAccess);
                draggableRectange3.width+=resValue;
                draggableRectange3.height+=resValue;
                break;
            default:
                break;
        }
        repaint();
    }

    private void colorSetter(boolean ifActive, int focusIsOn){
        if(ifActive) {
            switch (focusIsOn) {
                case 1:
                    colorOfRec1 = Color.RED;
                    break;
                case 2:
                    colorOfRec2 = Color.RED;
                    break;
                case 3:
                    colorOfRec3 = Color.RED;
                    break;
                default:
                    break;
            }
        } else {
            colorOfRec1 = Color.BLACK;
            colorOfRec2 = Color.BLUE;
            colorOfRec3 = Color.ORANGE;
            }
        repaint();
    }

    protected void paintComponent(Graphics graphicsElement){
        super.paintComponent(graphicsElement);
        Graphics2D graphics2D = (Graphics2D) graphicsElement;
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(colorOfRec1);
        graphics2D.fillRect(draggableRectange.x,draggableRectange.y,draggableRectange.width,draggableRectange.height);
        graphics2D.setColor(colorOfRec2);
        graphics2D.fillRect(draggableRectange2.x,draggableRectange2.y,draggableRectange2.width,draggableRectange2.height);
        graphics2D.setColor(colorOfRec3);
        graphics2D.fillRect(draggableRectange3.x,draggableRectange3.y,draggableRectange3.width,draggableRectange3.height);
    }
}
