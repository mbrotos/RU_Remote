import java.io.File;
import java.net.URL;

/**
 * @author Adam Sorrenti
 * date: 2019-01-21
 * description: Ryerson University Remote SSH Access! RU Remote????
 */

public class Main {

    public static void main(String[] args) {

        try {
            URL path;
            File file;
            Runtime rf = Runtime.getRuntime();
            Process pf;

            path = Main.class.getClassLoader().getResource("resources/sshfs-win-2.7.17334-x64.msi");
            file = new File(path.toURI());
            pf = rf.exec("");
            pf.waitFor();

        } catch(Exception e) {
            System.out.println(e.toString()); // not necessary
            e.printStackTrace();
        }

    }
}
