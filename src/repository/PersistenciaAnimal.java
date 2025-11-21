package sistemaDeAdocao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;

import model.Animal;
import model.cachorro;
import model.gato;


public class PersistenciaAnimal {
	
	private static final String ARQUIVO = "aniamis.json";
	
	private static Gson criarGson() {
		RuntimeTypeAdapterFactory<Animal>adapter = RuntimeTypeAdapterFactory.of(Animal.class,"type")
				.registerSubtype(Cachorro.class, "cachorro")
				.registerSubtype(Gato.class,"gato");
		
		return new GsonBuilder().registerTypeAdapterFactory(adapter).setPrettyPrinting().create();
	}	
	public static List<Animal> carregar(){
		try (FileReader reader = new FileReader(Arquivo)){
			Gson gson = criarGson();
			List<Animal> lista = gson.fromJson(reader, new TypeToken<List<Animal>>() {}.getType());
			
			      if (lista == null) return new ArrayList<>();
			           return lista;
		}catch (Exception e) {
			return new ArrayList<>();
		}
	}
}
