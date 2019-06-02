import java.awt.Rectangle;
import java.util.LinkedList;
/////////////////////////so we need to find a way to make all luinks of the snake to follow in the right structure
public class snake { 
static LinkedList snake;
public  snake(){
	snake=new LinkedList();
	snake.addFirst(new Rectangle(player.getx(),player.gety(),player.getSizeX(),player.getSizeY()));//creat a snake with one square
}
public static void grow(){// so last rec in list is the head and first is tail
	Rectangle toAdd=new Rectangle(((Rectangle)(snake.getLast())).x,((Rectangle)(snake.getLast())).y,((Rectangle)(snake.getLast())).width,((Rectangle)(snake.getLast())).height);
	if(player.getSpeedX()>0)
	 toAdd.x=toAdd.x+toAdd.width;
	if(player.getSpeedX()<0)
		 toAdd.x=toAdd.x-toAdd.width;
	if(player.getSpeedY()>0)
		toAdd.y=toAdd.y+toAdd.height;
	if(player.getSpeedY()<0)
		toAdd.y=toAdd.y-toAdd.height;
		
	snake.addLast(toAdd);
}
public static void move(){// will move the snake
	grow();
	snake.removeFirst();
	
	Rectangle head=(Rectangle)snake.getLast();
	
	
	if(head.x<0){
		
		head.x=board.sizeX;
	}
	if(head.x>board.sizeX){
		
		head.x=0;
	}
	if(head.y<0){
		
				head.y=board.sizeY;
	}
	if(head.y>board.sizeY)
	{
		
		head.y=0;
	}
	
	
	
	
		
	
}
public Rectangle getLast() {
	return (Rectangle)snake.getLast();
}
public static int getSize(){
	return snake.size();
}
public  Rectangle get(int i) {
return (Rectangle)snake.get(i);
	
}
public static boolean lost(){
	boolean ans= false;
	Rectangle head=(Rectangle)snake.getLast();
	for(int i=0;i<getSize()-1;i++){
	if(head.intersects((Rectangle)snake.get(i)))
			ans=true;}
	return ans;
	

}
}
