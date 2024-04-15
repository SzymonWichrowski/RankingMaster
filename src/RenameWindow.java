import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenameWindow extends JFrame implements ActionListener {

    JTextField tf1, tf2, tf3, tf4, tf5;
    JButton okBtn;

    RenameWindow() {

        setSize(200, 410);
        setLayout(null);
        getContentPane().setBackground(Color.GRAY);

        tf1 = new JTextField("First Tier");
        tf1.setBounds(25, 30, 150, 30);
        add(tf1);

        tf2 = new JTextField("Second Tier");
        tf2.setBounds(25, 90, 150, 30);
        add(tf2);

        tf3 = new JTextField("Third Tier");
        tf3.setBounds(25, 150, 150, 30);
        add(tf3);

        tf4 = new JTextField("Fourth Tier");
        tf4.setBounds(25, 210, 150, 30);
        add(tf4);

        tf5 = new JTextField("Fifth Tier");
        tf5.setBounds(25, 270, 150, 30);
        add(tf5);

        okBtn = new JButton("OK");
        okBtn.setBounds(65, 320, 70, 30);
        okBtn.setBackground(TierListRanking.getBtnColor());
        add(okBtn);
        okBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == okBtn) {
            TierListRanking.rename(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText());
            dispose();
        }
    }
}
