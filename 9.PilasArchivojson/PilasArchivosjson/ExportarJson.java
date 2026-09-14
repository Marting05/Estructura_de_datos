import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class ExportarJson {
    public void exportarJson(Stack<objcarro> listaCarros) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("carros.json")) {
            gson.toJson(listaCarros, writer);
            System.out.println("Lista exportada correctamente a carros.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}