package net;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebReader {
	private org.jsoup.nodes.Document web;
	private static final int TIMEOUT_MILLIS = 50000;
	
	public WebReader(String address) throws IOException
	{
		URL url = new URL(address);
        web = Jsoup.parse(url, TIMEOUT_MILLIS);
	}
	
	public String read()
	{
		return web.html();
	}
	
	public String search(String regex)
	{
	   String res = null;
	   Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
      Matcher m = pattern.matcher(web.html());
      if (m.find()){
         res = m.group(1);
      }
      return res;
	}
	
	public String getIdValue(String id)
	{
		String value = null;
		
		Element elem = web.getElementById(id);
				
		if (elem != null){
			value = elem.text();	
		}
		
		return value;
	}
	
	public Elements getElementContaining(String text)
	{
		Elements elem = null;
		
		elem = web.getElementsContainingText(text);
		
		return elem;
	}
}
