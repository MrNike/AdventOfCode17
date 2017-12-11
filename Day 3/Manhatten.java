
public class Manhatten {

	public static void main (String[] args)
    {
          // Ausgabe Hello World!
          System.out.println("Hello World!");
          
          distance(277678); 
          

        	   
        		  
          }	  
        		  
	private static int distance (Integer cell) {
		
		int dist = 0;
		int count = 8;
		int ring = 0;
		
		int i= 1;
		
		while ( i < cell) {
			
			dist = i;
			i += count*(ring+1);
			ring += 1; 
			
			
		}
		
		System.out.println("Ring: " + ring + " Edge: " + dist + " Cell: " + cell + " NextEdge: " + i);
		
		int posRing = (cell-dist);
		int mod = ((i-dist) / 4);
		
		System.out.println("PosRing: " + posRing + " Seitenlänge: " + mod + " Position Seite: " + posRing%(mod));
		
		int abs = ((posRing%mod)) - ((mod+1)/2);
		
		System.out.println("Absolute Position: " + Math.abs(abs))	;	
				
		dist = Math.abs(abs) + ring;
		
		System.out.println("Distance: " + dist);
		
		return dist;
	}
	
	
	
}
