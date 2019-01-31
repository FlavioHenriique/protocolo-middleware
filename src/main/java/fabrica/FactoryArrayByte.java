package fabrica;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

public class FactoryArrayByte {
    public byte[] transformArrayByte(List<Integer> lista) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(baos);
        out.writeObject(lista);
        return baos.toByteArray();
    }
}
