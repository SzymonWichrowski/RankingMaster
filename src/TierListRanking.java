import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class TierListRanking extends JFrame implements ActionListener, MouseListener {

    private static JLabel titleLab, Lab1, Lab2, Lab3, Lab4, Lab5, choiceLab;
    private static JButton renameBtn, backBtn, startBtn, infoBtn, fileBtn;
    private static JTextArea tArea1, tArea2, tArea3, tArea4, tArea5;
    private static Color btnColor = Color.PINK;
    private String element;
    private int index = 0;

    private static Map<Integer, String> elements;

    public TierListRanking() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int menuWidth = 1200, menuHeight = 600;
        setBounds((screen.width - menuWidth)/2, (screen.height - menuHeight)/2, menuWidth, menuHeight);
        setTitle("Tier List Ranking");
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);

        titleLab = new JLabel("Tier List Ranking");
        titleLab.setBounds(540, 25, 150, 30);
        titleLab.setFont(new Font("Dialog", Font.ITALIC, 16));
        add(titleLab);

        backBtn = new JButton("Back to menu");
        backBtn.setBounds(1000, 25, 150, 30);
        backBtn.setBackground(btnColor);
        add(backBtn);
        backBtn.addActionListener(this);

        Lab1 = new JLabel("First Tier");
        Lab1.setBounds(50, 75, 200, 25);
        add(Lab1);

        Lab2 = new JLabel("Second Tier");
        Lab2.setBounds(275, 75, 200, 25);
        add(Lab2);

        Lab3 = new JLabel("Third Tier");
        Lab3.setBounds(500, 75, 200, 25);
        add(Lab3);

        Lab4 = new JLabel("Fourth Tier");
        Lab4.setBounds(725, 75, 200, 25);
        add(Lab4);

        Lab5 = new JLabel("Fifth Tier");
        Lab5.setBounds(950, 75, 200, 25);
        add(Lab5);

        tArea1 = new JTextArea();
        JScrollPane sPane1 = new JScrollPane(tArea1);
        sPane1.setBounds(50, 100, 200, 300);
        tArea1.setBackground(new Color(36, 192, 145));
        add(sPane1);
        tArea1.addMouseListener(this);

        tArea2 = new JTextArea();
        JScrollPane sPanel2 = new JScrollPane(tArea2);
        sPanel2.setBounds(275, 100, 200, 300);
        tArea2.setBackground(new Color(117, 203, 87));
        add(sPanel2);
        tArea2.addMouseListener(this);

        tArea3 = new JTextArea();
        JScrollPane sPanel3 = new JScrollPane(tArea3);
        sPanel3.setBounds(500, 100, 200, 300);
        tArea3.setBackground(new Color(238, 214, 62));
        add(sPanel3);
        tArea3.addMouseListener(this);

        tArea4 = new JTextArea();
        JScrollPane sPanel4 = new JScrollPane(tArea4);
        sPanel4.setBounds(725, 100, 200, 300);
        tArea4.setBackground(new Color(215, 142, 68));
        add(sPanel4);
        tArea4.addMouseListener(this);

        tArea5 = new JTextArea();
        JScrollPane sPanel5 = new JScrollPane(tArea5);
        sPanel5.setBounds(950, 100, 200, 300);
        tArea5.setBackground(new Color(201, 68, 80));
        add(sPanel5);
        tArea5.addMouseListener(this);

        infoBtn = new JButton("Info");
        infoBtn.setBounds(70, 450, 100, 50);
        infoBtn.setBackground(btnColor);
        add(infoBtn);
        infoBtn.addActionListener(this);

        renameBtn = new JButton("Rename");
        renameBtn.setBounds(200, 450, 100, 50);
        renameBtn.setBackground(btnColor);
        add(renameBtn);
        renameBtn.addActionListener(this);

        fileBtn = new JButton("Select file");
        fileBtn.setBounds(330, 450, 200, 50);
        fileBtn.setBackground(btnColor);
        add(fileBtn);
        fileBtn.addActionListener(this);

        startBtn = new JButton("Start");
        startBtn.setBounds(560, 450, 100, 50);
        startBtn.setBackground(btnColor);
        add(startBtn);
        startBtn.addActionListener(this);
        startBtn.setEnabled(false);

        choiceLab = new JLabel("Choose tier for: ");
        choiceLab.setBounds(690, 450, 500, 50);
        add(choiceLab);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == renameBtn) {
            SwingUtilities.invokeLater(() -> {
                RenameWindow renameWindow = new RenameWindow();
                renameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                renameWindow.setVisible(true);
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
            JOptionPane.showMessageDialog(null, "Type of ranking which allows users to place elements in specific category\n" +
                                                                "-> Click on 'Rename' button to personalize categories\n" +
                                                                "-> Click on 'Select file' button to choose text file with elements you want to use in ranking\n" +
                                                                "-> Click on 'Start' button to begin \n" +
                                                                "-> Click on any area to choose category which matches the current element\n" +
                                                                "Enjoy and have fun!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        else if(source == startBtn) {
            nextElement();
            startBtn.setEnabled(false);
            fileBtn.setEnabled(false);
        }

        else if (source == fileBtn) {
            SwingUtilities.invokeLater(() -> {
                SelectFileForTierList selectFile = new SelectFileForTierList();
                selectFile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                selectFile.setVisible(true);
            });
        }
    }

    public static void rename(String name1, String name2, String name3, String name4, String name5) {
        Lab1.setText(name1);
        Lab2.setText(name2);
        Lab3.setText(name3);
        Lab4.setText(name4);
        Lab5.setText(name5);
    }

    public static Color getBtnColor() {
        return btnColor;
    }

    public void nextElement() {
        element = elements.get(index);
        index++;
        if(element != null) {
            choiceLab.setText("Choose tier for: " + element);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Object source = e.getSource();

        if(source == tArea1) {
            filling(tArea1);
        }
        if(source == tArea2) {
           filling(tArea2);
        }
        if(source == tArea3) {
            filling(tArea3);
        }
        if(source == tArea4) {
            filling(tArea4);
        }
        if(source == tArea5) {
            filling(tArea5);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void filling(JTextArea area) {
        if(!(element == null)){
            area.append("-> " + element + "\n");
            nextElement();
        }
        else choiceLab.setText("Choose tier for: " );
    }

    public static void setElements(Map<Integer, String> elements) {
        TierListRanking.elements = elements;
    }

    public static void enableStart(){
        startBtn.setEnabled(true);
    }

}




