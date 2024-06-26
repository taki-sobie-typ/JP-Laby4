package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        mainScreen.setLayout(null);
        mainScreen.setBounds(0,0,this.getWidth(),this.getHeight());
        DrawingArea drawingArea = new DrawingArea();
        drawingArea.setBounds(getWidth()/2-200,getHeight()/2-200,400,400);
        drawingArea.setBackground(Color.WHITE);
        drawingArea.setFocusable(true);
        mainScreen.add(drawingArea);
        mainScreen.setBackground(new Color(0x282828));

    }
}
