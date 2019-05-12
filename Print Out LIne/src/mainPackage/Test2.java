package mainPackage;

public class Test2 {

    public static int[] Xarray=new int[25];
    public static int[] Yarray=new int[25];
    
    
    
    public static void main (String[] args) 
    { 
    	AlgorithmBress(3, 15, 2, 5);
    	
    	
    	

    	
    	
    	
    	
    	
    	
        int x1 = 3, y1 = 2, x2 = 15, y2 = 5;    
        
        boolean printIt=false;

       for(int columns=0;columns<25;columns++)
       {
    	   for(int rows=0;rows<25;rows++)
    	   {
    		   
 //   			   System.out.print("x ");
    		   for(int insiderow=0;insiderow<25;insiderow++)
    	       {
    	    	 
    	    	
    	    		   
    	    		   if(rows==Xarray[insiderow]&&columns==Yarray[insiderow])
    	    		   {
    	    			  printIt=true;
    	    			//  break;
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
//   	int index=0;
//   
//   		for(int y=0;y<25;y++)
//       	{
//       		System.out.println("("+Xarray[y]+","+Yarray[y]+")");
//   			
//   			
//       	}
       
       
       
    }
    
    
    static void AlgorithmBress(int x1,double x2,int y1,double y2) {
    	int realx=x1;
    	int realy=y1;
    	double dx=x2-x1;
    	double dy=y2-y1;
    	double P=(2*dy)-dx;
    	int index=0;
    	 
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


