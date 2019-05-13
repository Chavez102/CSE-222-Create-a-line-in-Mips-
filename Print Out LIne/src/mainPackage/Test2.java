package mainPackage;

public class Test2 {
	 int[] theRaster=new int[400];	
	
    public static int[] Xarray=new int[25];
    public static int[] Yarray=new int[25];
    static int realx;
    static double x2;
	static int realy;
	static double dx;
	static double dy;
	static double P;
	static double y1;
	static double y2;
	static int index=0;
	static int t;
	
	static int columns;
    static int rows;
    static int insiderow;
    
    public static void main (String[] args) 
    { 
    	   int height=25;
    	
    	for(t=0;t<25;t++)
    	{
    		Xarray[t]=100;
    		Yarray[t]=100;
    	}
    	// x1, x2, y1, y2
    	
    	realx=2;
    	x2=10;
    	realy=1;
    	y2=6;
    	AlgorithmBress();

        
        boolean printIt=false;
     

       for(columns=height-1;columns>=0;columns--)
       {
    	   for( rows=0;rows<height;rows++)
    	   {
    		   
 //   			   System.out.print("x ");
    		   for( insiderow=0;insiderow<height;insiderow++)
    	       {
    	    	 
    	    	
    	    		   
    	    		   if(rows==Xarray[insiderow]&&columns==Yarray[insiderow])
    	    		   {
    	    			  printIt=true;
    	    		   }

    	    		 
    	    	   
    	      }
    		   
    		   
    		   if(printIt)
    		   {
    			   System.out.print(" x");
    		   }
    		   else {
   	    		
    			   System.out.print(" _");
    		   }
    		   printIt=false;
    		   
    		   
    	   }
    	   System.out.println();
       }
       
       
       	//print out cordinates of line   
   	int index=0;
   
   		for(int y=0;y<25;y++)
       	{
       		System.out.println("("+Xarray[y]+","+Yarray[y]+")");
   			
   			
       	}
    }
    
    //USE FOR SLOPE LESS THAN 1      
    static void AlgorithmBress() {
    	 

    	 dx=x2-realx;
    	 dy=y2-y1;
    	 P=(2*dy)-dx;
    	 index=0;
    	 
    	while(realx<=x2) {
//    		System.out.println("("+realx+","+realy+")");
    		
    		Xarray[index]=realx;
    		Yarray[index]=realy;
    		index++;
    		
    		
    		realx++;
    		if(P<0) {
    			P=P+(2*dy);
    			
    		}
    		else
    		{
    			P=P+(2*dy)-(2*dx);
    			realy++;
    		}
    	}
    	
    }
    



 
} 


