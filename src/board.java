import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
	import javax.swing.WindowConstants;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;



public class board extends JPanel implements ActionListener{    //jpanel is the dot  
	//action listener lets me make actions like moving the dot, key listener lets me comune with dot through keyboard
	int speedOfGame=30;//the lower the number the faster the game
	Timer clock= new Timer(speedOfGame,this);// timer will make an action every 5 seconds, this is about action listener
	 static int sizeX=600,sizeY=600;// size of game frame
food f=new food();
snake s=new snake();
boolean leagal;

public board()// thats a builder
{
	
	
	//setBackground(Color.RED);
	setFocusable(true);
	addKeyListener(new keyevent());  //this rely to key listern
	clock.start();
}//builder

public void paintComponent(Graphics e) //using this for choosing a paint for dote and to change loction but actuelly wi dont move anything but we paint and delete the pixels
{
	
	
		
super.paintComponent(e);
Rectangle head =(Rectangle)s.getLast();

Rectangle food1=new Rectangle(f.getx(),f.gety(),15,15);


e.setColor(Color.green);//choose color
e.fillRect(head.x,head.y,head.width,head.height);// choose location

///
for(int i=0;i<s.getSize()-1;i++){
	Rectangle toPaint=s.get(i);
	e.fillRect(toPaint.x,toPaint.y,toPaint.width,toPaint.height);
}
///









e.setColor(Color.blue);//choose color
e.fillRect(food1.x,food1.y,food1.width,food1.height);// choose location

//if (player.getx()>(sizeX))player.setx(0);//limit player movement on board
//if (player.getx()<(-70))player.setx(sizeX);
//if (player.gety()>(sizeY))player.sety(0);
//if (player.gety()<(-70))player.sety(sizeY);
if(head.intersects(food1)){/// collision of snake with food
	
		e.drawString("YUM!!",head.x,head.y);
		
		leagal=false;
		while(!leagal){//
			leagal=true;//
			f.changeLocation();//
		for(int i=0;i<s.getSize();i++){//make sure food wont show up on the snake
			Rectangle toCheck=s.get(i);
			if(f.getx()==toCheck.x&f.gety()==toCheck.y)
				leagal=false;
			
		}
		}
		s.grow();//////////////
		speedOfGame-=5;		
}



}


public void actionPerformed(ActionEvent e)//here i preform the action like painting and moving
{
	
//player.setx(player.getx()+player.getSpeedX());
//player.sety(player.gety()+player.getSpeedY());	
	if(!s.lost())
	s.move();	///////////////////
	
repaint(); //will let me repaint 



 
}




public static void main(String[] args){
	board myBoard= new board();
JFrame myFrame = new JFrame();//create window
myFrame.setTitle("myWindow");// name for window
myFrame.setSize(sizeX,sizeY);//size of window
myFrame.setResizable(false);
myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//create option to exit
myFrame.setVisible(true);//visible window

myFrame.add(myBoard);//add my object to the window


}





}