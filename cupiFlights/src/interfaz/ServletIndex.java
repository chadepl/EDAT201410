package interfaz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mundo.CupiFlight;

@SuppressWarnings("serial")
public class ServletIndex  extends HttpServlet {
	
	private CupiFlight instancia;

	public void init(){
		System.out.println("Estoy en el INICIO");
		instancia = CupiFlight.getInstance();
	}
	
	public void destroy(){
		
	}
	
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        // Maneja el GET y el POST de la misma manera
		
		imprimirIndex(response);
    	
    }
	
	private void imprimirIndex(HttpServletResponse response) throws IOException{
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
		out.println("    <title>CupiFlights</title>");
		out.println("");
		out.println("    <!-- Bootstrap core CSS -->");
		out.println("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
		out.println("");
		out.println("    <!-- Custom styles for this template -->");
		out.println("    <link href=\"jumbotron.css\" rel=\"stylesheet\">");
		out.println("    ");
		out.println("  </head>");
		out.println("");
		out.println("  <body>");
		out.println("");
		out.println("    <div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">");
		out.println("      <div class=\"container\">");
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
		out.println("          <form class=\"navbar-form navbar-right\" role=\"form\" action=\"admi.html\" method=\"post\">");
		out.println("            <div class=\"form-group\">");
		out.println("              <input type=\"text\" placeholder=\"Usuario\" name=\"usuario\" class=\"form-control\">");
		out.println("            </div>");
		out.println("            <div class=\"form-group\">");
		out.println("              <input type=\"password\" placeholder=\"Contrase??a\" name=\"password\" class=\"form-control\">");
		out.println("            </div>");
		out.println("            <button type=\"submit\" class=\"btn btn-success\">Sign in</button>");
		out.println("          </form>");
		out.println("        </div><!--/.navbar-collapse -->");
		out.println("      </div>");
		out.println("    </div>");
		out.println("");
		out.println("    <!-- Main jumbotron for a primary marketing message or call to action -->");
		out.println("    <div class=\"jumbotron\">");
		out.println("      <div class=\"container\">");
		out.println("        <h1>CupiFlights</h1>");
		out.println("        <p>La mejor manera de consultar acerca de aeropuertos, vuelos, aerolineas, indicadores aereos y mas.</p>");
		out.println("        <p><a href=\"invit.html\" class=\"btn btn-primary btn-lg\" role=\"button\">Invitado!</a></p>");
		out.println("      </div>");
		out.println("    </div>");
		out.println("");
		out.println("    <div class=\"container\">");
		out.println("      <!-- Example row of columns -->");
		out.println("      <div class=\"row\">");
		out.println("        <div class=\"col-xs-6 col-md-6 placeholder\">");
		out.println("          <img src=\"nicolas.jpg\" class=\"img-responsive\" width=\"300\" height=\"300\">");
		out.println("          <h2>Nicolas</h2>");
		out.println("          <p>Trabajar en este proyecto ha sido bastante gratificante, ha sido una experiencia de aprendizaje completamente sorprendente. A medida que ha ido avanzando la materia el ritmo mejora y las capacidades se pulen. </p>");
		out.println("       </div>");
		out.println("        <div class=\"col-xs-6 col-md-6 placeholder\">");
		out.println("          <img src=\"daniel.jpg\" class=\"img-responsive\" width=\"300\" height=\"300\">");
		out.println("          <h2>Daniel</h2>");
		out.println("          <p>Trabajar en este proyecto ha sido bastante gratificante, ha sido una experiencia de aprendizaje completamente sorprendente. A medida que ha ido avanzando la materia el ritmo mejora y las capacidades se pulen.</p>");
		out.println("        </div>");
		out.println("      </div>");
		out.println("");
		out.println("      <hr>");
		out.println("");
		out.println("      <footer>");
		out.println("        <p>&copy; Daniel & Nicolas Productions 2014</p>");
		out.println("      </footer>");
		out.println("    </div> <!-- /container -->");
		out.println("");
		out.println("");
		out.println("    <!-- Bootstrap core JavaScript");
		out.println("    ================================================== -->");
		out.println("    <!-- Placed at the end of the document so the pages load faster -->");
		out.println("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>");
		out.println("    <script src=\"js/bootstrap.min.js\"></script>");
		out.println("  </body>");
		out.println("</html>");

		

	}
	
	public void imprimirme(HttpServletResponse response) throws IOException{
		imprimirIndex(response);
	}
	
}
