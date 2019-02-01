package protocolo;

import fabrica.FactoryArrayByte;
import interfaces.ProtocoloServidor;

import java.io.*;
import java.net.*;
import java.util.List;

public class ProtocoloServidorImpl implements ProtocoloServidor {

    private DatagramSocket socket;
    private int portaServidor = 2222;

    public ProtocoloServidorImpl() throws SocketException {
        socket = new DatagramSocket(portaServidor);
    }

    public byte[] getRequest() throws IOException {

        while (true) {
            byte[] dados = new byte[256];
            DatagramPacket packet = new DatagramPacket(dados, dados.length);
            socket.receive(packet);
            System.out.println("Pacote recebido");
            try {
                List<Integer> lista = FactoryArrayByte.getListaInteger(packet.getData());
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                System.out.println("Enviando resposta");
                sendReply(FactoryArrayByte.executaOperacao(lista), address, port);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendReply(byte[] reply, InetAddress clientHost, int clientPort) {
        try {
            DatagramPacket packet = new DatagramPacket(reply, reply.length, clientHost, clientPort);
            socket.send(packet);
            System.out.println("Resposta enviada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
