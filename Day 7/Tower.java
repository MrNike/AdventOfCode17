import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
	
	
public class Tower {

	
	
	public static void main (String[] args)
    {
          // Ausgabe Hello World!
          System.out.println("Hello World!");
          
         
          String dateiName = "U:\\eclipse-workspace\\Day 7\\src\\tower.txt"; 
          ladeDatei(dateiName);
          
        	  
        	  
    }
	
	

		 
		  
	 
	  
	  private static void printArray(String[] array) {
		  	for (int i=0; i < array.length;i++) {
  			  
  			  System.out.print(array[i]+ " ");
  			  
      	}
		  
	  }
	  private static String searchBottom(Vector bot, Vector top) {
		  
		  String result = null;
		  
		  while (bot.size() > 1) {
			  
			  
			  System.out.println(" | Bot: " + bot.firstElement() + " Top: " + top.contains(bot.firstElement()));
			  
			  
			  
			  if (top.contains(bot.firstElement())) {
				  
				  bot.removeElement(bot.firstElement());
				  
				  
			  }
			  else return (String)bot.firstElement(); 
			  
			  
			  
		  }
		  
		  //result = (String)bot.firstElement();
		  
		  
		  return result;
		  
	  }
	
	   private static void ladeDatei(String datName) {

	        File file = new File(datName);
	        int checksum = 0;
	        Integer[] table = null;
	        Vector bottom = new Vector();
	        Vector top = new Vector();
	        
	        if (!file.canRead() || !file.isFile())
	            System.exit(0);

	            BufferedReader in = null;
	        try {
	            in = new BufferedReader(new FileReader(datName));
	            String zeile = null;
	            int count = 0;
	            while ((zeile = in.readLine()) != null) {
	             
	                
	                // Code
	                String[] tokens = zeile.split(" ");
	          
	                System.out.println(tokens[0]);	
	                //printArray(tokens);
	                
	                bottom.add(tokens[0]);
	                
	                if (tokens.length > 3 ) {
	                	
	                	for (int i=3; i < tokens.length;i++) {
	                		
	                		
	                		top.add(tokens[i].replace(",", ""));
	                		
	                		
	                	}
	                	
	                }
	                
	                
	                
	                
	            }
	            String bottomNode = searchBottom(bottom, top);
	            System.out.println("BOTTOM: " + bottomNode);
	            
	        
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (in != null)
	                try {
	                    in.close();
	                } catch (IOException e) {
	                }
	        }
	        

	        
	    } 

	
}
