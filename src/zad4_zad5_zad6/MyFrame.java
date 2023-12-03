package zad4_zad5_zad6;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {
    MyFrame(){
        //MAIN
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        JPanel mainScreen = new JPanel();
        this.setContentPane(mainScreen);
        this.setResizable(false);
        this.setTitle("BLACK BOX");

        //mainScreen
        mainScreen.setLayout(new BorderLayout());
        DrawingArea drawingArea = new DrawingArea();
        mainScreen.add(drawingArea, BorderLayout.CENTER);
        mainScreen.setBackground(new Color(0x282828));
    }
}
