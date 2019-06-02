import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class keyevent extends KeyAdapter {
final int speed=1;
	
	public void keyPressed(KeyEvent e)//this method comune with user through keyboard, u must have the keyevent library for this one.
	{
	int c=e.getKeyCode(); //this one puts the value of a key into c
	
	if(c==e.VK_RIGHT&&player.getSpeedX()==0){
		player.setSpeedX(player.getSpeedX()+speed);
		player.setSpeedY(0);
	}
	if(c==e.VK_LEFT&&player.getSpeedX()==0){
		player.setSpeedX(player.getSpeedX()-speed);
		player.setSpeedY(0);

	}
	if(c==e.VK_UP&&player.getSpeedY()==0){
		player.setSpeedY(player.getSpeedY()-speed);
		player.setSpeedX(0);

	}
	if(c==e.VK_DOWN&&player.getSpeedY()==0){
		player.setSpeedY(player.getSpeedY()+speed);
		player.setSpeedX(0);
	}
	
	
	}
	public void keyReleased(KeyEvent e){
		
	}// decide what happens once i release key
}
