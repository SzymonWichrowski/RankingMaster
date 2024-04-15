import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Elements {

    public static Map<Integer, String> readFromFile(Scanner scanner) {

        Map<Integer, String> map = new HashMap<>();
        int number = 0;
        String line;
        while(scanner.hasNext()) {
            line = scanner.nextLine();
            map.put(number, line);
            number++;
        }
        return map;
    }

    public static Map<Integer, String> readFromFile(String file_name) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(file_name));
        return readFromFile(scanner);
    }

    public static List<String> readToList(Scanner scanner) {

        List<String> list = new ArrayList<>();
        String line;
        while(scanner.hasNext()) {
            line = scanner.nextLine();
            list.add(line);
        }
        return list;
    }

    public static List<String> readToList(String file_name) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(file_name));
        return readToList(scanner);
    }
}
