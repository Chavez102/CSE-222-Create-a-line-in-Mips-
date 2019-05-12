package mainPackage;

public class Test2 {
	 int[] theRaster=new int[400];	
	
    public static int[] Xarray=new int[25];
    public static int[] Yarray=new int[25];
    static int realx;
	static int realy;
	static double dx;
	static double dy;
	static double P;
	static int index=0;
    
    
    
    public static void main (String[] args) 
    { 
    	   int height=25;
    	
    	for(int t=0;t<25;t++)
    	{
    		Xarray[t]=100;
    		Yarray[t]=100;
    	}
    	// x1, x2, y1, y2
    	AlgorithmBress(2, 10, 1, 6);

        
        boolean printIt=false;
     

       for(int columns=height-1;columns>=0;columns--)
       {
    	   for(int rows=0;rows<height;rows++)
    	   {
    		   
 //   			   System.out.print("x ");
    		   for(int insiderow=0;insiderow<height;insiderow++)
    	       {
    	    	 
    	    	
    	    		   
    	    		   if(rows==Xarray[insiderow]&&columns==Yarray[insiderow])
    	    		   {
    	    			  printIt=true;
    	    			  break;
    	    		   }
    	    		   else
    	    		   {
    	    			   printIt=false;
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
    static void AlgorithmBress(int x1,double x2,int y1,double y2) {
    	 realx=x1;
    	 realy=y1;
    	 dx=x2-x1;
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


