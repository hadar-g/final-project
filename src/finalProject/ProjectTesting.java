package finalProject;

import processing.core.PApplet;

public class ProjectTesting extends PApplet{
	
	
	
	public void setup(){
		size(600, 600);
		
		
		
		
		
		
		
		
		
		
	}
	
	public void draw(){
		
		
		drawLine(10, 100, 20);
		
		
		
		
		
		
		


		
	}
	
	public void drawLine( int x, int shift, int nextAmount){
		if(x == 600 - nextAmount){
			return;
		}
		
		int x1 = x;
		int x2 = x + nextAmount;
		
		int y1 = (int) (Math.sin(x1) * shift) + 300;
		int y2 = (int) (Math.sin(x2) * shift) + 300;
		
		line(x1, y1, x2, y2);
		
		drawLine( x2, shift, nextAmount);
		
	}
	
	

}
