package uniandes.cupi2.componenteBusqueda.webCrawler;
import java.io.IOException;
import java.io.Serializable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import lista.Lista;


public class Engine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Lista<Query> history;
	
	/**
	 * 
	 */
	public Engine() {
		
		history = new Lista<Query>();
	}
	
	/**
	 * 
	 * @param sources
	 * @param depth
	 * @return
	 */
	public Query explore(String[] sources,int depth) throws Exception{
		Query exploration=new Query(sources,depth);
		history.agregar(exploration);
		return exploration;
	}
	
	public Elements searchByTag(String tag){
		Document doc=null;
		try {
			doc=Jsoup.connect("http://www.eltiempo.com").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc.select(tag);
		
		
	}

	public Lista<Query> getHistory() {
		return history;
	}

	public void setHistory(Lista<Query> history) {
		this.history = history;
	}
	
	

}
