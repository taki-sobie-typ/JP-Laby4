package zad2;

import javax.swing.*;

public class ApplicationMain {
    public static void main (String[] args){
        SwingUtilities.invokeLater(() -> {
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
        });
    }
}
