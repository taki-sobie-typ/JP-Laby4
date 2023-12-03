package zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {
    private final DrawingArea drawingArea = new DrawingArea();
    private final JPanel mainScreen = new JPanel();
    private final JPanel topBar = new JPanel();
    private static final JTextField xAcces = new JTextField(2);
    private static final JTextField yAcces = new JTextField(2);
    MyFrame(){
        //MAIN
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainScreen);
        this.setResizable(false);
        this.setTitle("BLACK BOX");

        //mainScreen
        mainScreen.setLayout(new BorderLayout());
        mainScreen.add(topBar, BorderLayout.NORTH);
        mainScreen.add(drawingArea, BorderLayout.CENTER);
        mainScreen.setBackground(new Color(0x282828));

        //topBar
        topBar.setBackground(Color.white);
        topBar.add(xAcces);
        topBar.add(new Label("xAcces,"));
        topBar.add(yAcces);
        topBar.add(new Label("yAcces"));

        //makes text-fields not editable
        xAcces.setEditable(false);
        xAcces.setFocusable(false);
        xAcces.setText("000");

        yAcces.setEditable(false);
        yAcces.setFocusable(false);
        yAcces.setText("000");

        //ENTER LISTENER
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ENTER){
                    //Clears the text fields
                    setAccessFields(000,000);
                }
                return false;
            }
        });
    }

    public static void setAccessFields(int valueX, int valueY){
        xAcces.setText(String.valueOf(valueX));
        yAcces.setText(String.valueOf(valueY));
    }
}
