import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ClashRanking extends JFrame implements ActionListener {

    private static JLabel titleLab, clashLab1, clashLab2;
    private static JButton clashBtn1, clashBtn2, startBtn, infoBtn, backBtn, fileBtn;
    private static Color btnColor = new Color(76, 146, 169);
    protected static Map<Integer, String> elements;
    private static int firstIndex = 0, secondIndex = 1, size, count = 0;
    private static String firstElement, secondElement;
    public ClashRanking() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int menuWidth = 600, menuHeight = 400;
        setBounds((screen.width - menuWidth)/2, (screen.height - menuHeight)/2, menuWidth, menuHeight);
        setTitle("Clash Ranking");
        setLayout(null);
        getContentPane().setBackground(new Color(55, 114, 169));

        titleLab = new JLabel("Clash Ranking");
        titleLab.setBounds(230, 40, 150, 30);
        titleLab.setFont(new Font("Dialog", Font.ITALIC, 18));
        add(titleLab);

        clashLab1 = new JLabel("1.   ______________________________________________________________");
        clashLab1.setBounds(75, 100, 500, 30);
        add(clashLab1);

        clashLab2 = new JLabel("2.   ______________________________________________________________");
        clashLab2.setBounds(75, 170, 500, 30);
        add(clashLab2);

        clashBtn1 = new JButton("1");
        clashBtn1.setBounds(170, 230, 50, 30);
        clashBtn1.setBackground(btnColor);
        add(clashBtn1);
        clashBtn1.setEnabled(false);
        clashBtn1.addActionListener(this);

        clashBtn2 = new JButton("2");
        clashBtn2.setBounds(370, 230, 50, 30);
        clashBtn2.setBackground(btnColor);
        add(clashBtn2);
        clashBtn2.setEnabled(false);
        clashBtn2.addActionListener(this);

        startBtn = new JButton("Start");
        startBtn.setBounds(360, 300, 100, 30);
        startBtn.setBackground(btnColor);
        add(startBtn);
        startBtn.addActionListener(this);
        startBtn.setEnabled(false);

        infoBtn = new JButton("Info");
        infoBtn.setBounds(90, 300, 100, 30);
        infoBtn.setBackground(btnColor);
        add(infoBtn);
        infoBtn.addActionListener(this);

        backBtn = new JButton("Back to menu");
        backBtn.setBounds(400, 30, 150, 30);
        backBtn.setBackground(btnColor);
        add(backBtn);
        backBtn.addActionListener(this);

        fileBtn = new JButton("Select file");
        fileBtn.setBounds(200, 300, 150, 30);
        fileBtn.setBackground(btnColor);
        add(fileBtn);
        fileBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == backBtn) {
            dispose();
            SwingUtilities.invokeLater(() -> {
                MenuWindow menuWindow = new MenuWindow();
                menuWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                menuWindow.setVisible(true);
            });
        }

        else if(source == infoBtn) {
            JOptionPane.showMessageDialog(null,
                                          "Sometimes is easier to make a ranking one step by step\n" +
                                                  "-> Click on 'Select file' button to choose text file with elements you want to use in ranking\n" +
                                                  "-> Click on 'Start' button to begin \n" +
                                                  "-> What do you prefer? Choose 1st or 2nd option\n" +
                                                  "Enjoy and have fun!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        else if(source == startBtn) {
            clashBtn1.setEnabled(true);
            clashBtn2.setEnabled(true);
            startBtn.setEnabled(false);
            fileBtn.setEnabled(false);
            size = elements.size();
            currentElements();
            setFirstClash();
            setSecondClash();
        }

        // zaklada sie ze ranking bedzie gotowy kiedy uzytkownik sprawdzi cala liste elementow, za kazdym razem wybierajac opcje nr 1

        else if(source == clashBtn1) {
            count++;
            if (count == size-1) {
                clashBtn1.setEnabled(false);
                clashBtn2.setEnabled(false);
                results();
            }
            else {
                firstIndex++;
                secondIndex++;
                if(secondIndex < size) {
                    currentElements();
                    setFirstClash();
                    setSecondClash();
                }
                else {
                    count = 0;
                    firstIndex = 0;
                    secondIndex = 1;
                    currentElements();
                    setFirstClash();
                    setSecondClash();
                }
            }

        }

        else if(source == clashBtn2) {
            count = 0;
            elements.replace(secondIndex, firstElement);
            elements.replace(firstIndex, secondElement);
            firstIndex++;
            secondIndex++;
            if(secondIndex < size) {
                currentElements();
                setFirstClash();
                setSecondClash();
            }
            else {
                firstIndex = 0;
                secondIndex = 1;
                currentElements();
                setFirstClash();
                setSecondClash();
            }
        }

        else if(source == fileBtn) {
            SwingUtilities.invokeLater(() -> {
                SelectFileForClash selectFile = new SelectFileForClash();
                selectFile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                selectFile.setVisible(true);
            });
        }
    }

    public static void setFirstClash() {
        clashLab1.setText("1.   " + firstElement);
    }

    public static void setSecondClash() {
        clashLab2.setText("2.   " + secondElement);
    }

    public void currentElements() {
        firstElement = elements.get(firstIndex);
        secondElement = elements.get(secondIndex);
    }

    public void results() {
        ClashResults clashResults = new ClashResults();
        clashResults.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clashResults.setVisible(true);
        clashResults.results();
    }

    public static void setElements(Map<Integer, String> elements) {
        ClashRanking.elements = elements;
    }

    public static void enableStart(){
        startBtn.setEnabled(true);
    }
}
