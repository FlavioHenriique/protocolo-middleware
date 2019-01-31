package app;

import interfaces.ProtocoloCliente;
import protocolo.ProtocloClienteImpl;

public class App {
    public static void main(String[] args) {
        ProtocoloCliente protocoloCliente = new ProtocloClienteImpl();
    }
}
