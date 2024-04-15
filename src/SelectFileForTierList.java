import javax.swing.*;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SelectFileForTierList extends SelectFile{

    @Override
    public boolean readFromFile(String file) throws FileNotFoundException {
        if (Files.exists(Paths.get(file))) {
            TierListRanking.setElements(Elements.readFromFile(file));
            TierListRanking.enableStart();
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "File not found!", "Important message", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
