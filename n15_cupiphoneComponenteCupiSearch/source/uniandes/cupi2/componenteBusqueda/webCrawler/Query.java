package uniandes.cupi2.componenteBusqueda.webCrawler;
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


public class Query implements Comparable<Query>{
	
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
		//explore(sources, nDepth);
		explorarRecursivo(sources, nDepth*1000, 0);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		setTime(date);
		
	}
	
	
	public void explore(String[] sources, int depth) throws Exception{
		for(int i=0;i<sources.length;i++){
		try{
		Document doc=Jsoup.connect(sources[i]).get();
		Elements el=doc.select("h[1-7]");
		Elements el1=doc.select("img");
		Elements el2=doc.select("a");
		Elements el4=doc.select("title");
		for(Element actual:el){
			String thingt=actual.text();
			System.out.println("h2: "+thingt);
			resources.agregar(new Resource(sources[i], "h2", thingt));
		}
		for(Element actual:el1){
			String thingt=actual.attr("src");
			System.out.println("img: "+thingt);
			resources.agregar(new Resource(sources[i], "img", thingt));
		}
		for(Element actual:el2){
			String thingt=actual.attr("href");
			System.out.println("a: "+thingt);
			resources.agregar(new Resource(sources[i], "a", thingt));
		}
		for(Element actual:el4){
			String thingt=actual.text();
			System.out.println("title: "+thingt);
			resources.agregar(new Resource(sources[i], "title", thingt));
		}
		}catch(Exception e){
			System.out.println("No se pudo leer el sitio");
		}
		}
	}

	public void explorarRecursivo(String[] sources,int limite,int transcurrido){
		Lista<String> links=new Lista<String>();
		long start=System.currentTimeMillis();
		try{
		for(String s: sources){
		Document doc=Jsoup.connect(s).get();
		Elements es=doc.getAllElements();
		for(Element e:es){
			if(e.tagName().equals("img")){
				Resource recurso=new Resource(s, "img", e.attr("src"));
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
	
	/**
	 * 
	 * @param sources
	 * @param depth
	 */
//	public void explorarRecursivo(String[] sources,int depth) {
//		try{
//		long start=System.currentTimeMillis();
//		for(int i=0;i<sources.length;i++){
//			Document doc=Jsoup.connect(sources[i]).get();
//			Elements e=doc.getAllElements();
//			for(Element elemento:e){
//				
//		//		Resource recurso=new Resource(source[i], elemento.id(), nThingTagged)
//			}
//		}
//		
//		}catch(Exception e){}
//
//	}
	
	
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
