import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Stack;

public class ImportarJson {
    public Stack<objcarro> Importar( String nombreArchivo) {
        Stack<objcarro> p = new Stack<>();
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(nombreArchivo + ".json")) {
            Type tipo = new TypeToken<Stack<objcarro>>() {
            }.getType();
            Stack<objcarro> listaCarros = gson.fromJson(reader, tipo);

            for (objcarro c : listaCarros) {
                p.push(c);
            }
            System.out.println("Archivo Importado Correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}