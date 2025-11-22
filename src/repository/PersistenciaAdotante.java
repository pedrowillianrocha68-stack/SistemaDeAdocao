import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Adotante;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PersistenciaAdotante {
	
		private static final String ARQUIVO = "adotantes.json";
		
		public static void salvar(List<Adotante> lista) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			try (FileWriter writer = new FileWriter(ARQUIVO)){
				gson.toJson(lista, writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static list<adotante> carregar(){
			Gson gson = new Gson();
			
			try (FileReader reader = new FileReader(ARQUIVO)){
				Type listaTipo = new TypeToken<List<Adotante>>(){}.getType();
				return gson.fromJson(reader, listaTipo);
				} catch (IOException e) {
					return null;
				}
       }
}