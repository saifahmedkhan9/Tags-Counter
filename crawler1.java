package z;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
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
//	        String URL = JOptionPane.showInputDialog("Enter Link");
			String URL="";
	        HashMap<String,Integer > myMap = new HashMap<String, Integer>();
	        String filename="C:/project/z/src/z/link.txt";
			String[] line=new String[1500];
			int i=0;
	        
	        myMap.clear();	
	        try {
	        	PrintStream out = new PrintStream(new FileOutputStream("C:/project/z/src/z/output.txt"));
				System.setOut(out);
				
				FileReader file=new FileReader(filename);
				BufferedReader buff=new BufferedReader(file);
				
				while((line[i]=buff.readLine())!=null){
					URL=line[i];
					 Document document = Jsoup.connect(URL).timeout(200*1000).get();
			            
			            String tagN;
			            for(Element e : document.getAllElements()){
			                tagN = e.tagName().toLowerCase();
			                val = 1;
			                if(myMap.containsKey(tagN)){
			                    val= val+myMap.get(tagN);
			                } 
			                myMap.put(tagN, val);
			            }
			            System.out.println((i+1)+" Link is :"+URL);
			            System.out.println("Number of tags by select(\"*\") method =" + document.select("*").size());
			            System.out.println("Number of unique tags =" + myMap.size());	
			            
			            Iterator<String> keySetIterator = myMap.keySet().iterator();

			            while(keySetIterator.hasNext()){
			              String key = keySetIterator.next();
			              System.out.println("key: " + key + " value: " + myMap.get(key));
			            }
			            System.out.println("\n");
					i++;
					
				}
				
	           
	        } catch (IOException e) {
	           System.out.println(e);
	        }
	    

		
	}
	

}
