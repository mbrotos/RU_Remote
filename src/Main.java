
import java.util.Scanner;

/**
 * @author Adam Sorrenti
 * date: 2019-01-21
 * description: Ryerson University Remote SSH Access! RU Remote????
 */

public class Main {

    public static void main(String[] args) {

        Installer install;
        Scanner scan;
        String user;
        String pass;
        Remote remote;

//        install = new Installer();
//        try{
//            install.sshfs();
//            install.winfsp();
//        }catch (Exception ex){}

        scan = new Scanner(System.in);
        user = scan.nextLine();
        pass = scan.nextLine();
        remote = new Remote(user, pass);
        try{
            remote.connect();
//            remote.RestoreConnection();
        }catch (Exception ex){}


    }
}
