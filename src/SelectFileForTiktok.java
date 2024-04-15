import javax.swing.*;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SelectFileForTiktok extends SelectFile{

    @Override
    public boolean readFromFile(String file) throws FileNotFoundException {
        if (Files.exists(Paths.get(file))) {
            TiktokRanking.setElements(Elements.readToList(file));
            TiktokRanking.enableStart();
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "File not found!", "Important message", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
