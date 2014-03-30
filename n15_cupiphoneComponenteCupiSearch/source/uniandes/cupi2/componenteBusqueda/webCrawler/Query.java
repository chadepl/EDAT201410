package uniandes.cupi2.componenteBusqueda.webCrawler;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lista.Elemento;
import lista.Lista;


public class Query implements Comparable<Query>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date time;
	
	private Lista<Resource> resources;
	
	private int depth;
	
	private final static long TIEMPOM=3000;
	
	/**
	 * 
	 * @param sources
	 * @param nDepth
	 */
	public Query(String[] sources,int nDepth) throws Exception{
		depth=nDepth;
		resources=new Lista<Resource>();
		explorarRecursivo2(crearListaRecursos(sources),nDepth*1000,0);
		//explorarRecursivo(sources, nDepth*1000, 0);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		setTime(date);
		
	}
	
	

	private void explorarRecursivo2(Lista<String> indice, int limite,
			int transcurrido) {
		// TODO Auto-generated method stub
		try{
		long start=System.currentTimeMillis();
		String s=indice.eliminar(0);
		Document doc=Jsoup.connect(s).get();
		Elements es=doc.getAllElements();
		for(Element e:es){
			if(e.tagName().equals("img")){
				Resource recurso=null;
				if(e.attr("src").startsWith("http://") || e.attr("src").startsWith("https://"))
				recurso=new Resource(s, "img", e.attr("src"));
				else if(e.attr("src").startsWith("//"))
				recurso=new Resource(s, "img", "http:"+e.attr("src"));
				else
				recurso=new Resource(s, "img", "http:/"+e.attr("src"));
				resources.agregar(recurso);
				System.out.println(recurso.toString());
			}
			if(e.tagName().equals("a")){
				Resource recurso=new Resource(s, "a", e.attr("href"));
				resources.agregar(recurso);
				indice.agregar(recurso.getUrl());
				System.out.println(recurso.toString());
				
			}
			if(e.tagName().matches("h[1-7]")){
				Resource recurso=new Resource(s, e.tagName() , e.text());
				resources.agregar(recurso);
				System.out.println(recurso.toString());
			}
			
			long terminar=System.currentTimeMillis();
			transcurrido+=terminar-start;
			System.out.println(transcurrido);
			if(transcurrido<=limite)
				explorarRecursivo2(indice, limite, transcurrido);
			
		
		}
		}catch(Exception e){
			
		}
		
	}



	private Lista<String> crearListaRecursos(String[] sources) {
		// TODO Auto-generated method stub
		Lista<String> indice=new Lista<String>();
		for(int i=0;i<sources.length;i++){
			indice.agregar(sources[i]);
		}
		return indice;
		
	}



	public void explorarRecursivo(String[] sources,int limite,int transcurrido){
		Lista<String> links=new Lista<String>();
		long start=System.currentTimeMillis();
		try{
		for(String s: sources){
		long start1=System.currentTimeMillis();
		Document doc=Jsoup.connect(s).get();
		Elements es=doc.getAllElements();
		for(Element e:es){
			if(e.tagName().equals("img")){
				Resource recurso=null;
				if(e.attr("src").startsWith("http://") || e.attr("src").startsWith("https://"))
				recurso=new Resource(s, "img", e.attr("src"));
				else if(e.attr("src").startsWith("//"))
				recurso=new Resource(s, "img", "http:"+e.attr("src"));
				else
				recurso=new Resource(s, "img", "http:/"+e.attr("src"));
				resources.agregar(recurso);
				System.out.println(recurso.toString());
			}
			if(e.tagName().equals("a")){
				Resource recurso=new Resource(s, "a", e.attr("href"));
				resources.agregar(recurso);
				links.agregar(recurso.getUrl());
				System.out.println(recurso.toString());
				
			}
			if(e.tagName().matches("h[1-7]")){
				Resource recurso=new Resource(s, e.tagName() , e.text());
				resources.agregar(recurso);
				System.out.println(recurso.toString());
			}
			
			long terminar=System.currentTimeMillis();
			transcurrido+=terminar-start1;
			System.out.println(transcurrido);
			
		}
		}
		long terminar=System.currentTimeMillis();
		transcurrido+=terminar-start;
		System.out.println(transcurrido);
		if(transcurrido<=limite)
		explorarRecursivo(darArreglo(links),limite,transcurrido);
		}catch(Exception e){
			
		}
		
		
	}
	
	
	private String[] darArreglo(Lista<String> cadena){
		Elemento[] ellos=cadena.darArreglo();
		String[] elementos=new String[ellos.length];
		int i=0;
		for(Elemento e:ellos){
			elementos[i]=(String) e.getElemento();
			i++;
		}
		return elementos;
		
	}
	
	
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Lista<Resource> getResources() {
		return resources;
	}

	public void setResources(Lista<Resource> resources) {
		this.resources = resources;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		
		return time+" //Profundidad: "+depth+" Numero de Recursos: "+resources.darArreglo().length;
	}

	@Override
	public int compareTo(Query o) {
		if(time.compareTo(time)>0)
			return 1;
		else 
			return -1;
	}

}
