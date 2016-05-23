package finalProject;

import javax.swing.JOptionPane;

import processing.core.PApplet;

public class ProjectTesting extends PApplet {

	int middle;
	int strt;
	int shift;
	int nextAmount;
	double width;
	int redX;
	int redY;
	int blueX;
	int blueY;
	int size;
	int spdr;
	int spdb;
	int rxSpeed;
	int rySpeed;
	int bxSpeed;
	int bySpeed;
	int score;
	int mode;
	

	public void setup() {
		size(600, 600);

		middle = 300;
		strt = 10;
		shift = 100;
		nextAmount = 5;
		width = 30;
		redX = strt;
		redY = 325;
		blueX = 580;
		blueY = 350;
		size = 25;
		spdr = 1;
		spdb = 1;
		rxSpeed = 1;
		rySpeed = 0;
		
		bxSpeed = -1;
		bySpeed = 0;
		
		score = 0;
		
		mode = 0;
		
		textSize(30);
	
	}

	public void draw() {
		background(200);
		
		
		if(mode == 0)	levelOne();
		if(mode == 1)levelTwo();
		if(mode == 2)levelThree();
	
		
		
		
		/*if( score == 1){
			background(230);
			fill(0);
			text("You win!!!", 270, 200);
		
		}*/
	}

	public void drawLine(int x, int shift, int nextAmount, double width) {
		if (x == 600 - nextAmount) {
			return;
		}

		int x1 = x;
		int x2 = x + nextAmount;

		int y1 = (int) (Math.sin(x1 / width) * shift) + middle;
		int y2 = (int) (Math.sin(x2 / width) * shift) + middle;

		line(x1, y1, x2, y2);

		

		drawLine(x2, shift, nextAmount, width);

	}
	public void moveRed (int x, int y, int shift,  double width){
		
		int x1 = redX;
		int x2 = redX + 1;
	
		int y1 = (int) (Math.sin(x1 / width) * shift) + 300;
		int y2 = (int) (Math.sin(x2 / width) * shift) + 300;

	if(rxSpeed > 0){
		rySpeed = (y2 - y1);
	}else{
		rySpeed = (y1 - y2);
	}
		if(x > 580)rxSpeed = -rxSpeed;
			
		if( x < 5)rxSpeed = -rxSpeed;
		
		redX += rxSpeed;
		redY += rySpeed;
		

	}
	public void moveBlue(int x, int y, int shift, double width){
		
		int x1 = blueX;
		int x2 = blueX - 1;
	
		int y1 = (int) (Math.sin(x1 / width) * shift) + 300;
		int y2 = (int) (Math.sin(x2 / width) * shift) + 300;

		if(bxSpeed > 0){
			bySpeed = (y1 - y2);
		}else{
			bySpeed = (y2 - y1);
		}
		
		
			if(x > 580)bxSpeed = -bxSpeed;
				
			if( x < 5)bxSpeed = -bxSpeed;
		
		blueX += bxSpeed ;
		blueY += bySpeed ;
		
		
	}
	public boolean contact(){
		if(mousePressed){
				if(Math.abs(mouseX - redX) < size || Math.abs(mouseX - blueX) < size ){
					if(Math.abs(mouseY - redY) < size || Math.abs(mouseY - blueY) < size ){
						if( Math.abs(redX - blueX) < size && Math.abs( redY - blueY) < size){
							return true;
						}
					}
					
				}
			}	
		return false;	
		}
	
public void levelOne(){
	
	gameBones();
	
	if(contact()){
		changes();
		  
		}
	
	
}

public void levelTwo(){
	
	gameBones();
	
	if(contact()){
			changes();
		}
		
}


public void levelThree(){
	 gameBones();
}

public void gameBones(){
	fill(0);
	text(score, 50, 50);
	
	
	fill(0);
	drawLine(strt, shift, nextAmount, width);
	
	fill(200, 0, 0);
	ellipse (redX, redY, size, size);
	moveRed(redX, redY, shift, width);
	
	fill( 0, 0, 200);
	ellipse(blueX, blueY, size, size);
	moveBlue(blueX, blueY, shift, width);
	
	contact();
}


public void changes(){
	
	score++;
	mode++;
	shift += (int)(Math.random()*10);
	width += (int)(Math.random()*10);
	redX = strt;
	redY = (int) (Math.sin(strt / width) * shift) + middle;
	blueX = 580;
	blueY = (int) (Math.sin(580 / width) * shift) + middle;
	
}


	/*public void mouseReleased(){
		
		if(Math.abs(mouseX - redX) < size || Math.abs(mouseX - blueX) < size ){
			if(Math.abs(mouseY - redY) < size || Math.abs(mouseY - blueY) < size ){
				if( Math.abs(redX - blueX) < size && Math.abs( redY - blueY) < size){
					background(0, 200, 0);
					score++;
				}
			}
			
		}
		
		
		
		
		 score++;
			mode = 1;
			shift = 110;
			width =  20;
			redX = strt;
			redY = (int) (Math.sin(strt / width) * shift) + middle;
			blueX = 580;
			blueY = (int) (Math.sin(580 / width) * shift) + middle;
		
		
	}*/

}

