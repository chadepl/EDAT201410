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
	
	 public final static String RUTA_ARCHIVO_SERIALIZADO = "./Users/Nicolas/Desktop/Serializados/";

	/**
	 * Constante de la ruta para guardar el arbol de aeropuertos.
	 */
	private static final String RUTA_ARBOL_AEROPUERTOS = "."+File.separator+"data"+File.separator+"arbolAeropuertos";

	/**
	 * Constante de la ruta para guardar el arbol de aerolineas.
	 */
	private static final String RUTA_ARBOL_AEROLINEAS = "."+File.separator+"data"+File.separator+"arbolAerlineas";

	/**
	 * Constante de la ruta para guardar el arbol de vuelos.
	 */
	private static final String RUTA_ARBOL_VUELOS= "."+File.separator+"data"+File.separator+"arbolVuelos";

	/**
	 * Constante de la ruta para guardar la lista de aeropuertos.
	 */
	private static final String RUTA_LISTA_AEROPUERTOS = "."+File.separator+"data"+File.separator+"listaAeropuertos";

	/**
	 * Constante de la ruta para guardar la lista de aerolineas.
	 */
	private static final String RUTA_LISTA_AEROLINEAS = "."+File.separator+"data"+File.separator+"listaAerlineas";

	/**
	 * Constante de la ruta para guardar la lista de vuelos.
	 */
	private static final String RUTA_LISTA_VUELOS= "."+File.separator+"data"+File.separator+"listaVuelos";

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
	public Lista<Aeropuerto> listaAeropuertos;

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
                File tmp = new File(  RUTA_ARCHIVO_SERIALIZADO );
                System.out.println("Nombre=" + tmp.getName( ));
                System.out.println("Path=" + tmp.getPath( ));
                System.out.println("Abs. Path=" + tmp.getAbsolutePath( ));
                if ( tmp.exists( ) )
                {
                    FileInputStream fis = new FileInputStream( tmp );
                    ObjectInputStream ois = new ObjectInputStream( fis );
                    instancia = (CupiFlight) ois.readObject( );
                    ois.close();
                    fis.close();
                    System.out.println("CupiFlight Deserializado");
                }
                else
                {
                    instancia = new CupiFlight( );                    
                    System.out.println("CupiFlight Nuevo");
                }
                
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
			try {
				
				arbolAeropuertos=new Trie<Aeropuerto>();
				listaAeropuertos=new Lista<Aeropuerto>();
				cargarInformacionBase();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
	}

	/**
	 * Carga la informacion de 50 aeropuertos como minimo.
	 * @throws IOException 
	 */
	public void cargarInformacionBase() throws IOException {
		crawler=new FlightCrawler();
		crawler.readAll(arbolAeropuertos, listaAeropuertos);

	}

	/**
	 * Agrega un aeropuerto al sistema.
	 * @param aAgregar Aerorpuerto a agregar.
	 * @return True si se pudo arreglar. Falso en caso contrario.
	 */
	public Aeropuerto agregarAeropuerto(String codigo)  throws IOException{
		
		Aeropuerto air=crawler.readOneAirport(arbolAeropuertos, listaAeropuertos, codigo);
		
		return air;
	}

	/**
	 * Elimina un aeropuerto del sistema.
	 * @param aEliminar Aeropuerto a eliminar.
	 * @return El elemento eliminado si se pudo realizar la accion. Null en caso contrario.
	 */
	public Aeropuerto eliminarAeropuerto(String codigo) {
		return null;
	}

	/**
	 * Califica un aeropuerto del sistema.
	 * @param calificacion Calificacion del sistema. calificacion>=0. calificacion<=5.
	 */
	public void calificarAeropuerto(int calificacion) {
	}

	/**
	 * * Consulta la calificacion de un aeropuerto.
	 * @param aInvestigar aeropuerto a consultar su calificacion.
	 * @return La calificacion del aeropuerto.
	 */
	public int consultarCalificacion(Aeropuerto aInvestigar) {
		return 0;
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

	/**
	 * Consultar los vuelos de un aeropuerto en la fecha dada.
	 * @param aBuscar El aeropueto a buscar los vuelos.
	 * @param fecha La fecha de busqueda.
	 * @return Los vuelos del aeropuerto en la fecha dada.
	 */
	public Iterator<Vuelo> consultarVuelos(Aeropuerto aBuscar, Date fecha) {
		Lista<Vuelo> aRetornar=new Lista<Vuelo>();
		if(listaAeropuertos.contiene(aBuscar)){
			for(int j=0;j<listaAeropuertos.darLongitud();j++){
				if(listaAeropuertos.dar(j).equals(aBuscar)){
					Iterator<Vuelo> temp=listaAeropuertos.dar(j).darVuelos();
					while(temp.hasNext()){
						Vuelo temporal=temp.next();
						if(temporal.darFechaDeVuelo().equals(fecha)){
							aRetornar.agregar(temporal);
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
		return null;
	}

	/**
	 * Metodo auxiliar para consultar los vuelos cancelados entre ciertas fechas.
	 * @param fechaInicial Fecha inicial de busqueda.
	 * @param fechaFinal Fecha limite de busqueda.
	 * @return Los vuelos cancelados para las fechas especificadas.
	 */
	public Iterator<Vuelo> consultarVuelosCancelados(Date fechaInicial, Date fechaFinal) {
		return null;
	}

	/**
	 * Metodo auxiliar para consultar los vuelos retrasados entre ciertas fechas.
	 * @param fechaInicial Fecha inicial de busqueda.
	 * @param fechaFinal Fecha limite de busqueda.
	 * @return Los vuelos retrasados para las fechas especificadas.
	 */
	public Iterator<Vuelo> consultarVuelosRetrasados(Date fechaInicial, Date fechaFinal) {
		return null;
	}

	/**
	 * Buscar vuelos segun un rango de calificacion.
	 * @param calificacionInicial Calificacion inicial de filtrado.
	 * @param calificacionFinal Calificacion final de filtrado.
	 * @return Los vuelos dentro del rango especificado.
	 */
	public Iterator<Vuelo> buscarVuelosRangoCalificacion(int calificacionInicial, int calificacionFinal) {
		return null;
	}

	/**
	 * Busca las aerolineas con mas vuelos retrasados.
	 * @return Las aerolineas con mas vuelos retrasados.
	 */
	public Iterator<Aerolinea> consultarAerolineasMasVuelosRetrasados() {
		return null;
	}

	/**
	 * Busca las aerolineas con menos vuelos retrasados.
	 * @return Las aerolineas con menos vuelos retrasados.
	 */
	public Iterator<Aerolinea> consultarAerolineasMenosVuelosRetrasados() {
		return null;
	}

	/**
	 * Muestra el mapa segun tardanza.
	 */
	public void mostrarMapaTardanza() {
	}
	
	/**
	 * Guarda la informacion necesaria para la serializacion.
	 */
	public void guardar(){
		try
        {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( RUTA_ARBOL_AEROPUERTOS ) );
            oos.writeObject( arbolAeropuertos);
            oos = new ObjectOutputStream( new FileOutputStream( RUTA_ARBOL_VUELOS ) );
            oos.writeObject( arbolVuelos);
            oos = new ObjectOutputStream( new FileOutputStream( RUTA_ARBOL_AEROLINEAS) );
            oos.writeObject( arbolAerolineas);
            oos = new ObjectOutputStream( new FileOutputStream( RUTA_LISTA_AEROPUERTOS ) );
            oos.writeObject( listaAeropuertos);
            oos = new ObjectOutputStream( new FileOutputStream( RUTA_LISTA_VUELOS ) );
            oos.writeObject( listaVuelos);
            oos = new ObjectOutputStream( new FileOutputStream( RUTA_LISTA_AEROLINEAS ) );
            oos.writeObject( listaAerolineas);
            oos.close( );
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
	}
}
