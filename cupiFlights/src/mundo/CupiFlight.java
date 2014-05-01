package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;

import org.jboss.system.server.ServerConfig;
import org.jboss.system.server.ServerConfigLocator;

import trie.Trie;
import lista.Lista;

public class CupiFlight implements ICupiFlight, Serializable{

	/**
	 * Constante de serializacion.
	 */
	private static final long serialVersionUID = 1000L;

	public final static String RUTA_ARCHIVO_SERIALIZADO = "/Users/Nicolas/git/EDAT201410/cupiFlights/Serializados/";

	/**
	 * Constante de la ruta para guardar el arbol de aeropuertos.
	 */
	private static final String RUTA_ARBOL_AEROPUERTOS = RUTA_ARCHIVO_SERIALIZADO+"arbolAeropuertos.ser";

	/**
	 * Constante de la ruta para guardar el arbol de aerolineas.
	 */
	private static final String RUTA_ARBOL_AEROLINEAS = RUTA_ARCHIVO_SERIALIZADO+"arbolAerlineas.ser";

	/**
	 * Constante de la ruta para guardar el arbol de vuelos.
	 */
	private static final String RUTA_ARBOL_VUELOS= RUTA_ARCHIVO_SERIALIZADO+"arbolVuelos.ser";

	/**
	 * Constante de la ruta para guardar la lista de aeropuertos.
	 */
	private static final String RUTA_LISTA_AEROPUERTOS = RUTA_ARCHIVO_SERIALIZADO+"listaAeropuertos.ser";

	/**
	 * Constante de la ruta para guardar la lista de aerolineas.
	 */
	private static final String RUTA_LISTA_AEROLINEAS = RUTA_ARCHIVO_SERIALIZADO+"listaAerlineas.ser";

	/**
	 * Constante de la ruta para guardar la lista de vuelos.
	 */
	private static final String RUTA_LISTA_VUELOS= RUTA_ARCHIVO_SERIALIZADO+"listaVuelos.ser";

	/**
	 * Arbol de aeropuertos.
	 */
	private Trie<Aeropuerto> arbolAeropuertos;

	/**
	 * Arbol de vuelos.
	 */
	private Trie<Vuelo> arbolVuelos;

	/**
	 * Arbol de aerolineas.
	 */
	private Trie<Aerolinea> arbolAerolineas;

	/**
	 * Lista de aeropuertos.
	 */
	private Lista<Aeropuerto> listaAeropuertos;

	/**
	 * Lista de vuelos.
	 */
	private Lista<Vuelo> listaVuelos;

	/**
	 * Lista de aerolineas.
	 */
	private Lista<Aerolinea> listaAerolineas;

	/**
	 * Lista de aerolineas.
	 */
	private FlightCrawler crawler;

	private static CupiFlight instancia = null;

	public static CupiFlight getInstance( )
	{

		System.out.println("getInstance");
		if( instancia == null )
		{
			System.out.println("Creando instancia");
			try
			{
				//                ServerConfig config = ServerConfigLocator.locate( );
				//                File dataDir = config.getServerDataDir();
//				File tmp = new File(  RUTA_ARCHIVO_SERIALIZADO );
//				System.out.println("Nombre=" + tmp.getName( ));
//				System.out.println("Path=" + tmp.getPath( ));
//				System.out.println("Abs. Path=" + tmp.getAbsolutePath( ));
//				if ( tmp.exists( ) )
//				{
//					FileInputStream fis = new FileInputStream( tmp );
//					ObjectInputStream ois = new ObjectInputStream( fis );
//					instancia = (CupiFlight) ois.readObject( );
//					ois.close();
//					fis.close();
//					System.out.println("CupiFlight Deserializado");
					
					instancia = new CupiFlight( );                    
					System.out.println("CupiFlight Nuevo");
//				}
//				else
//				{
//					instancia = new CupiFlight( );                    
//					System.out.println("CupiFlight Nuevo");
//				}

			}
			catch( Exception e )
			{
				instancia = new CupiFlight( );
				System.out.println("CupiFlight Nuevo");
			}
		}
		return instancia;
	}

