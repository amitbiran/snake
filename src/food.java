import java.awt.Rectangle;
import java.util.LinkedList;

public class food {
static private int x,y;

public food(){
	 x = (int )(Math.random() * (board.sizeX -70));
	y=(int )(Math.random() * (board.sizeY - 70));
	if(x==0&y==0)changeLocation();
}

public static int getx (){
	return x;
}
public static void setx(int z){
	x=z;
}
public static int gety (){
	return y;
}
public static void sety(int z){
	y=z;
}
public static void changeLocation(){
	x = (int )(Math.random() * (board.sizeX -70));
	y=(int )(Math.random() * (board.sizeY -70));
	
}
}
