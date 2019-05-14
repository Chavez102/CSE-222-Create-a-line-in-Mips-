package mainPackage;

public class Main {
	 int[] theRaster=new int[400];	
	
    public static int[] Xarray=new int[25];
    public static int[] Yarray=new int[25];
    static int realx;
    static double x2;
	static int realy;
	static double dx;
	static double dy;
	static double P;
	
	static double y2;
	static int index=0;
	static int t;
	
	static int columns;
    static int rows;
    static int insiderow;
    
    public static int height=25;
    
    public static void main (String[] args) 
    { 
    	   
    	
    
    	// x1, x2, y1, y2
    	
    	realx=2;
    	x2=10;
    	realy=1;
    	y2=6;
    	
    	
    	for(t=0;t<25;t++)
    	{
    		Xarray[t]=100;
    		Yarray[t]=100;
    	}
    	
    	
     dx=x2-realx;
   	 dy=y2-realy;
   	 P=(2*dy)-dx;
   	 index=0;
   	 
   	System.out.println("dx:"+dx);
   	System.out.println("dy:"+dy);
   	System.out.println("P:"+P);
   	System.out.println("index:"+index);
   	
	
   	
   	
    	AlgorithmBress();

    	
    	
    	for(int y=0;y<25;y++)
      	{
      		System.out.println("("+Xarray[y]+","+Yarray[y]+")");
  			
  			
      	}
    	
    	
    	
        
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
       
       index=0;
       
  		
   
    }
       
       
       	//print out cordinates of line   
   	
    
    //USE FOR SLOPE LESS THAN 1      
    static void AlgorithmBress() {
    	 System.out.println("-----------------");
    	 
    		while(realx<x2+1) {
    		System.out.println("p="+P);
    		Xarray[index]=realx;
    		Yarray[index]=realy;
    		index++;
    		
    		
    		realx++;
    		if(P<0) {
    			P=P+(2*dy);
    			System.out.print("true");
    		}
    		else
    		{
    			P=P+(2*dy)-(2*dx);
    			realy++;
    			System.out.print("false");
    		}
    		
    	}
    	
    }
    



 
} 