	/**
	 * Constructor del cupiFlight.
	 */
	public CupiFlight(){
		
		crawler = new FlightCrawler();
		System.out.println("Estoy en el constructor");
		
		try {
			cargar();
			System.out.println("Pude cargar");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Entre en el catch");
			
				arbolAeropuertos = new Trie<Aeropuerto>();
				arbolAerolineas = new Trie<Aerolinea>();
				arbolVuelos = new Trie<Vuelo>();
				listaAeropuertos = new Lista<Aeropuerto>();
				listaAerolineas = new Lista<Aerolinea>();
				listaVuelos = new Lista<Vuelo>();
				cargarInformacionBase();
			
		}
		System.out.println("Voy a serializar");
		serializar();
		System.out.println("Serialice");

	}

	/**
	 * Carga la informacion de 50 aeropuertos como minimo.
	 * @throws IOException 
	 */
	public void cargarInformacionBase(){
		crawler=new FlightCrawler();
		crawler.readAll(arbolAeropuertos, listaAeropuertos, arbolVuelos, listaVuelos, arbolAerolineas, listaAerolineas);

	}

	/**
	 * Agrega un aeropuerto al sistema.
	 * @param aAgregar Aerorpuerto a agregar.
	 * @return True si se pudo arreglar. Falso en caso contrario.
	 */
	public Aeropuerto agregarAeropuerto(String codigo)  throws IOException{

		Aeropuerto air=crawler.readOneAirport(arbolAeropuertos, listaAeropuertos, codigo);
		serializar();

		return air;
	}

	/**
	 * Elimina un aeropuerto del sistema.
	 * @param aEliminar Aeropuerto a eliminar.
	 * @return El elemento eliminado si se pudo realizar la accion. Null en caso contrario.
	 */
	public Aeropuerto eliminarAeropuerto(String codigo) {
		Aeropuerto aRetornar=arbolAeropuertos.buscar(codigo);
		if(aRetornar!=null){
		listaAeropuertos.eliminar(aRetornar);
		arbolAeropuertos.eliminar(aRetornar.codigo);
		}
		serializar();
		return aRetornar;
	}

	/**
	 * Califica un aeropuerto del sistema.
	 * @param calificacion Calificacion del sistema. calificacion>=0. calificacion<=5.
	 */
	public boolean calificarAeropuerto(String codigo,int calificacion) {
		boolean aRetornar=false;
		Aeropuerto aCalificar=arbolAeropuertos.buscar(codigo);
		Iterator<Aeropuerto> iterador = listaAeropuertos.iterator();
		while(iterador.hasNext()){
			Aeropuerto actual=iterador.next();
			if(aCalificar.equals(actual)){
				actual.cambiarCalificacion(calificacion);
			}
			aRetornar=true;
		}
		if(aCalificar!=null){		
		aCalificar.cambiarCalificacion(calificacion);
				aRetornar=true;
		}
		serializar();
		return aRetornar;
	}

	/**
	 * * Consulta la calificacion de un aeropuerto.
	 * @param aInvestigar aeropuerto a consultar su calificacion.
	 * @return La calificacion del aeropuerto.
	 */
	public int consultarCalificacion(String aInvestigar) {
		
		Aeropuerto air=arbolAeropuertos.buscar(aInvestigar);
		return air==null?0:air.calificacion;
	}

	/**
	 * Consulta las fechas del sistema.
	 * @return Las fechas del sistema.
	 */
	public Iterator<Date> fechasDelSistema() {
		Lista<Date> temp=new Lista<Date>();
		Iterator<Vuelo> i=listaVuelos.iterator();
		while(i.hasNext()){
			Vuelo t=i.next();
			if(!temp.contiene(t.darFechaDeVuelo()))
				temp.agregar(t.darFechaDeVuelo());
		}
		return temp.iterator();
	}

	/**
	 * Consultar los aeropuertos del sistema.
	 * @return Los aeropuertos del sistema.
	 */
	public Iterator<Aeropuerto> consultarAeropuertos() {
		return listaAeropuertos.iterator();
	}
	
	public Iterator<Vuelo> consultarVuelos(){
		return listaVuelos.iterator();
	}

