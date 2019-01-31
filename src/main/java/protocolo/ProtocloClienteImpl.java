package protocolo;

import interfaces.ProtocoloCliente;
import interfaces.RemoteRef;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProtocloClienteImpl implements ProtocoloCliente {
    public byte[] doOperation(RemoteRef s, int operationId, byte[] arguments) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(s.getHostServer(), Integer.getInteger(s.getPortServer()));

        socket.getOutputStream().write(addInformation(arguments, operationId));
        byte[] b = new byte[4];
        socket.getInputStream().read(b);
        return new b;
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
}
