package interfaces;

import java.io.IOException;
import java.net.InetAddress;

public interface ProtocoloServidor {

    public byte[] getRequest() throws IOException;

    public void sendReply(byte[] reply, InetAddress clientHost, int clientPort);
}
