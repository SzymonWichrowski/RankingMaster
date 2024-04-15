import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame implements ActionListener {

    JButton tierBtn, starBtn, clashBtn, tiktokBtn;
    Font btnFont = new Font("Dialog", Font.ITALIC, 18);
    Color fontClr = Color.DARK_GRAY;
    public MenuWindow() {   //konstruktor klasy MenuWindow

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int menuWidth = 800, menuHeight = 800;
        setBounds((screen.width - menuWidth)/2, (screen.height - menuHeight)/2, menuWidth, menuHeight);
        setTitle("Choose type of Ranking");
        setLayout(null);

        tierBtn = new JButton("Tier List Ranking");
        tierBtn.setBounds(0, 0, menuWidth/2, menuHeight/2);
        tierBtn.setFont(btnFont);
        tierBtn.setForeground(fontClr);
        tierBtn.setBackground(new Color(204, 81, 81));
        add(tierBtn);
        tierBtn.addActionListener(this);

        starBtn = new JButton("Star Ranking");
        starBtn.setBounds(menuWidth/2, 0, menuWidth/2, menuHeight/2);
        starBtn.setFont(btnFont);
        starBtn.setForeground(fontClr);
        starBtn.setBackground(new Color(182, 127, 71));
        add(starBtn);
        starBtn.addActionListener(this);

        clashBtn = new JButton("Clash Ranking");
        clashBtn.setBounds(0, menuHeight/2, menuWidth/2, menuHeight/2);
        clashBtn.setFont(btnFont);
        clashBtn.setForeground(fontClr);
        clashBtn.setBackground(new Color(47, 110, 131));
        add(clashBtn);
        clashBtn.addActionListener(this);

        tiktokBtn = new JButton("Popular On Tiktok Ranking");
        tiktokBtn.setBounds(menuWidth/2, menuHeight/2, menuWidth/2, menuHeight/2);
        tiktokBtn.setFont(btnFont);
        tiktokBtn.setForeground(fontClr);
        tiktokBtn.setBackground(new Color(69, 152, 113));
        add(tiktokBtn);
        tiktokBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == tierBtn) {
            dispose();
            SwingUtilities.invokeLater(() -> {
                TierListRanking tierListRanking = new TierListRanking();
                tierListRanking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                tierListRanking.setVisible(true);
            });
        }
        if(source == starBtn) {
            dispose();
            SwingUtilities.invokeLater(() -> {
                StarRanking starRanking = new StarRanking();
                starRanking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                starRanking.setVisible(true);
            });
        }
        if(source == clashBtn) {
            dispose();
            SwingUtilities.invokeLater(() -> {
                ClashRanking clashRanking = new ClashRanking();
                clashRanking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                clashRanking.setVisible(true);
            });
        }
        if(source == tiktokBtn) {
            dispose();
            SwingUtilities.invokeLater(() -> {
                TiktokRanking tiktokRanking = new TiktokRanking();
                tiktokRanking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                tiktokRanking.setVisible(true);
            });
        }
    }
}
