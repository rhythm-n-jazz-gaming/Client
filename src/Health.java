import java.awt.*;

public class Health {
	// Test
	public static int playerHealth = 100;
	public static boolean playerIsDead = false;
	
	public Rectangle healthBar = new Rectangle(5,5,100,10);
	
	public Health(){
		
		switch(playerHealth){
		case 10:
			healthBar.width = 100;
			this.tick();
			break;
		case 9:
			healthBar.width = 90;
			break;
		case 8:
			healthBar.width = 80;
			break;
		case 7:
			healthBar.width = 70;
			break;
		case 6:
			healthBar.width = 60;
			break;
		case 5:
			healthBar.width = 50;
			break;
		case 4:
			healthBar.width = 40;
			break;
		case 3:
			healthBar.width = 30;
			break;
		case 2:
			healthBar.width = 20;
			break;
		case 1:
			healthBar.width = 10;
			break;
		case 0:
			healthBar.width = 0;
			playerIsDead = true;
			break;
		}
        
	}
	
	public void tick(){
        for(int i = 0; i <= Component.mob.size() + 1; i++){
			if(Component.character.x >= Component.mob.get(i).x && Component.character.x <= (Component.mob.get(i).x + Component.mob.get(i).width) && Component.character.y >= Component.mob.get(i).y && Component.character.y <= (Component.mob.get(i).y + Component.mob.get(i).height)){
				playerHealth = playerHealth - 10;
			}
			if(i == Component.mob.size() + 1){
				i = 0;
			}
        } 
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		// Draw Health Bar
		g.fillRect(10,10, playerHealth, 10);
	}

}
