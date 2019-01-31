package interfaces;


import java.io.IOException;

public interface ProtocoloCliente {

    public byte[] doOperation(RemoteRef s, int operationId, byte[] arguments) throws IOException, ClassNotFoundException;
}
