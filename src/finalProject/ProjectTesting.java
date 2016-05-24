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
		
		mode = 1;
		
		textSize(30);
		
		
	
	}

	public void draw() {
		background(200);
		
		fill(0);
		text("level: " + mode, 50, 50);
		
		
		if(mode == 1)levelOne();
		if(mode == 2)levelTwo();
		if(mode == 3)levelThree();
		if(mode == 4)levelFour();
		if(mode == 5) levelFive();
		if(mode == 6)levelSix();
		if(mode == 7)seven();
		
	}

	public void drawLine(int x, int shift, int nextAmount, double width) {
		if (x == 600 - nextAmount) {
			return;
		}

		int x1 = x;
		int x2 = x + nextAmount;
		
		int y1 = (int) (Math.sin(x1 / width) * shift) + middle;
		int y2  = (int) (Math.sin(x2 / width) * shift) + middle;
		
		
		
		line(x1, y1, x2, y2);

		

		drawLine(x2, shift, nextAmount, width);

	}
	public void moveRed (int x, int y, int shift,  double width){
		
		int x1 = redX;
		int x2 = redX + 1;
	
		int y1 = (int) (Math.sin(x1 / width) * shift) + middle;
		int y2 = (int) (Math.sin(x2 / width) * shift) + middle;

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
	
		int y1 = (int) (Math.sin(x1 / width) * shift) + middle;
		int y2 = (int) (Math.sin(x2 / width) * shift) + middle;

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
		changes(110, 20);
		}
	
	
}

public void levelTwo(){
	
	gameBones();
	
	if(contact()){
		 	changes(90, 45);
	
		}
		
}


public void levelThree(){
	 gameBones();
	 
	 if(contact()){
		 middle = 200;
		changes(100, 30);
		
	 }
}
public void levelFour(){
 gameBones();
	 
	 if(contact()){
		 middle = 400;
		changes(60, 30);
		
	 }
	
}

public void levelFive(){
 gameBones();
	 
	 if(contact()){
		middle = 300;
		changes(110, 10);
		middle = 1000;
		
	 }
	
}

public void levelSix(){
 gameBones();
	 
	 if(contact()){
		mode++;
	 }
	
}
public void seven(){
	
	background(0, 200, 0);
	fill(0);
	text("You win!!!", 270, 300);

}

public void gameBones(){

	
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


public void changes(int shft, int wdth){
	
	score++;
	mode++;
	shift = shft;
	width = wdth;
	redX = strt;
	redY = (int) (Math.sin(strt / width) * shift) + middle;
	blueX = 580;
	blueY = (int) (Math.sin(blueX / width) * shift) + middle;
	
}

}

