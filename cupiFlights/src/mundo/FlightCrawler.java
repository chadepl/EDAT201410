package mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;





import java.util.Calendar;
import java.util.Date;

import json.JSONArray;
import json.JSONObject;
import lista.Lista;



import trie.Trie;



public class FlightCrawler implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightCrawler(){

	}

	public void readAll(Trie<Aeropuerto> arbolAeropuertos,Lista<Aeropuerto> listaAeropuertos, Trie <Vuelo> arbolVuelos, Lista<Vuelo> listaVuelos, Trie<Aerolinea> arbolAerolineas, Lista<Aerolinea> 	listaAerolineas) {
		try{
		System.out.println("Entre a cargar aeropuertos");
		readAllAirports(arbolAeropuertos, listaAeropuertos);
		System.out.println("Cargue aeropuertos");
		}catch(Exception e){
			System.out.println("Problemas con los aeropuertos");
		}
		try{
		System.out.println("Entre a cargar vuelos");
		readAllFlights(arbolVuelos, listaVuelos, arbolAeropuertos, listaAeropuertos, arbolAerolineas, listaAerolineas);
		System.out.println("Cargue vuelos");
		}catch(Exception e){
			System.out.println("Problemas con los vuelos");
		}
	}

	public void readAllAirports(Trie<Aeropuerto> arbol,Lista<Aeropuerto> lista) throws IOException{
		String[] nombres = new String[50];
		BufferedReader in = new BufferedReader(new FileReader("/Users/Nicolas/Desktop/airports"));
		String linea="";
		int index = 0;
		while((linea=in.readLine())!=null){
			System.out.println(linea);
			nombres[index] = (String) linea.trim();
			index++;
		}
		read(nombres,arbol,lista);
	}
	
	public void read(String[] codigos,Trie<Aeropuerto> arbol,Lista<Aeropuerto> lista) throws IOException{
		JSONArray arreglo = readAirports();
		for(int i=0;i<arreglo.length();i++){
			JSONObject actual = arreglo.getJSONObject(i);
			
			for(int j=0;j<codigos.length ;j++){
				if(codigos[j].equals(actual.get("fs"))){
					Aeropuerto aeropuerto=new Aeropuerto(actual.get("name").toString(), actual.get("fs").toString(), actual.get("city").toString(), actual.get("countryName").toString(),actual.get("latitude").toString(),actual.get("longitude").toString());
					arbol.agregar(aeropuerto.darCodigo(),aeropuerto);
					lista.agregar(aeropuerto);
				}
			}
		}
		
	}
	
	public JSONArray readAirports() throws IOException{
		
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
		return array;
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

		Aeropuerto aeropuerto=new Aeropuerto(valores.get("name").toString(), valores.get("fs").toString(), valores.get("city").toString(), valores.get("countryName").toString(),valores.get("latitude").toString(),valores.get("longitude").toString());

		arbol.agregar(aeropuerto.darCodigo(),aeropuerto);
		lista.agregar(aeropuerto);
		return aeropuerto;

	}

	public void readAllFlights(Trie<Vuelo> arbol,Lista<Vuelo> lista, Trie<Aeropuerto> arbolAeropuertos, Lista<Aeropuerto> listaAeropuertos, Trie<Aerolinea> arbolAerolineas,Lista<Aerolinea> listaAerolineas) throws IOException{
		String[] dias={"28","29","30","1","2"};
		String[] mes={"4","4","4","5","5"};
		for(int x=0;x<dias.length;x++){
			System.out.println("Paso el primer for");
			for(int y=0;y<5;y++){
				System.out.println("Paso el segundo for");
				Aeropuerto air1 = listaAeropuertos.dar(y);
				for(int z=0;z<5;z++){
					System.out.println("Paso el tercer for");
					Aeropuerto air2 = listaAeropuertos.dar(z);
					try{
					if(air1!=air2){
						String json = "";
						String json2 = "";
						//curl -v  -X GET "https://api.flightstats.com/flex/flightstatus/rest/v2/json/route/status/CLO/BOG/arr/2014/4/28?appId=810e68cb&appKey=85b7a30afc5fa9959d710b7e4e16632f&hourOfDay=0&numHours=24&utc=false&maxFlights=1"
						URL consulta = new URL("https://api.flightstats.com/flex/flightstatus/rest/v2/json/route/status/"+air1.codigo+"/"+air2.codigo+"/arr/2014/"+mes[x]+"/"+dias[x]+"?appId=810e68cb&appKey=85b7a30afc5fa9959d710b7e4e16632f&hourOfDay=0&numHours=24&utc=false&maxFlights=1");
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
						JSONArray array=(JSONArray)jsonObject.get("flightStatuses");
						JSONObject objeto=array.getJSONObject(0);
						JSONObject array1=(JSONObject) jsonObject.get("appendix");
						JSONArray objeto1=(JSONArray)array1.get("airlines");
						JSONObject objeto12 = (JSONObject)objeto1.get(0);
						
						
						
						String idVuelo = (String) objeto.get("flightNumber");
						String fs = (String) objeto.get("carrierFsCode");
						String nombreAerolinea = (String)objeto12.get("name");
						String airLlegada = (String) objeto.get("arrivalAirportFsCode");
						String airSalida = (String) objeto.get("departureAirportFsCode");
						Date fecha = new Date(2014, Integer.parseInt(mes[x]), Integer.parseInt(dias[x]));
						
						System.out.println("Paso la primera lectura JSON");
						
						
						//curl -v  -X GET "https://api.flightstats.com/flex/ratings/rest/v1/json/flight/AV/9240?appId=810e68cb&appKey=85b7a30afc5fa9959d710b7e4e16632f"
						
						URL consulta2 = new URL("https://api.flightstats.com/flex/ratings/rest/v1/json/flight/"+fs+"/"+idVuelo+"?appId=810e68cb&appKey=85b7a30afc5fa9959d710b7e4e16632f");
						URLConnection conexion2 = consulta2.openConnection();
						BufferedReader in2 = new BufferedReader(new InputStreamReader(conexion2.getInputStream())); 
						StringBuilder sBuilder2 = new StringBuilder();
						String line2 = null;
						while ((line2 = in2.readLine()) != null) {
							sBuilder2.append(line2 + "\n");
						}
						in2.close();
						json2 = sBuilder2.toString();
						JSONObject jsonObject2 = new JSONObject(json2);
						JSONArray array2=(JSONArray)jsonObject2.get("ratings");
						JSONObject objeto2=array2.getJSONObject(0);
						
						int ontime = (int) objeto2.get("ontime");
						int cancelled = (int) objeto2.get("cancelled");
						int quince = (int) objeto2.get("late15");
						int media = (int) objeto2.get("late30");
						int cuarenta = (int) objeto2.get("late45");
						Double calificacion = (Double) objeto2.get("allStars");
						
						System.out.println("Paso la segunda lectura JSON");
						
						Vuelo vuelo = new Vuelo(air1, air2, fecha, idVuelo, fs, calificacion, quince, media, cuarenta, cancelled, ontime);
						
						lista.agregar(vuelo);
						
						System.out.println("Creo el vuelo"+vuelo);
						
						air1.agregarVueloSaliendo(vuelo);
						
						System.out.println("Agrego Saliendo");
						
						air2.agregarVueloSaliendo(vuelo);
						
						System.out.println("Agrego Entrando");
						
						if(arbolAerolineas.buscar(nombreAerolinea)==null){
							
							System.out.println("Entro al IF");
							
							Aerolinea carrier = new Aerolinea(nombreAerolinea, fs);
							carrier.agregarVuelo(vuelo);
							arbolAerolineas.agregar(nombreAerolinea, carrier);
							listaAerolineas.agregar(carrier);
							
							System.out.println("Agrego al arbol y a la lista");
							
						}else{
							
//							System.out.println("Entro al ELSE");
//							
//							Aerolinea aerolineaEncontrada = arbolAerolineas.buscar(nombreAerolinea);
//							Aerolinea aerolineaABorrar = aerolineaEncontrada;
//							aerolineaEncontrada.agregarVuelo(vuelo);
//							listaAerolineas.eliminar(aerolineaABorrar);
//							arbolAerolineas.eliminar(nombreAerolinea);
//							listaAerolineas.agregar(aerolineaEncontrada);
//							arbolAerolineas.agregar(nombreAerolinea, aerolineaEncontrada);
//							
//							System.out.println("Agrego al arbol y a la lista");
							
						}
					}
					}catch(Exception e){
						System.out.println("Se acabaron los request");
						e.printStackTrace();
					}
				}
			}
		}
	}



	


}
