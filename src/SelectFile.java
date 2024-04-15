import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public abstract class SelectFile extends JFrame implements ActionListener {

    Color backgroundClr = new Color(189, 137, 210);
    JLabel titleLab;
    JTextField fileTxtField;
    JButton confirmBtn;

    public SelectFile() {

        setSize(300, 210);
        setTitle("Select File!");
        setLayout(null);
        getContentPane().setBackground(backgroundClr);

        titleLab = new JLabel("Select File");
        titleLab.setBounds(100, 10, 200, 30);
        titleLab.setFont(new Font("Dialog", Font.ITALIC, 18));
        add(titleLab);

        fileTxtField = new JTextField();
        fileTxtField.setBounds(50, 60, 200, 30);
        add(fileTxtField);

        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(100, 110, 100, 50);
        confirmBtn.setBackground(backgroundClr.darker());
        add(confirmBtn);
        confirmBtn.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == confirmBtn) {
            String file;
            file = fileTxtField.getText();
            try {
                if (readFromFile(file)) dispose();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public boolean readFromFile(String file) throws FileNotFoundException {
        return true;
    }
}


