package zad2;

import zad1.MyFrame;

import javax.swing.*;

public class ApplicationMain {
    public static void main (String[] args){
        SwingUtilities.invokeLater(() -> {
            zad2.MyFrame frame = new zad2.MyFrame();
            frame.setVisible(true);
        });
    }
}
