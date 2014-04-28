package interfaz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mundo.CupiFlight;

@SuppressWarnings("serial")
public class ServletFechas extends HttpServlet {
	
		private CupiFlight instancia;
		
		public void init(){
			System.out.println("Estoy en FECHAS");
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
			
			imprimirFechas(response);

			
		}
		
		private void imprimirFechas(HttpServletResponse response) throws IOException{
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
			out.println("    <title>Fechas</title>");
			out.println("");
			out.println("    <!-- Bootstrap core CSS -->");
			out.println("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
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
			out.println("            <li  class=\"active\"><a href=\"fechas.html\">Fechas</a></li>");
			out.println("            <li><a href=\"consultas.html\">Consultas</a></li>");
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
			out.println("          <h2 class=\"sub-header\">Fechas</h2>");
			out.println("          <div class=\"table-responsive\">");
			out.println("            <table class=\"table table-striped\">");
			out.println("              <thead>");
			out.println("                <tr>");
			out.println("                  <th>#</th>");
			out.println("                  <th>Fecha</th>");
			out.println("                </tr>");
			out.println("              </thead>");
			out.println("              <tbody>");
			out.println("                <tr>");
			out.println("                  <td>1,001</td>");
			out.println("                  <td>Lorem</td>");
			out.println("                </tr>");
			out.println("              </tbody>");
			out.println("            </table>");
			out.println("          </div>");
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
