package mainPackage;

public class Test2 {

    // function for line generation 
    static void bresenham(int x1, int y1, int x2,int y2) 
    { 
        int m_new = 2 * (y2 - y1); 
        int slope_error_new = m_new - (x2 - x1); 
      
        for (int x = x1, y = y1; x <= x2; x++) 
        { 
            System.out.print("(" +x + "," + y + ")\n"); 
  
            // Add slope to increment angle formed 
            slope_error_new =slope_error_new + m_new; 
  
            // Slope error reached limit, time to 
            // increment y and update slope error. 
            if (slope_error_new >= 0) 
            { 
                y++; 
                slope_error_new =slope_error_new- 2 * (x2 - x1); 
            } 
        } 
    }          
  
    // Driver code  
    public static void main (String[] args) 
    { 
        int x1 = 3, y1 = 2, x2 = 15, y2 = 5;     
        //bresenham(x1, y1, x2, y2); 
       // bresenham2(x1, y1, x2, y2); 
    	System.out.println("x="+x1+" x2="+x2);
        AlgorithmBress(3, 15, 2, 5);
    }
    
    static void bresenham2(double x1, double y1, double x2,double y2) 
    { 
    	double pk=2.0*(y2-y1)-(x2-x1);
    	
    	double m= (y2-y1)/(x2-x1);
    	double b= y1-(m*x1);

        for (double currentx = x1; currentx <= x2; currentx++) 
        { 
        	
        	
        	
        	
     //       System.out.print("(" +currentx + "," + y + ")\n"); 
            
            
            
            
        }
        
    }          
    
    
    static void AlgorithmBress(double x1,double x2,double y1,double y2) {
    	double x=x1;
    	double y=y1;
    	double dx=x2-x1;
    	double dy=y2-y1;
    	System.out.println("x="+x+" x2="+x2);
    	double P=(2*dy)-dx;
    	 
    	while(x<=x2) {
    		System.out.println("("+x+","+y+")");
    		x++;
    		if(P<0) {
    			P=P+(2*dy);
    			
    		}
    		else
    		{
    			P=P+(2*dy)-(2*dx);
    			y++;
    		}
    	}
    	
    	System.out.println("x="+x+" x2="+x2);
    	 System.out.println(x<=x2);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    
} 


