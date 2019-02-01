package app;

import interfaces.ProtocoloServidor;
import protocolo.ProtocoloServidorImpl;

import java.io.IOException;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {

        try {
            ProtocoloServidor servidor = new ProtocoloServidorImpl();
            System.out.println("Iniciando servidor");
            servidor.getRequest();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
