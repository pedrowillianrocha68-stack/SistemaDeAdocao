package persistencia;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Adocao;

public class PersistenciaAdocao {
	
    private static final string ARQUIVO = "adocoes.json";
    
    public static ArrayList<Adocao>carregar(){
    	try {
    		FileReader Fr = new FileReader(ARQUIVO);
    		return new Gson().fromJson(fr, new TypeToke<ArrayList<Adocao>>(){}.getType());
    	}catch (Exception e) {
    		return new ArrayList<>();
    	}
    
     }
    public static void salvar(ArrayList<Adocao> lista) {
    	try {
    		Gson gson = new GsonBuilder().setPrettyPrinting().create();
    		FileWriter Fw = new FileWriter(Arquivo);
    		gson.toJson(lista, fw);
    		fw.close();
           }catch (Exception e) {
        	   e.printStackTrace();
           }
    }
}