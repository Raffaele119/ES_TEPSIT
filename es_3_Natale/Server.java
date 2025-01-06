package ClientServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.IOException;


public class Server {
    private static int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("server in ascolto sulla porta " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("nuovo client connesso: " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("errore nel server! " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String line;
            String lastMessage = null;
            ArrayList<String> messaggi = new ArrayList<>(); //array list per la memorizzazione dei messaggi

            //ricezione dei messaggi dal client
            while ((line = in.readLine()) != null) {
                System.out.println("Ricevuto: " + line);
                lastMessage = line.toUpperCase(); //trasforma il messaggio in maiuscolo
                messaggi.add(lastMessage); //aggiunge il messaggio alla lista
                if (line.equalsIgnoreCase("fine-invio") || line.equalsIgnoreCase("FINE-INVIO")) {//controllo dellìultimo messaggio inviato
                    break;
                }
            }
            for (int i = 0; i < messaggi.size(); i++) {
                out.println(messaggi.get(i)); //invia tutti i messaggi al client 
            }

            System.out.println("comunicazione terminata per il client: " + clientSocket.getInetAddress());
        } catch (IOException e) {
            System.err.println("errore nella comunicazione con il client! " + e.getMessage());
            
        }
    }
}
