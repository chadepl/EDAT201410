package uniandes.cupi2.componenteBusqueda.webCrawler;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Prueba {
	
	private static Engine motor;
	
	public static void main(String[] args){
		
		

		try{
		Engine motor=new Engine();
		String[] sources={"http://en.wikipedia.org/wiki/Main_Page","http://www.piccsy.com/","http://www.deviantart.com/"};
		//String[] sources={"http://www.piccsy.com/"};
//		Query busqueda=motor.explore(sources, 1);
		Query busqueda=motor.explore(sources, 7);
		System.out.println("");
		

		System.out.println("NO RECURSOS: "+busqueda.getResources().darLongitud());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
