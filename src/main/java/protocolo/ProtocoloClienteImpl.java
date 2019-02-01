package protocolo;

import fabrica.FactoryArrayByte;
import interfaces.ProtocoloCliente;
import interfaces.RemoteRef;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ProtocoloClienteImpl implements ProtocoloCliente {

    private int portaCliente;

    public ProtocoloClienteImpl() {
        this.portaCliente = 2221;
    }

    public byte[] doOperation(RemoteRef s, int operationId, byte[] arguments) {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(portaCliente);
            InetAddress address = InetAddress.getByName(s.getHostServer());
            byte[] info = addInformation(arguments, operationId);
            DatagramPacket packet = new DatagramPacket(info, info.length, address, s.getPortServer());
            socket.send(packet);
            socket.close();
            System.out.println("Esperando resposta");
            this.esperarResposta();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] addInformation(byte[] array, int id) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(array));
        ArrayList<Integer> lista = (ArrayList<Integer>) ois.readObject();
        lista.add(id);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(baos);
        out.writeObject(lista);
        return baos.toByteArray();

    }

    private void esperarResposta() {

        try {
            DatagramSocket socket = new DatagramSocket(portaCliente);
            while (true) {
                byte[] dados = new byte[256];
                DatagramPacket packet = new DatagramPacket(dados, dados.length);
                socket.receive(packet);
                System.out.println("valor: " + FactoryArrayByte.getValor(packet.getData()));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
