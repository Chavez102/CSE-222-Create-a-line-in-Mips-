package mainPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner Keyboard=new Scanner(System.in);
//		System.out.print("what is x1 y1");
//		
//		int x1=Keyboard.nextInt();
//		int y1=Keyboard.nextInt();
//		
//		
//		System.out.print("what is x2 y2");
//		
//		int x2=Keyboard.nextInt();
//		int y2=Keyboard.nextInt();
		String star="*";
		String space="n";
		
		double x1=2;
		double y1=1;
		
		double x2=8;
		double y2=4;
		
		double m= (y2-y1)/(x2-x1);
		
		
		double b=y1-(m*x1);
		
		
		
		
		int biggest_x=50;
		int biggest_y=50;

		for(int y=0;y<biggest_y;y++)
		{
			for(int x=1;x<=biggest_x;x++)
			{
				int	yvalue=(int) (m*x+b);
				int xvalue=(int)(yvalue-b)/x;
				if (yvalue==y&&xvalue==x)
				{
					System.out.print(star);
				}
				else
				{
					System.out.println("xvalue"+x+" yvalue:"+yvalue);
					//System.out.print(space);
				}
				
				
			}
			System.out.println();
			
		}

		
		

	}

}