	/**
	 * Consultar los vuelos de un aeropuerto en la fecha dada.
	 * @param aBuscar El aeropueto a buscar los vuelos.
	 * @param fecha La fecha de busqueda.
	 * @return Los vuelos del aeropuerto en la fecha dada.
	 */
	public Iterator<Vuelo> consultarVuelos(String aFind, Date fecha, String status1,String status2) {
		Lista<Vuelo> aRetornar=new Lista<Vuelo>();
		Aeropuerto aBuscar = arbolAeropuertos.buscar(aFind);
		if(listaAeropuertos.contiene(aBuscar)){
			for(int j=0;j<listaAeropuertos.darLongitud();j++){
				if(listaAeropuertos.dar(j).equals(aBuscar)){
					if(status1.equals("E")){
						Iterator<Vuelo> temp=listaAeropuertos.dar(j).darVuelosEntrando();
						while(temp.hasNext()){
							Vuelo temporal=temp.next();
							if(temporal.darFechaDeVuelo().equals(fecha)){
								aRetornar.agregar(temporal);
							}
						}
					}
					if(status2.equals("S")){
						Iterator<Vuelo> temp=listaAeropuertos.dar(j).darVuelosSaliendo();
						while(temp.hasNext()){
							Vuelo temporal=temp.next();
							if(temporal.darFechaDeVuelo().equals(fecha)){
								aRetornar.agregar(temporal);
							}
						}
					}
					
				}
			}
		}
		return aRetornar.iterator();
	}

	/**
	 * Metodo auxiliar para consultar los vuelos a tiempo entre ciertas fechas.
	 * @param fechaInicial Fecha inicial de busqueda.
	 * @param fechaFinal Fecha limite de busqueda.
	 * @return Los vuelos a tiempo para las fechas especificadas.
	 */
	public Iterator<Vuelo> consultarVuelosATiempo(Date fechaInicial, Date fechaFinal) {
		
		Lista<Vuelo> aRetornar=new Lista<Vuelo>();
		Iterator<Vuelo> iterador = listaVuelos.iterator();
		while(iterador.hasNext()){
			Vuelo actual = iterador.next();
			if(actual.darFechaDeVuelo().compareTo(fechaFinal)>0 && actual.darFechaDeVuelo().compareTo(fechaFinal)<0){
				aRetornar.agregar(actual);
			}
		}
		
		return aRetornar.iterator();
	}

	/**
	 * Metodo auxiliar para consultar los vuelos cancelados entre ciertas fechas.
	 * @param fechaInicial Fecha inicial de busqueda.
	 * @param fechaFinal Fecha limite de busqueda.
	 * @return Los vuelos cancelados para las fechas especificadas.
	 */
	public Iterator<Vuelo> consultarVuelosCancelados(Date fechaInicial, Date fechaFinal) {
		Lista<Vuelo> aRetornar=new Lista<Vuelo>();
		for(int i=0;i<listaVuelos.darLongitud();i++){
			if(listaVuelos.dar(i).darFechaDeVuelo().before(fechaFinal)&&listaVuelos.dar(i).darFechaDeVuelo().after(fechaFinal)){
				if(listaVuelos.dar(i).darCancelados()>0){
					aRetornar.agregar(listaVuelos.dar(i));
				}
			}
		}
		return aRetornar.iterator();
	}

	/**
	 * Metodo auxiliar para consultar los vuelos retrasados entre ciertas fechas.
	 * @param fechaInicial Fecha inicial de busqueda.
	 * @param fechaFinal Fecha limite de busqueda.
	 * @return Los vuelos retrasados para las fechas especificadas.
	 */
	public Iterator<Vuelo> consultarVuelosRetrasados(Date fechaInicial, Date fechaFinal) {
		Lista<Vuelo> aRetornar=new Lista<Vuelo>();
		for(int i=0;i<listaVuelos.darLongitud();i++){
			if(listaVuelos.dar(i).darFechaDeVuelo().before(fechaFinal)&&listaVuelos.dar(i).darFechaDeVuelo().after(fechaFinal)){
				if(listaVuelos.dar(i).darLate15()!=0||listaVuelos.dar(i).darLate30()!=0||listaVuelos.dar(i).darLate45()!=0){
					aRetornar.agregar(listaVuelos.dar(i));
				}
			}
		}
		return aRetornar.iterator();
	}

