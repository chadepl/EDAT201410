package uniandes.cupi2.componenteBusqueda.webCrawler;
import java.io.Serializable;
import java.net.URL;


public class Resource implements Comparable<Resource>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String url;
	
	private String tag;
	
	private String thingTagged;
	
	/**
	 * 
	 * @param nUrl
	 * @param nTag
	 * @param nThingTagged
	 */
	public Resource(String nUrl,String nTag,String nThingTagged)  {
		// TODO Auto-generated constructor stub
		url=nUrl;
		tag=nTag;
		thingTagged=nThingTagged;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getThingTagged() {
		return thingTagged;
	}

	public void setThingTagged(String thingTagged) {
		this.thingTagged = thingTagged;
	}

	@Override
	public int compareTo(Resource o) {
				if(thingTagged.compareTo(o.thingTagged)>0)
			return 1;
		else if(thingTagged.compareTo(o.thingTagged)<0)
			return -1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		
		return "Proviene de: "+url+" Es: "+tag+" Recurso: "+thingTagged;
	}
	
	
	

}
