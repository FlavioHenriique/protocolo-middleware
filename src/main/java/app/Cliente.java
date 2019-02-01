package app;

import fabrica.FactoryArrayByte;
import interfaces.ProtocoloCliente;
import interfaces.ProtocoloServidor;
import interfaces.RemoteRef;
import protocolo.ProtocoloClienteImpl;
import protocolo.ProtocoloServidorImpl;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {

        ProtocoloCliente cliente = new ProtocoloClienteImpl();
        RemoteRef ref = new RemoteRef();
        ref.setHostServer("localhost");
        ref.setPortServer(2222);

        List<Integer> dados = new ArrayList<>();
        dados.add(22);
        dados.add(2);
        try {
            System.out.println("Iniciando cliente");
            byte[] bytes = FactoryArrayByte.transformArrayByte(dados);
            cliente.doOperation(ref, 1, bytes);
            System.out.println("Operação enviada");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
