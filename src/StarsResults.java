import javax.swing.*;
import java.awt.*;

public class StarsResults extends JFrame {

    private JTextArea resultsArea;
    private JLabel titleLab;

    StarsResults() {

        setSize(300, 300);
        setTitle("Results!");
        setLayout(null);
        getContentPane().setBackground(new Color(211, 142, 69));

        titleLab = new JLabel("Results");
        titleLab.setBounds(120, 10, 100, 30);
        titleLab.setFont(new Font("Dialog", Font.ITALIC, 18));
        add(titleLab);

        resultsArea = new JTextArea();
        JScrollPane resultsSPanel = new JScrollPane(resultsArea);
        resultsSPanel.setBounds(25, 50, 240, 195);
        add(resultsSPanel);
        resultsArea.append("From the highest to the lowest scores:\n");
    }

    public void results(String score) {
        for(String result : StarRanking.results.keySet()) {
            if(StarRanking.results.get(result).equals(score)) {
                resultsArea.append("-> " + result + "  " + score + "\n");
            }
        }
    }

    public void allResults() {
        results("*****");
        results("****");
        results("***");
        results("**");
        results("*");
    }
}
