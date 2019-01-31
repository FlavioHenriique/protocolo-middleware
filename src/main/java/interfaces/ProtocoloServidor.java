package interfaces;

import java.net.InetAddress;

public interface ProtocoloServidor {

    public byte[] getRequest();

    public void sendReply(byte[] reply, InetAddress clientHost, int clientPort);
}
