import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Adam Sorrenti
 * date: 2019-01-22
 * description: Class which installs sshfs and winfsp from internal resources.
 */
public class Installer {
    private URL path;
    private File file;
    private Runtime rf;
    private Process pf;


    Installer()
    {
        this.rf = Runtime.getRuntime();
    }


    void sshfs() throws URISyntaxException, IOException, InterruptedException
    {
        path = Installer.class.getClassLoader().getResource("resources/sshfs-win-2.7.17334-x64.msi");
        file = new File(path.toURI());
        pf = rf.exec("msiexec /i \""+file.getPath()+"\"");
        pf.waitFor();
        System.out.println("sshfs-win-2.7.17334-x64.msi has closed.");
    }


    void winfsp() throws URISyntaxException, IOException, InterruptedException
    {
        path = Installer.class.getClassLoader().getResource("resources/winfsp-1.4.19016.msi");
        file = new File(path.toURI());
        pf = rf.exec("msiexec /i \""+file.getPath()+"\"");
        pf.waitFor();
        System.out.println("winfsp-1.4.19016.msi has closed.");
    }
}
