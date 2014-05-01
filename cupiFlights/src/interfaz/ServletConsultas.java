package interfaz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mundo.Aerolinea;
import mundo.Aeropuerto;
import mundo.CupiFlight;
import mundo.Vuelo;

@SuppressWarnings("serial")
public class ServletConsultas extends HttpServlet{

		private int requerimiento;
		
		private CupiFlight instancia;
	
		public void init(){
			requerimiento = -1;
			System.out.println("Estoy en CONSULTAS");
			instancia = CupiFlight.getInstance();
		}
		
		public void destroy(){
			
		}
		
		protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	    {
	        // Maneja el GET y el POST de la misma manera
	    
	    	
	    }
		
		protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	    {
	        // Maneja el GET y el POST de la misma manera
			procesarSolicitud(request, response);
	    	
	    }
		
		private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response) throws IOException{
			
			if(request.getParameter("codReq7")!=null && request.getParameter("fec1Req7")!=null){
			
				//Aca va lo que se hace en el requerimiento
				requerimiento = 7;
			} 
			if(request.getParameter("codReq8")!=null && request.getParameter("fec1Req8")!=null && request.getParameter("fec2Req8")!=null){
				//Aca va lo que se hace en el requerimiento
				
				requerimiento = 8;
			}
			if(request.getParameter("fec1Req9")!=null && request.getParameter("fec2Req9")!=null){
				//Aca va lo que se hace en el requerimiento
				
				requerimiento = 9;
			}
			if(request.getParameter("fec1Req10")!=null && request.getParameter("fec2Req10")!=null){
				//Aca va lo que se hace en el requerimiento
			
				requerimiento = 10;
			}
			
			imprimirAcciones(requerimiento,request, response);


			
		}
		
		private void imprimirAcciones(int req,HttpServletRequest request, HttpServletResponse response) throws IOException{
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"en\">");
			out.println("  <head>");
			out.println("    <meta charset=\"utf-8\">");
			out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
			out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.println("    <meta name=\"description\" content=\"\">");
			out.println("    <meta name=\"author\" content=\"\">");
			out.println("    <link rel=\"shortcut icon\" href=\"../../assets/ico/favicon.ico\">");
			out.println("");
			out.println("    <title>Consultas</title>");
			out.println("");
			out.println("    <!-- Bootstrap core CSS -->");
			out.println("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
			out.println("");
			out.println("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/datepicker.css\">");
			out.println("");
			out.println("    <!-- Custom styles for this template -->");
			out.println("    <link href=\"css/dashboard.css\" rel=\"stylesheet\">");
			out.println("");
			out.println("  </head>");
			out.println("");
			out.println("  <body>");
			out.println("");
			out.println("   <div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">");
			out.println("      <div class=\"container-fluid\">");
			out.println("        <div class=\"navbar-header\">");
			out.println("          <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">");
			out.println("            <span class=\"sr-only\">Toggle navigation</span>");
			out.println("            <span class=\"icon-bar\"></span>");
			out.println("            <span class=\"icon-bar\"></span>");
			out.println("            <span class=\"icon-bar\"></span>");
			out.println("          </button>");
			out.println("          <a class=\"navbar-brand\" href=\"#\">Nivel 16</a>");
			out.println("        </div>");
			out.println("        <div class=\"navbar-collapse collapse\">");
			out.println("          <ul class=\"nav navbar-nav navbar-right\">");
			out.println("            <li><a href=\"index.html\">Principal</a></li>");
			out.println("            <li><a href=\"invit.html\">Invitado</a></li>");
			out.println("            <li><a href=\"#\">Help</a></li>");
			out.println("          </ul>");
			out.println("        </div>");
			out.println("      </div>");
			out.println("    </div>");
			out.println("");
			out.println("    <div class=\"container-fluid\">");
			out.println("      <div class=\"row\">");
			out.println("        <div class=\"col-sm-3 col-md-2 sidebar\">");
			out.println("          <ul class=\"nav nav-sidebar\">");
			out.println("            <li><a href=\"invit.html\">Aeropuertos</a></li>");
			out.println("            <li><a href=\"fechas.html\">Fechas</a></li>");
			out.println("            <li  class=\"active\"><a href=\"consultas.html\">Consultas</a></li>");
			out.println("            <li><a href=\"mapas.html\">Mapa</a></li>");
			out.println("          </ul>");
			out.println("        </div>");
			out.println("        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">");
			out.println("          <h1 class=\"page-header\">Invitados</h1>");
			out.println("");
			out.println("          <div class=\"row placeholders\">");
			out.println("            <div class=\"col-xs-6 col-md-12 placeholder\">");
			out.println("              <img src=\"air.png\" class=\"img-responsive\" alt=\"Generic placeholder thumbnail\" width=\"200\" height=\"200\">");
			out.println("              <h4>El Mas Importante</h4>");
			out.println("              <span class=\"text-muted\">Invitado</span>");
			out.println("            </div>");
			out.println("          </div>");
			out.println("");
			out.println("          <h2 class=\"sub-header\">Consultas</h2>");
			out.println("");
			out.println("          <!--Requerimiento 7, vuelos por aeropuerto-->");
			out.println("");
			out.println("          <h3 class=\"sub-header\">Consulta de Vuelos Por Aeropuerto</h3>");
			out.println("");
			out.println("            <form class=\"form-inline\" role=\"form\" method=\"get\" action=\"consultas.html\">");
			out.println("              <div class=\"form-group\">");
			out.println("                <input type=\"text\" class=\"form-control\" name=\"codReq7\" placeholder=\"Codigo del Aeropuerto\">");
			out.println("                <input type=\"text\" class=\"form-control\" name=\"fec1Req7\" placeholder=\"mm/dd/aa\">");
			out.println("                 <select class=\"form-control\" name=\"tiposDeVuelos\">");
			out.println("                    <option>Saliendo</option>");
			out.println("                    <option>Entrando</option>");
			out.println("                  </select>");
			out.println("                <input type=\"submit\" class=\"btn btn-success\" value=\"Enviar!\">");
			out.println("                <a href=\"http://www.nationsonline.org/oneworld/IATA_Codes/airport_code_list.htm\" class=\"btn btn-default\">Codigos de Aeropuertos</a>");
			out.println("              </div>");
			out.println("            </form>");
			out.println("");
			
			if(req==7){
				String cod7=request.getParameter("codReq7");
				String[] fecha=request.getParameter("fec1Req7").split("/");
				Date date = new Date(Integer.parseInt(fecha[2]),Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]));
				String status=request.getParameter("tiposDeVuelos");
				Iterator<Vuelo> iterador = instancia.consultarVuelos(cod7, date, status, status);
			out.println("            <!--Respuesta a partir de aqui-->");
			out.println("            <p></p>");
			out.println("            <div class=\"container well\">");
			out.println("              <div class=\"table-responsive\">");
			out.println("            <table class=\"table table-striped\">");
			out.println("              <thead>");
			out.println("                <tr>");
			out.println("                  <th>Codigo</th>");
			out.println("                  <th>Origen</th>");
			out.println("                  <th>Destino</th>");
			out.println("                  <th>Aerolinea</th>");
			out.println("                </tr>");
			out.println("              </thead>");
			out.println("              <tbody>");
			int i=0;
	    	while(iterador.hasNext()){
	    		Vuelo actual=iterador.next();
	    		i++;
			out.println("                <tr>");
			out.println("                  <td>"+actual.codigo+"</td>");
			out.println("                  <td>+"+actual.darOrigen()+"+</td>");
			out.println("                  <td>"+actual.darDestino()+"</td>");
			out.println("                  <td>"+actual.aerolinea+"</td>");
			out.println("                </tr>");
	    	}
			out.println("              </tbody>");
			out.println("            </table>");
			out.println("          </div>");
			out.println("        </div>");
			out.println("        <p></p>");
			out.println("");
			requerimiento=-1;
			}
			
			out.println("            <!--Requerimiento 8, estadisticas por aeropuerto-->");
			out.println("");
			out.println("          <h3 class=\"sub-header\">Estadisticas Aeropuerto</h3>");
			out.println("");
			out.println("             <form class=\"form-inline\" role=\"form\" method=\"get\" action=\"consultas.html\">");
			out.println("              <div class=\"form-group\">");
			out.println("                <input type=\"text\" class=\"form-control\" name=\"codReq8\" placeholder=\"Codigo del Aeropuerto\">");
			out.println("                <input type=\"text\" class=\"form-control\" name=\"fec1Req8\" placeholder=\"mm/dd/aa\">");
			out.println("                <input type=\"text\" class=\"form-control\" name=\"fec2Req8\" placeholder=\"mm/dd/aa\">");
			out.println("              </div>");
			out.println("              <input type=\"submit\" class=\"btn btn-success\" value=\"Enviar!\">");
			out.println("              <a href=\"http://www.nationsonline.org/oneworld/IATA_Codes/airport_code_list.htm\" class=\"btn btn-default\">Codigos de Aeropuertos</a>");
			out.println("            </form>");
			out.println("");
			
			if(req==8){
						String cod=request.getParameter("codReq8");
						String[] fecha1=request.getParameter("fec1Req8").split("/");
						Date date1 = new Date(Integer.parseInt(fecha1[2]),Integer.parseInt(fecha1[0]),Integer.parseInt(fecha1[1]));
						String[] fecha2=request.getParameter("fec2Req8").split("/");
						Date date2 = new Date(Integer.parseInt(fecha2[2]),Integer.parseInt(fecha2[0]),Integer.parseInt(fecha2[1]));
						Iterator<Vuelo> iterador = instancia.consultarVuelosATiempo(date1, date2);
			out.println("            <!--Respuesta a partir de aqui-->");
			out.println("            <p></p>");
			out.println("            <div class=\"container well\">");
			out.println("              <div class=\"table-responsive\">");
			out.println("            <table class=\"table table-striped\">");
			out.println("              <thead>");
			out.println("                <tr>");
			out.println("                  <th>Aeropuerto</th>");
			out.println("                  <th>Codigo</th>");
			out.println("                  <th>Cancelados</th>");
			out.println("                  <th>A Tiempo</th>");
			out.println("                  <th>Mas de 15</th>");
			out.println("                  <th>Mas de 30</th>");
			out.println("                  <th>Mas de 45</th>");
			out.println("                </tr>");
			out.println("              </thead>");
			out.println("              <tbody>");
			out.println("                <tr>");
			while(iterador.hasNext()){
			Vuelo actual = iterador.next();
			out.println("                  <td>"+actual.darOrigen()+"</td>");
			out.println("                  <td>"+actual.codigo+"</td>");
			out.println("                  <td>"+actual.darCancelados()+"</td>");
			out.println("                  <td>"+actual.darOntime()+"</td>");
			out.println("                  <td>"+actual.darLate15()+"</td>");
			out.println("                  <td>"+actual.darLate30()+"</td>");
			out.println("                  <td>"+actual.darLate45()+"</td>");
			out.println("                </tr>");
			}
			out.println("              </tbody>");
			out.println("            </table>");
			out.println("          </div>");
			out.println("        </div>");
			out.println("        <p></p>");
			out.println("");
			requerimiento=-1;
			}
			
			out.println("        <!--Requerimiento 9, vuelos segun calificacion dada-->");
			out.println("");
			out.println("          <h3 class=\"sub-header\">Vuelos por Calificacion</h3>");
			out.println("");
			out.println("             <form class=\"form-inline\" role=\"form\" method=\"get\" action=\"consultas.html\">");
			out.println("              <div class=\"form-group\">");
			out.println("                  <select class=\"form-control\" name=\"puntuarAirp\">");
			out.println("                    <option>1</option>");
			out.println("                    <option>2</option>");
			out.println("                    <option>3</option>");
			out.println("                    <option>4</option>");
			out.println("                    <option>5</option>");
			out.println("                  </select>");
			out.println("                    <input type=\"text\" class=\"form-control\" name=\"fec1Req9\" placeholder=\"mm/dd/aa\">");
			out.println("                    <input type=\"text\" class=\"form-control\" name=\"fec2Req9\" placeholder=\"mm/dd/aa\">");
			out.println("              </div>");
			out.println("              <input type=\"submit\" class=\"btn btn-success\" value=\"Enviar!\">");
			out.println("              <a href=\"http://www.nationsonline.org/oneworld/IATA_Codes/airport_code_list.htm\" class=\"btn btn-default\">Codigos de Aeropuertos</a>");
			out.println("            </form>");
			out.println("");
			
			if(req==9){
				int puntuacion = Integer.parseInt(request.getParameter("puntuarAirp"));
				Iterator<Vuelo> iterador=instancia.buscarVuelosRangoCalificacion(puntuacion);
			out.println("            <!--Respuesta a partir de aqui-->");
			out.println("            <p></p>");
			out.println("            <div class=\"container well\">");
			out.println("              <div class=\"table-responsive\">");
			out.println("            <table class=\"table table-striped\">");
			out.println("              <thead>");
			out.println("                <tr>");
			out.println("                  <th>Codigo</th>");
			out.println("                  <th>Origen</th>");
			out.println("                  <th>Destino</th>");
			out.println("                  <th>Atraso</th>");
			out.println("                  <th>Aerolinea</th>");
			out.println("                  <th>Puntaje</th>");
			out.println("                </tr>");
			out.println("              </thead>");
			out.println("              <tbody>");
			while(iterador.hasNext()){
			Vuelo actual = iterador.next();
			out.println("                <tr>");
			out.println("                  <td>"+actual.codigo+"</td>");
			out.println("                  <td>"+actual.darOrigen()+"</td>");
			out.println("                  <td>"+actual.darDestino()+"</td>");
			out.println("                  <td>"+actual.darCancelados()+"</td>");
			out.println("                  <td>"+actual.aerolinea+"</td>");
			out.println("                  <td>"+actual.darCalificacion()+"</td>");
			out.println("                </tr>");
			}
			out.println("              </tbody>");
			out.println("            </table>");
			out.println("          </div>");
			out.println("        </div>");
			out.println("        <p></p>");
			out.println("");
			requerimiento=-1;
			}
			
			out.println("            <!--Requerimiento 10, se ven las estadisticas de las aerolineas-->");
			out.println("");
			out.println("            <h3 class=\"sub-header\">Estadisticas Aerolineas</h3>");
			out.println("");
			out.println("             <form class=\"form-inline\" role=\"form\" method=\"get\" action=\"consultas.html\">");
			out.println("              <div class=\"form-group\">");
			out.println("                   <input type=\"text\" class=\"form-control\" name=\"fec1Req10\" placeholder=\"mm/dd/aa\">");
			out.println("                    <input type=\"text\" class=\"form-control\" name=\"fec2Req10\" placeholder=\"mm/dd/aa\">");
			out.println("              </div>");
			out.println("              <input type=\"submit\" class=\"btn btn-success\" value=\"Enviar!\">");
			out.println("              <a href=\"http://www.nationsonline.org/oneworld/IATA_Codes/airport_code_list.htm\" class=\"btn btn-default\">Codigos de Aeropuertos</a>");
			out.println("            </form>");
			out.println("");
			
			if(req==10){
				Iterator<Aerolinea> iterador1=instancia.consultarAerolineasMasVuelosRetrasados();
				Iterator<Aerolinea> iterador2=instancia.consultarAerolineasMasVuelosRetrasados();
			out.println("            <!--Respuesta a partir de aqui-->");
			out.println("            <p></p>");
			out.println("            <div class=\"container well\">");
			out.println("              <div class=\"table-responsive\">");
			out.println("            <table class=\"table table-striped\">");
			out.println("              <thead>");
			out.println("                <tr>");
			out.println("                  <th>#</th>");
			out.println("                  <th>Codigo</th>");
			out.println("                  <th>Nombre</th>");
			out.println("                  <th>Vuelos</th>");
			out.println("                </tr>");
			out.println("              </thead>");
			out.println("              <tbody>");
			int i=0;
			while(iterador1.hasNext()){
				i++;
				Aerolinea actual1=iterador1.next();
			out.println("                <tr>");
			out.println("                  <td>"+i+"</td>");
			out.println("                  <td>"+actual1.darCodigo()+"</td>");
			out.println("                  <td>"+actual1.darNombre()+"</td>");
			out.println("                  <td>"+actual1.darCantidadVuelosRetrasados()+"</td>");
			out.println("                </tr>");
			}
			out.println("              </tbody>");
			out.println("            </table>");
			out.println("          </div>");
			out.println("        </div>");
			out.println("        <p></p>");
			out.println("          <div class=\"container well\">");
			out.println("              <div class=\"table-responsive\">");
			out.println("            <table class=\"table table-striped\">");
			out.println("              <thead>");
			out.println("                <tr>");
			out.println("                  <th>#</th>");
			out.println("                  <th>Codigo</th>");
			out.println("                  <th>Nombre</th>");
			out.println("                  <th>Ciudad</th>");
			out.println("                  <th>Pais</th>");
			out.println("                  <th>Puntuaci??n</th>");
			out.println("                </tr>");
			out.println("              </thead>");
			out.println("              <tbody>");
			int j=0;
			while(iterador2.hasNext()){
				j++;
				Aerolinea actual2=iterador2.next();
			out.println("                <tr>");
			out.println("                  <td>"+j+"</td>");
			out.println("                  <td>"+actual2.darCodigo()+"</td>");
			out.println("                  <td>"+actual2.darNombre()+"</td>");
			out.println("                  <td>"+actual2.darCantidadVuelosRetrasados()+"</td>");
			out.println("                </tr>");
			}
			out.println("              </tbody>");
			out.println("            </table>");
			out.println("          </div>");
			out.println("        </div>");
			out.println("");
			out.println("        <!--Termina respuesta-->");
			requerimiento=-1;
			}
			
			out.println("");
			out.println("             ");
			out.println("        </div>");
			out.println("      </div>");
			out.println("    </div>");
			out.println("");
			out.println("    <!-- Bootstrap core JavaScript");
			out.println("    ================================================== -->");
			out.println("    <!-- Placed at the end of the document so the pages load faster -->");
			out.println("    <script type=\"text/javascript\" src=\"js/jquery-2.1.0.min.js\"></script>");
			out.println("    <script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>");
			out.println("    <script type=\"text/javascript\" src=\"js/docs.min.js\"></script>");
			out.println("    <script type=\"text/javascript\" src=\"js/bootstrap.js\"></script>");
			out.println("    <script type=\"text/javascript\" src=\"js/bootstrap-datepicker.js\"></script>");
			out.println("  </body>");
			out.println("</html>");
			
		}
		
		@SuppressWarnings("deprecation")
		private Date procesarFecha(String fecha){
			String[] arreglo=fecha.split("/"); 
			int[] numeros = new int[3];
			for(int i=0;i<arreglo.length;i++){
				numeros[i] = Integer.parseInt(arreglo[i]);
			}
			return new Date(numeros[2], numeros[0], numeros[1]);
		}




}
