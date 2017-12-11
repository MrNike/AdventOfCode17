import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException; 


public class ChecksumTwo {

	
		
		public static void main (String[] args)
	    {
	          // Ausgabe Hello World!
	          System.out.println("Hello World!");
	          
	         
	          String dateiName = "U:\\eclipse-workspace\\Day 2\\src\\array.txt"; 
	          ladeDatei(dateiName);
	         
	  
	        	  
	        	  
	    }
	          
	

		
		   private static void ladeDatei(String datName) {

		        File file = new File(datName);
		        int checksum = 0;
		        
		        if (!file.canRead() || !file.isFile())
		            System.exit(0);

		            BufferedReader in = null;
		        try {
		            in = new BufferedReader(new FileReader(datName));
		            String zeile = null;
		            while ((zeile = in.readLine()) != null) {
		                System.out.println("Gelesene Zeile: " + zeile);
		                
		                // Code
		                int diff = calChecksum(zeile);
		                
		                System.out.println("Checksum: " + diff);
		                
		                checksum += diff;
		                
		                
		                
		                
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
		        
		        System.out.println("Checksum: "+ checksum);
		        
		    } 
	
		   private static int calChecksum(String zeile) {
			   
			   int diff = 0;
			   
			   final String[] tokens = zeile.split("	");
			   
			
			   
			   for (int i=0; i < tokens.length; i++) {
				   
				   int value = Integer.parseInt( String.valueOf(tokens[i]));
				   
				   for (int j=0; j < tokens.length; j++) {
					   
					   int comp = Integer.parseInt( String.valueOf(tokens[j]));
					   
					   if (i != j) {
						   
						   if ((value % comp) == 0) {
							   
							   diff = value / comp;
							   
							   
						   }
						   
					   }
					   
					   
				   }
			   }
			   

			   
			   
			   
			   return diff;
			   
			   
			   
		   }
	


	
	
}
