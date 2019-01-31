package interfaces;


public interface ProtocoloCliente {

    public byte[] doOperation(RemoteRef s, int operationId, byte[] arguments);
}
