package zad2;

import zad1.DrawingArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {
    private final zad2.DrawingArea drawingArea = new zad2.DrawingArea();
    private final JPanel mainScreen = new JPanel();
    private final JPanel topBar = new JPanel();
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

        //makes text-fields not editable

    }
}
