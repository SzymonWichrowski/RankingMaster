import javax.swing.*;

public class Main {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            MenuWindow menuWindow = new MenuWindow();
            menuWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            menuWindow.setVisible(true);
        });
    }
}
