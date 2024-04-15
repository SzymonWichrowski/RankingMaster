import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StarRanking extends JFrame implements ActionListener {

    private static JLabel titleLab, starsLab;
    private static JButton startBtn, confirmBtn, resultsBtn, backBtn, infoBtn, fileBtn;
    private static JComboBox starsBox;
    private String element;
    private int index = 0;
    private static Color btnColor = new Color(222, 141, 66);
    protected static Map<Integer, String> elements;
    protected static Map<String, String> results = new HashMap<>();
    public StarRanking(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int menuWidth = 400, menuHeight = 360;
        setBounds((screen.width - menuWidth)/2, (screen.height - menuHeight)/2, menuWidth, menuHeight);
        setTitle("Star Ranking");
        setLayout(null);
        getContentPane().setBackground(new Color(168, 102, 33));

        titleLab = new JLabel("Star Ranking");
        titleLab.setBounds(140, 25, 150, 30);
        titleLab.setFont(new Font("Dialog", Font.ITALIC, 18));
        add(titleLab);

        starsLab = new JLabel("How many stars? : ");
        starsLab.setBounds(95, 145, 300, 30);
        add(starsLab);

        starsBox = new JComboBox<>();
        starsBox.setBounds(95, 185, 100, 30);
        starsBox.setBackground(btnColor);
        starsBox.addItem("*");
        starsBox.addItem("**");
        starsBox.addItem("***");
        starsBox.addItem("****");
        starsBox.addItem("*****");
        add(starsBox);
        starsBox.setEnabled(false);

        infoBtn = new JButton("Info");
        infoBtn.setBounds(140, 65, 100, 30);
        infoBtn.setBackground(btnColor);
        add(infoBtn);
        infoBtn.addActionListener(this);

        fileBtn = new JButton("Select file");
        fileBtn.setBounds(30,105, 200, 30);
        fileBtn.setBackground(btnColor);
        add(fileBtn);
        fileBtn.addActionListener(this);

        startBtn = new JButton("Start");
        startBtn.setBounds(240, 105,  100, 30);
        startBtn.setBackground(btnColor);
        add(startBtn);
        startBtn.addActionListener(this);
        startBtn.setEnabled(false);

        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(205, 185, 100, 30);
        confirmBtn.setBackground(btnColor);
        add(confirmBtn);
        confirmBtn.setEnabled(false);
        confirmBtn.addActionListener(this);

        resultsBtn = new JButton("Results");
        resultsBtn.setBounds(140, 225, 100, 30);
        resultsBtn.setBackground(btnColor);
        add(resultsBtn);
        resultsBtn.addActionListener(this);
        resultsBtn.setEnabled(false);

        backBtn = new JButton("Back to menu");
        backBtn.setBounds(115, 265, 150, 30);
        backBtn.setBackground(btnColor);
        add(backBtn);
        backBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == startBtn) {
            nextElement();
            startBtn.setEnabled(false);
            fileBtn.setEnabled(false);
            starsBox.setEnabled(true);
            confirmBtn.setEnabled(true);
        }
        else if(source == confirmBtn) {
            results.put(element, Objects.requireNonNull(starsBox.getSelectedItem()).toString());
            nextElement();
        }
        else if(source == resultsBtn) {
            SwingUtilities.invokeLater(() -> {
                StarsResults starsResults = new StarsResults();
                starsResults.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                starsResults.setVisible(true);
                starsResults.allResults();
            });
        }
        else if(source == backBtn) {
            dispose();
            SwingUtilities.invokeLater(() -> {
                MenuWindow menuWindow = new MenuWindow();
                menuWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuWindow.setVisible(true);
            });
        }
        else if(source == infoBtn) {
            JOptionPane.showMessageDialog(null, "Type of ranking for stars enjoyers\n" +
                                                                "-> Click on 'Select file' button to choose text file with elements you want to use in ranking\n" +
                                                                "-> Click on 'Start' button to begin\n" +
                                                                "-> Choose number of stars which matches the current element and click on 'Confirm' button\n" +
                                                                "-> After all elements the 'Results' button will be enabled - click on it to see the final results\n" +
                                                                "Enjoy and have fun!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(source == fileBtn) {
            SwingUtilities.invokeLater(() -> {
                SelectFileForStar selectFile = new SelectFileForStar();
                selectFile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                selectFile.setVisible(true);
            });
        }
    }
    public void nextElement() {
        element = elements.get(index);
        index++;
        if(element != null) {
            starsLab.setText("How many stars? : " + element);
        }
        else {
            starsLab.setText("How many stars? :");
            confirmBtn.setEnabled(false);
            resultsBtn.setEnabled(true);
        }
    }

    public static void setElements(Map<Integer, String> elements) {
        StarRanking.elements = elements;
    }

    public static void enableStart(){
        startBtn.setEnabled(true);
    }
}
