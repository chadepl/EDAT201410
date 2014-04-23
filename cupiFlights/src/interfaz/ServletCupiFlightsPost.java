package interfaz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mundo.Aeropuerto;
import mundo.CupiFlight;

import org.jboss.system.server.ServerConfig;
import org.jboss.system.server.ServerConfigLocator;



@SuppressWarnings("serial")
public class ServletCupiFlightsPost extends HttpServlet {
	
	private static final String SERIALIZADO="./data";
	
	private CupiFlight instancia;
	
	public void init( ) throws ServletException
    {
		System.out.println("Estoy en el INIT");
		instancia = CupiFlight.getInstance();
    }
	
	public void destroy( )
    {
        System.out.println("Destruyendo instancia");
        try
        {
            if ( CupiFlight.getInstance( ) != null )
            {
                ServerConfig config = ServerConfigLocator.locate( );
                File dataDir = config.getServerDataDir();
                File tmp = new File( dataDir + SERIALIZADO );
                System.out.println("Nombre=" + tmp.getName( ));
                System.out.println("Path=" + tmp.getPath( ));
                System.out.println("Abs. Path=" + tmp.getAbsolutePath( ));

                FileOutputStream fos = new FileOutputStream( tmp );
                ObjectOutputStream oos = new ObjectOutputStream( fos );
                oos.writeObject( CupiFlight.getInstance( ) );
                oos.close();
                fos.close();
                System.out.println("CupiFlight Serializada");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error de persistencia en Servidor");
        }
    }
	
	 /**
     * Maneja un pedido POST de un cliente
     * @param request Pedido del cliente
     * @param response Respuesta
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        // Maneja el GET y el POST de la misma manera
    	System.out.println("Aca estoy en doPost");
    	procesarSolicitud(request , response);
    	
    }
    

    
    
    private void procesarSolicitud( HttpServletRequest request, HttpServletResponse response ){
    	try {
    		if(request.getParameter("g1")!=null && request.getParameter("g1").equals("admi")){
    			String param1=request.getParameter("user");
        		String param2=request.getParameter("pass");
        		if(param1.equals("nico") && param2.equals("sexy")){
        			imprimirMensajeAdmi(response);
        		}else{
        			imprimirMensajeError(response);
        		}
    		}else if(request.getParameter("g1")!=null && request.getParameter("g1").equals("invit")){
    			imprimirMensajeInvit(response);
    		}else if(request.getParameter("nombreA") != null && !request.getParameter("nombreA").equals(" ")){
    			imprimirMensajeListo(response);
    			
    		}else if(request.getParameter("admi") != null){
    			
    			int valor=Integer.parseInt(request.getParameter("admi"));
    			
    			imprimirRequerimientos(response,valor);
    			
    		}else if(request.getParameter("invit") != null){
    			
    			int valor=Integer.parseInt(request.getParameter("invit"));
    			
    			imprimirRequerimientos(response,valor);
    	
    		}
    		else if(request.getParameter("req2") != null){
    			String parametro=request.getParameter("req2");
    			Aeropuerto air=instancia.agregarAeropuerto(parametro);
    			imprimirListo(response, air.toString());
    		}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
    
    private void imprimirMensajeAdmi(HttpServletResponse response) throws IOException{
    	PrintWriter out = response.getWriter();
    	out.println("<!DOCTYPE html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("	<title>CupiFlights</title>");
    	out.println("	<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">-->");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h1 class=\"InterfazGeneral\">CupiFlights</h1>");
    	out.println("    ");
    	out.println("    <h2>Acciones del Administrador:</h2>");
    	out.println("    <div>");
    	out.println("        <form action=\"resultadoPost.htm\" method=\"POST\">");
    	out.println("        <table>");
    	out.println("");
    	out.println("            <tr><td><input type=\"radio\" name=\"admi\" value=\"1\">Consultar Aeropuertos en Sistema</td></tr>");
    	out.println("");
    	out.println("            <tr><td><input type=\"radio\" name=\"admi\" value=\"2\">Agregar Aeropuerto</td></tr>");
    	out.println("");
    	out.println("            <tr><td><input type=\"radio\" name=\"admi\" value=\"3\">Eliminar Aeropuerto</td></tr>");
    	out.println("            ");
    	out.println("            <tr><td><input type=\"radio\" name=\"admi\" value=\"4\">Actualizar o Ver Calificaciones</td></tr>");
    	out.println("");
    	out.println("            <tr>");
    	out.println("                <td><input type=\"submit\" value=\"Enviar!\"></td>");
    	out.println("                <td><a href=\"index.htm\">Back to home!</a></td>");
    	out.println("            </tr>");
    	out.println("");
    	out.println("         </table>  ");
    	out.println("            </form>");
    	out.println("    </div>");
    	out.println("</body>");
    	out.println("    ");
    	out.println("<footer>");
    	out.println("	<p class=\"InterfazGeneral\">Material producido por Nicolas y Daniel Production</p>");
    	out.println("</footer>");
    	out.println("</html>");

    }
    
    public void imprimirMensajeInvit(HttpServletResponse response) throws IOException{
    	PrintWriter out = response.getWriter();
    	out.println("<!DOCTYPE html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("	<title>CupiFlights</title>");
    	out.println("	<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">-->");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h1 class=\"InterfazGeneral\">CupiFlights</h1>");
    	out.println("<h2>Acciones del Invitado:</h2>");
    	out.println("    <div>");
    	out.println("        <form action=\"resultadoPost.htm\" method=\"POST\">");
    	out.println("        <table>");
    	out.println("");
    	out.println("            <tr><td><input type=\"radio\" name=\"invit\" value=\"5\">Consultar Fechas en el Sistema</td></tr>");
    	out.println("");
    	out.println("            <tr><td><input type=\"radio\" name=\"invit\" value=\"6\">Consultar Aeropuertos en el Sistema</td></tr>");
    	out.println("");
    	out.println("            <tr><td><input type=\"radio\" name=\"invit\" value=\"7\">Consultar Vuelos por Aeropuerto</td></tr>");
    	out.println("            ");
    	out.println("            <tr><td><input type=\"radio\" name=\"invit\" value=\"8\">Estadisticas de Vuelo por Aeropuerto</td></tr>");
    	out.println("            ");
    	out.println("            <tr><td><input type=\"radio\" name=\"invit\" value=\"9\">Vuelos con Calificacion por Rango</td></tr>");
    	out.println("            ");
    	out.println("            <tr><td><input type=\"radio\" name=\"invit\" value=\"10\">Estadisticas de Vuelo por Aerolinea</td></tr>");
    	out.println("            ");
    	out.println("            <tr><td><input type=\"radio\" name=\"invit\" value=\"11\">Mapa con Indice de Tardanza</td></tr>");
    	out.println("");
    	out.println("            <tr>");
    	out.println("                <td><input type=\"submit\" value=\"Ir!\"></td>");
    	out.println("                <td><a href=\"index.htm\">Back to home!</a></td>");
    	out.println("            </tr>");
    	out.println("");
    	out.println("         </table>  ");
    	out.println("            </form>");
    	out.println("      </div>");
    	out.println("    </body>");
    	out.println("<footer>");
    	out.println("	<p class=\"InterfazGeneral\">Material producido por Nicolas y Daniel Production</p>");
    	out.println("</footer>");
    	out.println("</html>");
    }
    
    public void imprimirRequerimientos(HttpServletResponse response, int req) throws IOException{
    	PrintWriter out = response.getWriter();
    	out.println("<html>");
    	out.println("    <head>");
    	out.println("	<title>CupiFlights</title>");
    	out.println("	<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">-->");
    	out.println("    </head>");
    	out.println("    <body>");
    	if(req==1){
    	out.println("    <!--Req1// loop no choice-->");
    	out.println("        <h2>Requerimiento 1</h2>");
    	Iterator<Aeropuerto> iterador=instancia.consultarAeropuertos();
    	while(iterador.hasNext()){
    		Aeropuerto actual=iterador.next();
    		out.println("<h5>"+actual.toString()+"</h5>");
    	}
    	}
    	if(req==2){
    	out.println("        <h2>Requerimiento 2</h2>");
    	out.println("        <form action=\"resultadoPost.htm\" method=\"POST\">");
    	out.println("            <table>");
    	out.println("            <tr><td></td>Codigo del aeropuerto: <td><input type=\"text\" name=\"req2\"></td></tr>");
    	out.println("            <tr>");
    	out.println("                <td><input type=\"submit\"></td>");
    	out.println("            </tr>");
    	out.println("            </table>");
    	out.println("        </form>");
    	}
    	if(req==3){
    	out.println("    <!--Req3-->");
    	out.println("        <h2>Requerimiento 3</h2>");
    	}
    	if(req==4){
    	out.println("    <!--Req4-->  ");
    	out.println("        <h2>Requerimiento 4</h2>");
    	}
    	if(req==5){
    	out.println("    <!--Req5// loop no choice-->");
    	out.println("        <h2>Requerimiento 5</h2>");
    	}
    	if(req==6){
    	out.println("    <!--Req6// loop no choice-->");
    	out.println("        <h2>Requerimiento 6</h2>");
    	}
    	if(req==7){
    	out.println("    <!--Req7-->");
    	out.println("        <h2>Requerimiento 7</h2>");
    	out.println("        <form>");
    	out.println("            <table>");
    	out.println("            <tr><td></td>Codigo del aeropuerto: <td><input type=\"text\"></td></tr>");
    	out.println("            <tr><td></td>Fecha a consultar: <td><input type=\"date\"></td></tr>");
    	out.println("            <tr>");
    	out.println("            <td><input type=\"radio\" name=\"v\" value=\"Entrando\"></td>");
    	out.println("            <td><input type=\"radio\" name=\"v\" value=\"Saliendo\"></td>");
    	out.println("            </tr>");
    	out.println("            <tr><input type=\"submit\"></tr>");
    	out.println("            </table>");
    	out.println("        </form>");
    	}
    	if(req==8){
    	out.println("    <!--Req8-->");
    	out.println("        <h2>Requerimiento 8</h2>");
    	}
    	if(req==9){
    	out.println("    <!--Req9-->");
    	out.println("        <h2>Requerimiento 9</h2>");
    	}
    	if(req==10){
    	out.println("    <!--Req10-->");
    	out.println("        <h2>Requerimiento 10</h2>");
    	}
    	if(req==11){
    	out.println("    <!--Req11-->");
    	out.println("        <h2>Requerimiento 11</h2>");
    	}
    	out.println("    ");
    	out.println("    ");
    	out.println("    </body>");
    	out.println("    <footer>");
    	out.println("	<p class=\"InterfazGeneral\">Material producido por Nicolas y Daniel Production</p>");
    	out.println("    </footer>");
    	out.println("</html>");
    }
    
    
    

	public void req16(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

	public void req2(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

	public void req3(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

	public void req4(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

	public void req5(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

	public void req6(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

	public void req7(HttpServletResponse response) throws IOException {

	}

	public void req8(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

	public void req9(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

	public void req10(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

	public void req11(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
	}

    
    private void imprimirMensajeListo(HttpServletResponse response) throws IOException{
    	PrintWriter out = response.getWriter();
    	out.println("<!DOCTYPE html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("	<title>CupiFlights</title>");
    	out.println("	<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">-->");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h1 class=\"InterfazGeneral\">Listo</h1>");
    	out.println("</body>");
    	out.println("<footer>");
    	out.println("	<p class=\"InterfazGeneral\">Material producido por Nicolas y Daniel Production</p>");
    	out.println("</footer>");
    	out.println("</html>");

    }
    
    
    
    private void imprimirMensajeError(HttpServletResponse response) throws IOException{
    	PrintWriter out = response.getWriter();
    	out.println("<!DOCTYPE html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("	<title>CupiFlights</title>");
    	out.println("	<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">-->");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h1 class=\"InterfazGeneral\">Error</h1>");
    	out.println("            <a href=\"index.htm\">Back to home!</a>");
    	out.println("</body>");
    	out.println("<footer>");
    	out.println("	<p class=\"InterfazGeneral\">Material producido por Nicolas y Daniel Production</p>");
    	out.println("</footer>");
    	out.println("</html>");

  
    	
    }
    
    private void imprimirListo( HttpServletResponse response, String texto ) throws IOException{
    	
    	PrintWriter out = response.getWriter();
    	out.println("<!DOCTYPE html>");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("	<title>CupiFlights</title>");
    	out.println("	<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">-->");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<h1 class=\"InterfazGeneral\">CupiFlights</h1>");
    	out.println("    ");
    	out.println("    <h2>Listo, se agrego:</h2>");
    	out.println("    <h3>"+texto+"</h3>");
    	out.println("</body>");
    	out.println("    ");
    	out.println("<footer>");
    	out.println("	<p class=\"InterfazGeneral\">Material producido por Nicolas y Daniel Production</p>");
    	out.println("</footer>");
    	out.println("</html>");

    }
    
    
 
//    /**
//     * Imprime un mensaje de error
//     * @param respuesta Respuesta al cliente
//     * @param titulo T�tulo del error
//     * @param mensaje Mensaje del error
//     */
//    private void imprimirMensajeError( PrintWriter respuesta, String titulo, String mensaje )
//    {
//        respuesta.println( "                      <p class=\"error\"><b>Ha ocurrido un error!:<br>" );
//        respuesta.println( "                      </b>" + titulo + "</p><p>" + mensaje + ". </p>" );
//        respuesta.println( "                      <p>Intente la " );
//        respuesta.println( "                      operaci�n nuevamente. Si el problema persiste, contacte" );
//        respuesta.println( "                      al administrador del sistema.</p>" );
//    }
//
}
