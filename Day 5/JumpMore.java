import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
	
	
public class JumpMore {

	
	
	public static void main (String[] args)
    {
          // Ausgabe Hello World!
          System.out.println("Hello World!");
          
         
          String dateiName = "U:\\eclipse-workspace\\Day 5\\src\\table.txt"; 
          //	  System.out.println();	  System.out.println();	  System.out.println();String dateiName = "U:\\eclipse-workspace\\Day 5\\src\\table2.txt";
          ladeDatei(dateiName);
          
        	  
        	  
    }
	
	
	
	  private static int jumpTable(Integer[] table) {
		   
		  int count = 0;
		  int pos = 0;
		  
		  while (pos < table.length) {
			  
			  for (int i=0; i< table.length;i++) {
				  
				//  if (i == pos) System.out.print("(");			  
				//  System.out.print(table[i]);  
				//  if (i == pos) System.out.print(")");
			
			  }
			  //System.out.println();
			  
			  int newpos = 0;
			  //System.out.println("Position: " + pos + " Wert: " + table[pos]);
			  
			  newpos = pos + table[pos];
			  
			  
			  // Nur bei +3 oder mehr schnitten .... schlecht beschrieben in Aufgabenstellung.
			  if (table[pos] > 2) {
				  
				  table[pos]--;
				  
			  } else  {
				  
				  table[pos]++;
			  }
			  
			  //System.out.println("Neuer Wert: " + table[pos]);
			  pos = newpos;
			  count++;
			  
			  
			 // System.out.println("Neue Position: " + pos + " Count: " + count);
			  
			  
			  
		  }
		  
		  
		  
		  
		  return count;
	  }
	
	
	  
	  
	  
	  
	
	   private static void ladeDatei(String datName) {

	        File file = new File(datName);
	        int checksum = 0;
	        Integer[] table = null;
	        if (!file.canRead() || !file.isFile())
	            System.exit(0);

	            BufferedReader in = null;
	        try {
	            in = new BufferedReader(new FileReader(datName));
	            String zeile = null;
	            int count = 0;
	            while ((zeile = in.readLine()) != null) {
	                count++;
	                
	                // Code
	               // if (validatePassword(zeile)) count++;;	
	                
	                System.out.println("Count: " + count);
                
	                
	            }
	            
	            table = new Integer[count];
	            
	        
	            count=0;
	            
	            in.close();
	            in = new BufferedReader(new FileReader(datName));
	            
	           // String[] table = new String[];
	            while ((zeile = in.readLine()) != null) {
	                System.out.println("Gelesene Zeile: " + zeile);
	                
	                table[count] = Integer.parseInt(zeile);
	                count++;                    
	                
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
	        
	        
	        System.out.println("Jumps: " + jumpTable(table));
	        
	    } 

	
}