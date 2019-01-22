import java.io.File;
import java.net.URL;

/**
 * @author Adam Sorrenti
 * date: 2019-01-21
 * description: Ryerson University Remote SSH Access! RU Remote????
 */

public class Main {

    public static void main(String[] args) {

        Installer install;
        Remote connect;

        install = new Installer();
        try{
            install.sshfs();
            install.winfsp();
        }catch (Exception ex){}





    }
}
