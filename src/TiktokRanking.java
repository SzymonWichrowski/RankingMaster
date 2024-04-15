import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TiktokRanking extends JFrame implements ActionListener {

    private static JLabel tiktokLab,
                          firstLab, secondLab, thirdLab, fourthLab, fifthLab,
                          choiceLab;
    private static JButton startBtn, backBtn, confirmBtn, infoBtn, fileBtn;
    private static JComboBox choiceBox;
    private static Color btnColor = new Color(73, 166, 122);
    int index = 0;
    boolean first = false, second = false, third = false, fourth = false, fifth = false;
    protected static List<String> elements;
    public TiktokRanking() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int menuWidth = 600, menuHeight = 550;
        setBounds((screen.width - menuWidth)/2, (screen.height - menuHeight)/2, menuWidth, menuHeight);
        setTitle("Tiktok Ranking");
        setLayout(null);
        getContentPane().setBackground(new Color(38, 108, 75));

        tiktokLab = new JLabel("Tiktok Ranking");
        tiktokLab.setBounds(175, 25, 150, 50);
        tiktokLab.setFont(new Font("Dialog", Font.ITALIC, 16));
        add(tiktokLab);

        firstLab = new JLabel("1.   ____________________________________________");
        firstLab.setBounds(75,80, 500, 50);
        add(firstLab);

        secondLab = new JLabel("2.   ____________________________________________");
        secondLab.setBounds(75,140, 500, 50);
        add(secondLab);

        thirdLab = new JLabel("3.   ____________________________________________");
        thirdLab.setBounds(75,200, 500, 50);
        add(thirdLab);

        fourthLab = new JLabel("4.   ____________________________________________");
        fourthLab.setBounds(75, 260, 500, 50);
        add(fourthLab);

        fifthLab = new JLabel("5.   ____________________________________________");
        fifthLab.setBounds(75,320, 500, 50);
        add(fifthLab);

        backBtn = new JButton("Back to menu");
        backBtn.setBounds(420, 35, 150, 30);
        backBtn.setBackground(btnColor);
        add(backBtn);
        backBtn.addActionListener(this);

        infoBtn = new JButton("Info");
        infoBtn.setBounds(420, 75, 150, 30);
        infoBtn.setBackground(btnColor);
        add(infoBtn);
        infoBtn.addActionListener(this);

        fileBtn = new JButton("Select File");
        fileBtn.setBounds(75, 400 , 150, 30);
        fileBtn.setBackground(btnColor);
        add(fileBtn);
        fileBtn.addActionListener(this);

        startBtn = new JButton("Start");
        startBtn.setBounds(235, 400, 100, 30);
        startBtn.setBackground(btnColor);
        add(startBtn);
        startBtn.addActionListener(this);
        startBtn.setEnabled(false);

        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(345, 400, 100, 30);
        confirmBtn.setBackground(btnColor);
        confirmBtn.setEnabled(false);
        add(confirmBtn);
        confirmBtn.addActionListener(this);

        choiceBox = new JComboBox<>();
        choiceBox.setBounds(420, 200, 100, 50);
        choiceBox.setBackground(btnColor);
        choiceBox.addItem("1");
        choiceBox.addItem("2");
        choiceBox.addItem("3");
        choiceBox.addItem("4");
        choiceBox.addItem("5");
        choiceBox.setEnabled(false);
        add(choiceBox);

        choiceLab = new JLabel("Choose place for: ");
        choiceLab.setBounds(75, 450, 500, 50);
        add(choiceLab);
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
            JOptionPane.showMessageDialog(null, "This type of ranking is very popular on Tiktok app\n" +
                                                                "-> Click on 'Select file' button to choose text file with elements you want to use in ranking\n" +
                                                                "-> Click on 'Start' button to begin\n" +
                                                                "-> Choose placement in ranking without knowing what comes next\n" +
                                                                "Enjoy and have fun!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        else if(source == startBtn) {
            confirmBtn.setEnabled(true);
            choiceBox.setEnabled(true);
            startBtn.setEnabled(false);
            fileBtn.setEnabled(false);
            Collections.shuffle(elements);
            currentChoice();
        }

        else if(source == confirmBtn) {
            switch (Objects.requireNonNull(choiceBox.getSelectedItem()).toString()) {
                case "1" : {
                    if(!first) {
                        firstLab.setText("1.   " + elements.get(index));
                        first = true;
                        index++;
                        currentChoice();
                    }
                }
                break;
                case "2" : {
                    if(!second) {
                        secondLab.setText("2.   " + elements.get(index));
                        second = true;
                        index++;
                        currentChoice();
                    }
                }
                break;
                case "3" : {
                    if(!third) {
                        thirdLab.setText("3.   " + elements.get(index));
                        third = true;
                        index++;
                        currentChoice();
                    }
                }
                break;
                case "4" : {
                    if(!fourth) {
                        fourthLab.setText("4.   " + elements.get(index));
                        fourth = true;
                        index++;
                        currentChoice();
                    }

                }
                break;
                case "5" : {
                    if(!fifth) {
                        fifthLab.setText("5.   " + elements.get(index));
                        fifth = true;
                        index++;
                        currentChoice();
                    }
                }
                break;
            }
        }
        else if (source == fileBtn) {
            SwingUtilities.invokeLater(() -> {
                SelectFileForTiktok selectFile = new SelectFileForTiktok();
                selectFile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                selectFile.setVisible(true);
            });
        }
    }

    public void currentChoice() {
        if(index < 5) {
            choiceLab.setText("Choose place for: " + elements.get(index));
        }
        else choiceLab.setText("Koniec !!!" );
    }

    public static void setElements(List<String> elements) {
        TiktokRanking.elements = elements;
    }

    public static void enableStart() {
        startBtn.setEnabled(true);
    }
}
