import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
	
	
public class RegisterMax {

	
	
	public static void main (String[] args)
    {
          // Ausgabe Hello World!
          System.out.println("Hello World!");
          
         
          String dateiName = "U:\\eclipse-workspace\\Day 8\\src\\register.txt"; 
          ladeDatei(dateiName);
          
        	  
        	  
    }
	
	

		 
		  
	 
	  
	  private static void printArray(String[] array) {
		  System.out.println();
		  	for (int i=0; i < array.length;i++) {
  			  
		  	  
  			  System.out.print(array[i]+ " ");
  			  
  			  
      	}
		  
	  }
	 
	  private static boolean compare(Integer a, String op, Integer b) {
		  
		  if (op.equals(">")) {
			  
			  if (a > b) return true; 
			  
		  }
		  if (op.equals("<")) {
			  
			  if (a < b) return true; 
			  
		  }
		  if (op.equals("==")) {
			 // System.out.println("A: " + a + " B: " + b);
			  if (a.intValue() == b.intValue()) return true; 
			  
		  }
		  if (op.equals("!=")) {
			  
			 // System.out.println("A: " + a + " B: " + b);
			  if (a.intValue() != b.intValue()) return true; 
			  
		  }
		  if (op.equals(">=")) {
			  
			  if (a >= b) return true; 
			  
		  }
		  if (op.equals("<=")) {
			  
			  if (a <= b) return true; 
			  
		  }
		  
		  return false;	  
		  		  
		  
	  }
	  
	  
	  private static HashMap compute(HashMap register, String[] tokens)    {
		  
		  
		  Integer compare = 0;
		  Integer regval = 0;
		  boolean bedingung = true;
		  
		  if (register.containsKey(tokens[4])) compare = (Integer)register.get(tokens[4]);
		  
		  if (compare(compare, tokens[5], Integer.parseInt(tokens[6]))) {
			  
			 if (register.containsKey(tokens[0])) regval = (Integer)register.get(tokens[0]);
			
			 if (tokens[1].equals("inc")) {
				 
				 register.put(tokens[0], regval + Integer.parseInt(tokens[2]));
				 System.out.println("Erhöhe " + tokens[0] + "(" + regval + ") um " + Integer.parseInt(tokens[2]) + " auf " +  (regval + Integer.parseInt(tokens[2])));
			 }
			 else {
				 register.put(tokens[0], regval - Integer.parseInt(tokens[2]));
				 System.out.println("Erniedirge " + tokens[0] + "(" + regval + ") um " + Integer.parseInt(tokens[2]) + " auf " +  (regval - Integer.parseInt(tokens[2])));
			 }
			 
		  }  
		  else {
			  System.out.println("Vergleich fail: " + tokens[4] + "(" + compare + ") " + tokens[5] + " " + tokens[6]);	
		  }
			 
		  
		  System.out.println("Registersize: "+ register.values());
		  
		  return register;
		  
	  }
	  

	   private static void ladeDatei(String datName) {

	        HashMap register = new HashMap();
		    File file = new File(datName);

	        
	        if (!file.canRead() || !file.isFile())
	            System.exit(0);

	            BufferedReader in = null;
	        try {
	            in = new BufferedReader(new FileReader(datName));
	            String zeile = null;
	            int count = 0;
	            int max = 0;
	          
	            
	            while ((zeile = in.readLine()) != null) {
	             
	                
	                // Code
	                String[] tokens = zeile.split(" ");
	          
	                //System.out.println(tokens[0]);	
	                printArray(tokens);
	                System.out.println();
	                register = compute(register, tokens);
	   
	                if (max < (int)Collections.max(register.values())) max = (int) Collections.max(register.values());
	                	
	                }
	                
	           
	        	 System.out.println("Key : " + register.values());
	        	   
	        	Collection output = register.values();   
	        	
	        	
	        	
	        	System.out.println(max);
	         
	                
	      
	   
	            
	        
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
