import java.net.URL;
import java.util.Scanner;

public class fetch {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new URL("https://raw.githubusercontent.com/SakirHussain/leet/main/view_of_tree.java").openStream());
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
        s.close();
    }
}