	/**
	 * Buscar vuelos segun un rango de calificacion.
	 * @param calificacionInicial Calificacion inicial de filtrado.
	 * @param calificacionFinal Calificacion final de filtrado.
	 * @return Los vuelos dentro del rango especificado.
	 */
	public Iterator<Vuelo> buscarVuelosRangoCalificacion(int calificacionInicial) {
		Lista<Vuelo> aRetornar=new Lista<Vuelo>();
		for(int i=0;i<listaVuelos.darLongitud();i++){
			double cal=listaVuelos.dar(i).darCalificacion();
			if(cal>=calificacionInicial){
				aRetornar.agregar(listaVuelos.dar(i));
			}
		}
		return aRetornar.iterator();
	}

	/**
	 * Busca las aerolineas con mas vuelos retrasados.
	 * @return Las aerolineas con mas vuelos retrasados.
	 */
	public Iterator<Aerolinea> consultarAerolineasMasVuelosRetrasados() {
		Lista<Aerolinea> aRetornar=new Lista<Aerolinea>();
		Lista<Aerolinea> temp=ordenarRetraso();
		for(int i=0;i<temp.darLongitud()/2;i++){
			Aerolinea aTemp=temp.dar(i);
			aRetornar.agregar(aTemp);
		}
		return aRetornar.iterator();
	}

	/**
	 * Busca las aerolineas con menos vuelos retrasados.
	 * @return Las aerolineas con menos vuelos retrasados.
	 */
	public Iterator<Aerolinea> consultarAerolineasMenosVuelosRetrasados() {
		Lista<Aerolinea> aRetornar=new Lista<Aerolinea>();
		Lista<Aerolinea> temp=ordenarRetraso();
		for(int i=temp.darLongitud()/2;i<temp.darLongitud();i++){
			Aerolinea aTemp=temp.dar(i);
			aRetornar.agregar(aTemp);
		}
		return aRetornar.iterator();
	}

	/**
	 * Metodo auxiliar para hallar las consultas con mas vuelos retrasados.
	 * @return Las aerolineas organizadas por cantidad de vuelos retrasados.
	 */
	public Lista<Aerolinea> ordenarRetraso(){
		Lista<Aerolinea> aRetornar=new Lista<Aerolinea>();
		for(int k=0;k<listaAerolineas.darLongitud();k++){
			aRetornar.agregar(listaAerolineas.dar(k));
		}
		for(int i=0;i<listaAerolineas.darLongitud();i++){
			Aerolinea temp=listaAerolineas.dar(i);
			for(int j=i;j<listaAerolineas.darLongitud();j++){
				Aerolinea temp2=listaAerolineas.dar(j);
				if(temp2.darCantidadVuelosRetrasados()>temp.darCantidadVuelosRetrasados()){
					aRetornar.cambiar(i, temp2);
					aRetornar.cambiar(j, temp);
				}
			}
		}
		return ordenarRetraso();
	}
	
	public Aeropuerto buscarAeropuerto(String codigo){
		return arbolAeropuertos.buscar(codigo);
	}

	/**
	 * Muestra el mapa segun tardanza.
	 */
	public String mostrarMapaTardanza(String algo) {
		
		if(algo.equals("all")){
			String rutaBasica="http://maps.googleapis.com/maps/api/staticmap?sensor=false&size=610x610&markers=color:blue";
			Iterator<Aeropuerto> iterador = listaAeropuertos.iterator();
			while(iterador.hasNext()){
				Aeropuerto actual=iterador.next();
				rutaBasica+="|"+actual.latitud+","+actual.longitud;
			}
			rutaBasica+="&mobile=true";
			return rutaBasica;
			
		}else{
			Aeropuerto mapeado = arbolAeropuertos.buscar(algo);
			return "http://maps.googleapis.com/maps/api/staticmap?sensor=false&size=610x610&markers=color:blue|"+mapeado.latitud+","+mapeado.longitud+"&mobile=true";
		}
		
	}

