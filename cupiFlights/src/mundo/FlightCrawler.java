package mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;





import json.JSONArray;
import json.JSONObject;
import lista.Lista;



import trie.Trie;



public class FlightCrawler {
	
	
	public FlightCrawler(){
		
	}
	
	public void readAll(Trie<Aeropuerto> arbol,Lista<Aeropuerto> lista) throws IOException{
		String json = "";
		URL consulta = new URL("https://api.flightstats.com/flex/airports/rest/v1/json/active?appId=810e68cb&appKey=85b7a30afc5fa9959d710b7e4e16632f");
		URLConnection conexion = consulta.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream())); 
		StringBuilder sBuilder = new StringBuilder();
		String line = null;
		while ((line = in.readLine()) != null) {
			sBuilder.append(line + "\n");
		}
		in.close();
		json = sBuilder.toString();
		JSONObject jsonObject = new JSONObject(json);
		JSONArray array=(JSONArray)jsonObject.get("airports");
		for(int i = 0; i<50;i++){
			JSONObject actual = array.getJSONObject(i);
			Aeropuerto aeropuerto=new Aeropuerto(actual.get("name").toString(), actual.get("fs").toString(), actual.get("city").toString(), actual.get("countryName").toString());
			
			arbol.agregar(aeropuerto.darCodigo(),aeropuerto);
			lista.agregar(aeropuerto);
		}
		
	}
	
	public Aeropuerto readOneAirport(Trie<Aeropuerto> arbol,Lista<Aeropuerto> lista,String code) throws IOException{
		String json = "";
		URL consulta = new URL("https://api.flightstats.com/flex/airports/rest/v1/json/"+code+"/today?appId=810e68cb&appKey=85b7a30afc5fa9959d710b7e4e16632f");
		URLConnection conexion = consulta.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream())); 
		StringBuilder sBuilder = new StringBuilder();
		String line = null;
		while ((line = in.readLine()) != null) {
			sBuilder.append(line + "\n");
		}
		in.close();
		json = sBuilder.toString();
		JSONObject jsonObject = new JSONObject(json);
		JSONObject valores= (JSONObject) jsonObject.get("airport");
		
		Aeropuerto aeropuerto=new Aeropuerto(valores.get("name").toString(), valores.get("fs").toString(), valores.get("city").toString(), valores.get("countryName").toString());
		
		arbol.agregar(aeropuerto.darCodigo(),aeropuerto);
		lista.agregar(aeropuerto);
		
		return aeropuerto;
	
	}

	

}
