package ClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    private static String SERVER_ADDRESS = "localhost";
    private static int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("sei connesso al server (scrivi 'FINE-INVIO' per terminare)");

            //invia i messaggi al server
            while (true) {
                String input = scanner.nextLine();
                out.println(input);

                if (input.equalsIgnoreCase("FINE-INVIO")) {
                    break;
                }
            }

            //ricezione del messaggio dal server
            System.out.println("risposta dal server: ");
            String risposta = in.readLine();

            while (risposta != null) {
                System.out.println(risposta); //stampa del messaggio ricevuto
                if (risposta.equalsIgnoreCase("FINE-INVIO")) {//appena arriva al fine-invio termina
                    System.out.println("i messaggi sono stati inviati");
                    break; 
                }
                risposta = in.readLine();
            }

            System.out.println("connessione terminata");
        } catch (IOException e) {
            System.err.println("errore nella comunicazione con il server! " + e.getMessage());
        }
    }
}
