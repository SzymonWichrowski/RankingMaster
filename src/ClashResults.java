import javax.swing.*;
import java.awt.*;

public class ClashResults extends JFrame {

    JLabel titleLab;
    JTextArea resultsArea;

    public ClashResults() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int menuWidth = 400, menuHeight = 380;
        setBounds((screen.width - menuWidth)/2, (screen.height - menuHeight)/2, menuWidth, menuHeight);
        setTitle("Clash Ranking Results");
        setLayout(null);
        getContentPane().setBackground(new Color(76, 146, 169));

        titleLab = new JLabel("RESULTS");
        titleLab.setBounds(150, 40, 150, 30);
        titleLab.setFont(new Font("Dialog", Font.ITALIC, 18));
        add(titleLab);

        resultsArea = new JTextArea();
        JScrollPane resultsScroll = new JScrollPane(resultsArea);
        resultsScroll.setBounds(75, 100, 200, 150);
        add(resultsScroll);
    }

    public void results() {
        for(int i = 0; i < ClashRanking.elements.size(); i++) {
            resultsArea.append( (i+1) + ") " + ClashRanking.elements.get(i) + "\n");
        }
    }
}
