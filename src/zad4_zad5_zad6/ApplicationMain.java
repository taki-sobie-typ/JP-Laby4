package zad4_zad5_zad6;
import javax.swing.*;

public class ApplicationMain {
    public static void main(String[] main){
        SwingUtilities.invokeLater(() -> {
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
        });
    }

}
