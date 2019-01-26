
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


        scan = new Scanner(System.in);
        System.out.println("Have you installed the required programs? (Y/N)");
        if (scan.nextLine().equalsIgnoreCase("n"))
        {
            install = new Installer();
            try
            {
                install.sshfs();
                install.winfsp();
            } catch (Exception ex) {}
        }


        do
        {
            System.out.println("Enter username:");
            user = scan.nextLine();
            System.out.println("Enter password:");
            pass = scan.nextLine();
            remote = new Remote(user, pass);

            try
            {
                remote.connect();
                remote.RestoreConnection();
            }catch (Exception ex){}

            if(!remote.checkConnection())
                System.out.println("The network drive was not mapped! Try again!");

        } while(!remote.checkConnection());
        System.out.println("You have successfully connect to moon.scs.ryerson.ca SSH server!");
    }
}
