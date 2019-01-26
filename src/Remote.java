import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Adam Sorrenti
 * date: 2019-01-22
 * description: Class containing methods to connect to Ryerson's SSH server.
 */
public class Remote {

    private final String USERNAME;
    private final String PASSWORD;
    private Runtime rf;
    private Process pf;
    private URL path;
    private File file;
    private boolean regExists;

    Remote(String user, String pass)
    {
        this.USERNAME = user;
        this.PASSWORD = pass;
        this.rf = Runtime.getRuntime();
    }


    void connect() throws IOException, InterruptedException
    {
        String command = "c:\\windows\\system32\\net.exe use H: \\\\sshfs\\"
                +USERNAME+"@moon.scs.ryerson.ca "+PASSWORD+" /persistent:Yes";
        pf = rf.exec(command);
        pf.waitFor();
    }


    void RestoreConnection() throws URISyntaxException, IOException, InterruptedException
    {
        if(regExists)
        {
            path = Installer.class.getClassLoader().getResource("resources/RestoreConnection.ps1");
            file = new File(path.toURI());
            pf = rf.exec("cmd /c start powershell.exe -executionpolicy ByPass -file "+file.getPath());
            pf.waitFor();
            regExists = !regExists;
        }
    }


    boolean checkConnection()
    {
        file = new File("H:\\");
        return file.isDirectory();
    }
}
