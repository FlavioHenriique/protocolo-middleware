package fabrica;

import sun.rmi.log.LogInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FactoryArrayByte {

    public static byte[] transformArrayByte(List<Integer> lista) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(baos);
        out.writeObject(lista);
        return baos.toByteArray();
    }


    public static byte[] executaOperacao(List<Integer> dados) throws IOException {

        System.out.println("Recebendo valores "+ dados.get(0) + " e "+ dados.get(1) + " e operação "+ dados.get(2));
        int resultado = (dados.get(2) == 0) ? dados.get(0) + dados.get(1)
                : dados.get(0) - dados.get(1);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(baos);
        out.writeObject(resultado + "");
        return baos.toByteArray();
    }

    public static String getValor(byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        return (String) ois.readObject();
    }

    public static List<Integer> getListaInteger(byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        ArrayList<Integer> lista = (ArrayList<Integer>) ois.readObject();
        return  lista;
    }

}
