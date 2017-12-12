import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
	
	
public class Memory {

	
	
	public static void main (String[] args)
    {
          // Ausgabe Hello World!
          System.out.println("Hello World!");
          
         
          String dateiName = "U:\\eclipse-workspace\\Day 6\\src\\memory.txt"; 
          ladeDatei(dateiName);
          
        	  
        	  
    }
	
	
	
	  private static Integer[] realloc(Integer[] memory) {
		   
		  
		  int pos = 0;
		  int big = 0;
		  
		  for (int i=0; i < memory.length;i++) {
			  
			  if (memory[i] > big) { pos=i; big=memory[i]; }
			  
		  }
		  
		  System.out.println();
		  System.out.println("Biggest Bank: " + pos + " " + big);
		  
		  memory[pos] = 0;
		  
		  while (big > 0) {
			  
			    
			  	memory[(++pos)%memory.length]++;
			  	big--;
			  
		  }
		  
		
		  
		  
		  return memory;
	  }
	
	 
	  
	  
	  private static boolean containsMem(Vector vec, Integer[] actual) {
		  
		  boolean result = false;
		  
		  for (int i=0; i < vec.size(); i++) {
			  		
			  		Integer[] temp = (Integer[])vec.elementAt(i);
			  		
			  	//	System.out.print("Vector" + i + " ");
			  	//	printArray(temp);
			  	//	System.out.print("Actual: ");
			  	//	printArray(actual);
			  	//	System.out.print(" | ");
			  		
			  for (int j=0; j < actual.length; j++) {
				  
				//  System.out.println("Compare :" + temp[j] + " " + actual[j] + " ");
				  
				  if (temp[j] == actual[j]) result = true;
				  
				
				  
				  else {
					  
					  result = false; break;
				  }
				  
			  }
			  
			  
			  	if (result == true) {
			  		
			  		return true;
			  	}
			  
		  }
		  
		  return false;
		  
		  
		 
		  
	  }
	  
	  private static void printArray(Integer[] array) {
		  	for (int i=0; i < array.length;i++) {
  			  
  			  System.out.print(array[i]+ " ");
  			  
      	}
		  
	  }
	  
	
	   private static void ladeDatei(String datName) {

	        File file = new File(datName);
	        int checksum = 0;
	        Integer[] table = null;
	        Vector seen = new Vector();
	        
	        if (!file.canRead() || !file.isFile())
	            System.exit(0);

	            BufferedReader in = null;
	        try {
	            in = new BufferedReader(new FileReader(datName));
	            String zeile = null;
	            int count = 0;
	            while ((zeile = in.readLine()) != null) {
	             
	                
	                // Code
	                final String[] tokens = zeile.split("	");
	                Integer[] intTok = new Integer[tokens.length];
	                
	                for (int i=0;i < tokens.length;i++) {
	                	
	                	intTok[i] = Integer.parseInt(tokens[i]);
	                	
	                	
	                }
	                
	                
	                // 
	                Integer[] actual = intTok;
	             
	                
	                while (!containsMem(seen, actual)) {
	                	
	                	//System.out.println();
	                	//System.out.print("Actual before add: ");
	                	//printArray(actual);
	                	
	                	seen.add(actual.clone());
	                	
	                    actual = realloc(actual);
	                	
	                    count++;
	                	//System.out.println("Count: " + count + " Integer[]: ");
	                	  
	                	                	
	                }
	                
	                
	                System.out.println("Count: " + count);
                
	                
	            }
	            
	        
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
