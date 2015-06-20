package z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class crawler {
	
	
		
		public static void main(String[] args) {
			int val=0;
	        String URL = JOptionPane.showInputDialog("Enter Link");
//			String URL="http://sharkbike.j.layershift.co.uk";
	        HashMap<String,Integer > myMap = new HashMap<String, Integer>();
	        
	        myMap.clear();	
	        try {
	            Document document = Jsoup.connect(URL).get();
	            
	            String tagN;
	            for(Element e : document.getAllElements()){
	                tagN = e.tagName().toLowerCase();
	                val = 1;
	                if(myMap.containsKey(tagN)){
	                    val= val+myMap.get(tagN);
	                } 
	                myMap.put(tagN, val);
	            }
	            System.out.println("Number of tags by select(\"*\") method =" + document.select("*").size());
	            System.out.println("Number of unique tags =" + myMap.size());	
	            
	            Iterator<String> keySetIterator = myMap.keySet().iterator();

	            while(keySetIterator.hasNext()){
	              String key = keySetIterator.next();
	              System.out.println("key: " + key + " value: " + myMap.get(key));
	            }
	        } catch (IOException e) {
	           System.out.println(e);
	        }
	    

		
	}
	

}
