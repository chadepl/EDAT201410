package interfaz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mundo.CupiFlight;

@SuppressWarnings("serial")
public class ServletAcciones extends HttpServlet{
	
	private int requerimiento;
	
	private CupiFlight instancia;

	public void init(){
		requerimiento = -1;
		System.out.println("Estoy en el INVITADO");
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
		
		if(request.getParameter("agregarAirp")!=null){
			String agregar = request.getParameter("agregarAirp");
			//Aca va lo que se hace en el requerimiento
			requerimiento = 1;
		} 
		if(request.getParameter("eliminarAirp")!=null){
			//Aca va lo que se hace en el requerimiento
			String eliminar = request.getParameter("eliminarAirp");
			requerimiento = 2;
		}
		if(request.getParameter("puntuar")!=null){
			//Aca va lo que se hace en el requerimiento
			String air = request.getParameter("puntuar");
			int puntuacion = Integer.parseInt(request.getParameter("puntuarAirp"));
			requerimiento = 3;
		}
		
		imprimirAcciones(requerimiento, response);
	}
	
	private void imprimirAcciones(int req,HttpServletResponse response) throws IOException{
		
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
		out.println("    <title>Administrador</title>");
		out.println("");
		out.println("");
		out.println("");
		out.println("    <!-- Bootstrap core CSS -->");
		out.println("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.println("");
		out.println("    <!-- Custom styles for this template -->");
		out.println("    <link href=\"css/dashboard.css\" rel=\"stylesheet\">");
		out.println("");
		out.println("    ");
		out.println("  </head>");
		out.println("");
		out.println("  <body>");
		out.println("");
		out.println("    <div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">");
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
		out.println("            <li><a href=\"#\">Principal</a></li>");
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
		out.println("            <li><a href=\"admi.html\">Principal</a></li>");
		out.println("            <li class=\"active\"><a href=\"acciones.html\">Acciones</a></li>");
		out.println("          </ul>");
		out.println("        </div>");
		out.println("        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">");
		out.println("          <h1 class=\"page-header\">Administradores</h1>");
		out.println("");
		out.println("          <div class=\"row placeholders\">");
		out.println("            <div class=\"col-xs-6 col-md-12 placeholder\">");
		out.println("              <img src=\"avion.jpg\" class=\"img-responsive\" alt=\"Generic placeholder thumbnail\" width=\"200\" height=\"200\">");
		out.println("              <h4>Nicolas Chaves de Plaza</h4>");
		out.println("              <span class=\"text-muted\">Co-Founder</span>");
		out.println("            </div>");
		out.println("          </div>");
		out.println("");
		out.println("          <h2 class=\"sub-header\">Acciones de Administrador</h2>");
		out.println("          <h3 class=\"sub-header\">Agregar Aeropuerto</h3>");
		out.println("");
		out.println("            <form class=\"form-inline\" role=\"form\" method=\"get\" action=\"acciones.html\">");
		out.println("              <div class=\"form-group\">");
		out.println("                <input type=\"text\" class=\"form-control\" name=\"agregarAirp\" placeholder=\"Codigo del Aeropuerto\">");
		out.println("              </div>");
		out.println("              <input type=\"submit\" class=\"btn btn-success\" value=\"Agregar\">");
		out.println("              <a href=\"http://www.nationsonline.org/oneworld/IATA_Codes/airport_code_list.htm\" class=\"btn btn-default\">Codigos de Aeropuertos</a>");
		out.println("            </form>");
		out.println("");
		if(req==1){
		out.println("            <!--Respuesta-->");
		out.println("            <p></p>");
		out.println("            <div class=\"container well\">");
		out.println("            <label>Se ha agregado:</label>");
		out.println("            </div>");
		out.println("");
		requerimiento=-1;
		}
		out.println("          <h3 class=\"sub-header\">Eliminar Aeropuerto</h3>");
		out.println("");
		out.println("             <form class=\"form-inline\" role=\"form\" method=\"get\" action=\"acciones.html\">");
		out.println("              <div class=\"form-group\">");
		out.println("                <input type=\"text\" class=\"form-control\" name=\"eliminarAirp\" placeholder=\"Codigo del Aeropuerto\">");
		out.println("              </div>");
		out.println("              <input type=\"submit\" class=\"btn btn-danger\" value=\"Eliminar\">");
		out.println("              <a href=\"http://www.nationsonline.org/oneworld/IATA_Codes/airport_code_list.htm\" class=\"btn btn-default\">Codigos de Aeropuertos</a>");
		out.println("            </form>");
		out.println("");
		if(req==2){
		out.println("            <!--Respuesta-->");
		out.println("            <p></p>");
		out.println("            <div class=\"container well\">");
		out.println("            <label>Se ha eliminado:</label>");
		out.println("            </div>");
		out.println("");
		requerimiento=-1;
		}
		out.println("          <h3 class=\"sub-header\">Puntuar</h3>");
		out.println("");
		out.println("             <form class=\"form-inline\" role=\"form\" method=\"get\" action=\"acciones.html\">");
		out.println("              <div class=\"form-group\">");
		out.println("                   <input type=\"text\" class=\"form-control\" name=\"puntuacion\" placeholder=\"Codigo del Aeropuerto\">");
		out.println("                  <select class=\"form-control\" name=\"puntuarAirp\">");
		out.println("                    <option>1</option>");
		out.println("                    <option>2</option>");
		out.println("                    <option>3</option>");
		out.println("                    <option>4</option>");
		out.println("                    <option>5</option>");
		out.println("                  </select>");
		out.println("              </div>");
		out.println("              <input type=\"submit\" class=\"btn btn-success\" value=\"Puntuar!\">");
		out.println("              <a href=\"http://www.nationsonline.org/oneworld/IATA_Codes/airport_code_list.htm\" class=\"btn btn-default\">Codigos de Aeropuertos</a>");
		out.println("            </form>");
		out.println("");
		if(req==3){
		out.println("            <!--Respuesta-->");
		out.println("            <p></p>");
		out.println("            <div class=\"container well\">");
		out.println("            <label>Se ha puntuado:</label>");
		out.println("            </div>");
		out.println("");
		requerimiento=-1;
		}
		out.println("             ");
		out.println("");
		out.println("");
		out.println("        </div>");
		out.println("      </div>");
		out.println("    </div>");
		out.println("");
		out.println("    <!-- Bootstrap core JavaScript");
		out.println("    ================================================== -->");
		out.println("    <!-- Placed at the end of the document so the pages load faster -->");
		out.println("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>");
		out.println("    <script src=\"js/bootstrap.min.js\"></script>");
		out.println("    <script src=\"js/docs.min.js\"></script>");
		out.println("  </body>");
		out.println("</html>");

	}

}
