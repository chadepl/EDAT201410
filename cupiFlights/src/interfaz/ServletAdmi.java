package interfaz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mundo.Aeropuerto;
import mundo.CupiFlight;

@SuppressWarnings("serial")
public class ServletAdmi extends HttpServlet {
	
	private ServletIndex indice;
	
	private String admiActual;
	
	private CupiFlight instancia;
	
	public void init(){
		
		instancia = CupiFlight.getInstance();
		
		System.out.println("Estoy en el ADMINISTRADOR");
	}
	
	public void destroy(){
		
	}
	
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        procesarSolicitud(request, response);
    
    	
    }
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        imprimirAdmi(response);
    
    	
    }
	
	private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response) throws IOException{
		if(request.getParameter("usuario")!=null && request.getParameter("password")!=null){
			String usuario = request.getParameter("usuario");
			String contrasenia = request.getParameter("password");
			if(usuario.equals("nf.chaves10") && contrasenia.equals("sexy")){
				admiActual = "nicolas.jpg";
				imprimirAdmi(response);
			}else if(usuario.equals("df.vargas10") && contrasenia.equals("crack")){
				admiActual = "daniel.jpg";
				imprimirAdmi(response);
			}else{
				indice.imprimirme(response);
			}
		}else{
			indice.imprimirme(response);
		}
	}
	
	private void imprimirAdmi(HttpServletResponse response) throws IOException{
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
		out.println("            <li class=\"active\"><a href=\"admi.html\">Principal</a></li>");
		out.println("            <li><a href=\"acciones.html\">Acciones</a></li>");
		out.println("          </ul>");
		out.println("        </div>");
		out.println("        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">");
		out.println("          <h1 class=\"page-header\">Administradores</h1>");
		out.println("");
		out.println("          <div class=\"row placeholders\">");
		out.println("            <div class=\"col-xs-6 col-md-12 placeholder\">");
		out.println("              <img src=\""+admiActual+"\" class=\"img-responsive\" alt=\"Generic placeholder thumbnail\" width=\"200\" height=\"200\">");
		//String admi=admiActual.equals("nicolas.jpg")?"Nicolas":"Daniel";
		out.println("              <h4>Nicolas</h4>");
		out.println("              <span class=\"text-muted\">Co-Founder</span>");
		out.println("            </div>");
		out.println("          </div>");
		out.println("");
		out.println("          <h2 class=\"sub-header\">Informacion Cargada</h2>");
		out.println("          <div class=\"table-responsive\">");
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
		Iterator<Aeropuerto> iterador=instancia.consultarAeropuertos();
		int i=0;
    	while(iterador.hasNext()){
    		Aeropuerto actual=iterador.next();
    		i++;
    		out.println("                <tr>");
    		out.println("                  <td>"+i+"</td>");
    		out.println("                  <td>"+actual.codigo+"</td>");
    		out.println("                  <td><a href=\"aeropuertos.html?cod="+actual.codigo+"\">"+actual.nombre+"</td>");
    		out.println("                  <td>"+actual.ciudad+"</td>");
    		out.println("                  <td>"+actual.pais+"</td>");
    		out.println("                  <td>"+actual.calificacion+"</td>");
    		out.println("                </tr>");
    	}
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