	/**
	 * Guarda la informacion necesaria para la serializacion.
	 */
	public void serializar(){
		
		
		
		try{
			FileOutputStream fileOut = new FileOutputStream(RUTA_ARBOL_AEROLINEAS);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(arbolAerolineas);
			System.out.println("arbol de aerolineas serializado");
			
			out.close();
			fileOut.close();
			
			
			
			}catch(Exception e){
				System.out.println("No se pudo serializar arbol de aerolineas");
				e.printStackTrace();
			}
		
		try{
			FileOutputStream fileOut = new FileOutputStream(RUTA_ARBOL_AEROPUERTOS);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(arbolAeropuertos);
			System.out.println("arbol de aeropuertos serializado");
			
			out.close();
			fileOut.close();
			
			
			
			}catch(Exception e){
				System.out.println("No se pudo serializar arbol de aeropuertos");
				e.printStackTrace();
			}
		
		try{
			FileOutputStream fileOut = new FileOutputStream(RUTA_ARBOL_VUELOS);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(arbolVuelos);
			System.out.println("arbol de vuelos serializado");
			
			out.close();
			fileOut.close();
			
			
			
			}catch(Exception e){
				System.out.println("No se pudo serializar arbol de vuelos");
				e.printStackTrace();
			}
			
			try{
			FileOutputStream fileOut1 = new FileOutputStream(RUTA_LISTA_AEROLINEAS);
			ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
			out1.writeObject(listaAerolineas);
			System.out.println("lista de aerolineas Seriaizada");
			
			out1.close();
			fileOut1.close();
			
			}catch(Exception e){
				System.out.println("No se pudo serializar lista de aerolineas");
				e.printStackTrace();
			}
			
			try{
				FileOutputStream fileOut1 = new FileOutputStream(RUTA_LISTA_AEROPUERTOS);
				ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
				out1.writeObject(listaAeropuertos);
				System.out.println("lista de aeropuertos Seriaizada");
				
				out1.close();
				fileOut1.close();
				
				}catch(Exception e){
					System.out.println("No se pudo serializar lista de aeropuertos");
					e.printStackTrace();
				}
			
			try{
				FileOutputStream fileOut1 = new FileOutputStream(RUTA_LISTA_VUELOS);
				ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
				out1.writeObject(listaVuelos);
				System.out.println("lista de vuelos Seriaizada");
				
				out1.close();
				fileOut1.close();
				
				}catch(Exception e){
					System.out.println("No se pudo serializar lista de vuelos");
					e.printStackTrace();
				}
			
			
	}
	
	@SuppressWarnings("unchecked")
	public void cargar() throws Exception{
		
		FileInputStream fileIn1 = new FileInputStream(RUTA_ARBOL_AEROLINEAS);
		ObjectInputStream in1 = new ObjectInputStream(fileIn1);
		arbolAerolineas = (Trie<Aerolinea>)in1.readObject();
		System.out.println("arbol deserializado");
		in1.close();
		fileIn1.close();

		FileInputStream fileIn2 = new FileInputStream(RUTA_ARBOL_AEROPUERTOS);
		ObjectInputStream in2 = new ObjectInputStream(fileIn2);
		arbolAeropuertos = (Trie<Aeropuerto>)in2.readObject();
		System.out.println("arbol deserializado");
		in2.close();
		fileIn2.close();

		FileInputStream fileIn3 = new FileInputStream(RUTA_ARBOL_VUELOS);
		ObjectInputStream in3 = new ObjectInputStream(fileIn3);
		arbolVuelos = (Trie<Vuelo>)in3.readObject();
		System.out.println("arbol deserializado");
		in3.close();
		fileIn3.close();
		
		FileInputStream fileIn4 = new FileInputStream(RUTA_LISTA_AEROLINEAS);
		ObjectInputStream in4 = new ObjectInputStream(fileIn4);
		listaAerolineas = (Lista<Aerolinea>)in4.readObject();
		System.out.println("lista deserializado");
		in4.close();
		fileIn4.close();
		
		FileInputStream fileIn5 = new FileInputStream(RUTA_LISTA_AEROPUERTOS);
		ObjectInputStream in5 = new ObjectInputStream(fileIn5);
		listaAeropuertos = (Lista<Aeropuerto>)in5.readObject();
		System.out.println("lista deserializado");
		in5.close();
		fileIn5.close();
		
		FileInputStream fileIn6 = new FileInputStream(RUTA_LISTA_VUELOS);
		ObjectInputStream in6 = new ObjectInputStream(fileIn6);
		listaVuelos = (Lista<Vuelo>)in6.readObject();
		System.out.println("lista deserializado");
		in6.close();
		fileIn6.close();
	}
}
