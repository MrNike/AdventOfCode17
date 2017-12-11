
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
	
	
public class Anagram {

	
	
	public static void main (String[] args)
    {
          // Ausgabe Hello World!
          System.out.println("Hello World!");
          
         
          String dateiName = "U:\\eclipse-workspace\\Day 4\\src\\pass.txt"; 
          ladeDatei(dateiName);
          
        	  
        	  
    }
	
	
	
	  private static boolean validatePassword(String password) {
		  
		  
		  final String[] tokens = password.split(" ");	  
		
		  
		  for (int i=0; i < tokens.length;i++) {
			  
			  System.out.println("Searching Round: " + tokens[i]);
			  
			  for (int j =i+1; j < tokens.length; j++) {
				  
				  System.out.println("Compare: " + tokens[i] + " " + tokens[j]);
				  
				  if (validAnagram(tokens[i], tokens[j])) return false;
				 
			  }


		  }
		  
		  return true;
		  
	  }
	
	
	
	  private static boolean validAnagram(String s1, String s2) {
		
		    boolean isAnagram = false;
		    if (s1.length() == s2.length()) {
		        char[] s1AsChar = s1.toCharArray();
		        char[] s2AsChar = s2.toCharArray();
		        Arrays.sort(s1AsChar);
		        Arrays.sort(s2AsChar);
		        isAnagram = Arrays.equals(s1AsChar, s2AsChar);
		    } 
		    return isAnagram;
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
	            int count = 0;
	            while ((zeile = in.readLine()) != null) {
	                System.out.println("Gelesene Zeile: " + zeile);
	                
	                // Code
	                if (validatePassword(zeile)) count++;;	
	                
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
	        
	        System.out.println("Checksum: "+ checksum);
	        
	    } 

	
}
