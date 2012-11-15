import java.awt.*;
import java.util.*;

public class Level {
	public static int worldW = 100, worldH = 100;
	public Block[][] block = new Block[worldW][worldH];
	
	public Level(){
		for(int x=0; x<block.length; x++){
			for(int y=0; y<block[0].length; y++){
				block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.air);
			}
		}
		
		generateLevel();
	}
	
	// Generates Level
	
	public void generateLevel(){
		
		//Generating Mountains, earth etc.
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(y > worldH/4){
					if(new Random().nextInt(100) > 20){
						try{
							if(block[x-1][y-1].id == Tile.earth){
								block[x][y].id = Tile.earth;
							}
						}catch(Exception e){}
					}
					if(new Random().nextInt(100) > 30){
						try{
							if(block[x+1][y-1].id == Tile.earth){
								block[x][y].id = Tile.earth;
							}
						}catch(Exception e){}
					}

					try{
						if(block[x][y-1].id == Tile.earth){
							block[x][y].id = Tile.earth;
						}
					}catch(Exception e){}
					
					if(new Random().nextInt(100) < 2){
						block[x][y].id = Tile.earth;
					}
				}
			}
		}
		
		//Placing Trees
		for(int y=0; y<block.length;y++){
			for(int x=0; x<block[0].length;x++){
				try{
					if(block[x][y + 1].id == Tile.earth && block[x][y].id == Tile.air){
						if(new Random().nextInt(100) <= 5){
						for(int i = 0; i < new Random().nextInt(5) + 4; i++){
							block[x][y - i].id = Tile.wood;
						}
						block[x][y].id = Tile.wood;
					}
					
			}
				}catch(Exception e){}
			}
		}
		//Places Leaves
		for(int y=0; y<block.length;y++){
			for(int x=0; x<block[0].length; x++){
				try{
				if(block[x+1][y].id == Tile.wood || block[x-1][y].id == Tile.wood){
						if(block[x][y+1].id != Tile.earth && block[x][y+2].id !=Tile.earth && block[x][y+3].id != Tile.earth){
							block[x][y].id = Tile.leaves;
							if(block[x+1][y].id == Tile.air){
							block[x+1][y].id = Tile.leaves;
							}
							if(block[x-1][y].id == Tile.air){
							block[x-1][y].id = Tile.leaves;
							}
						}
					}
				if(block[x][y+1].id == Tile.wood && block[x][y-1].id == Tile.air){
					block[x][y].id = Tile.leaves;
					block[x+1][y].id = Tile.leaves;
					block[x-1][y].id = Tile.leaves;
					block[x][y-1].id = Tile.leaves;
					block[x][y-2].id = Tile.leaves;

				}
				}catch(Exception e){}
			}
		}
		// Placing Grass Blocks on top layer
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(block[x][y].id == Tile.earth && block[x][y-1].id == Tile.air){
					block[x][y].id = Tile.grass;
				}
			}
		}
		// Places Stone
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(y >  85 && new Random().nextInt(100) < 99){
					block[x][y].id = Tile.stone;
				}
				if(y > 80 && new Random().nextInt(100) < 80){
					block[x][y].id = Tile.stone;
				}
				if(y > 69 && new Random().nextInt(100) < 70){
					block[x][y].id = Tile.stone;
				}
				if(y > 60 && new Random().nextInt(100) < 35){
					block[x][y].id = Tile.stone;
				}
				if(y > 53 && new Random().nextInt(100) < 25){
					block[x][y].id = Tile.stone;
				}
			}
		}
		// Places Coal
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(y > 65 && new Random().nextInt(100) < 5){
					block[x][y].id = Tile.coal;
				}
			}
		}
		// Places Lapiz
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(y > 90 && new Random().nextInt(100) < 0.5){
					block[x][y].id = Tile.lapiz;
				}
			}
		}
		// Places Redstone ore
				for(int y=0; y<block.length; y++){
					for(int x=0; x<block[0].length; x++){
						if(y > 85 && new Random().nextInt(100) < 1){
							block[x][y].id = Tile.redstone;
						}
					}
				}
		
		// Places Invisible Solid Blocks
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(x == 0 || y == 0 || x == block[0].length-1){
					block[x][y].id = Tile.solidAir;
				}
			}
		}
	// Place Bedrock
	for(int y=0; y<block.length; y++){
		for(int x=0; x<block[0].length; x++){
			if(y == block[0].length-1){
				block[x][y].id = Tile.bedrock;
			}
		}
	}
}
	// Allow the player to build & Destroy blocks
	public void building(int camX, int camY, int renW, int renH){
		if(Component.isMouseLeft || Component.isMouseRight){
			for(int x= (camX/Tile.tileSize); x<(camX/ Tile.tileSize) + renW; x++){
				for(int y= (camY/Tile.tileSize); y<(camY/ Tile.tileSize) + renH; y++){
					if(x >=0 && y >= 0 && x< worldW && y < worldH){
						if(block[x][y].contains(new Point ((Component.mse.x / Component.pixelSize) + (int)Component.sX, (Component.mse.y / Component.pixelSize) + (int)Component.sY))) {
							int sid[] = Inventory.invBar[Inventory.selected].id;
							
							if(Component.isMouseLeft){	
								if(block[x][y].id != Tile.solidAir && block[x][y].id != Tile.bedrock){
									block[x][y].id = Tile.air;	
								}
							}else if(Component.isMouseRight){
								if(block[x][y].id == Tile.air){
									
									if(sid != Tile.air) {
										block[x][y].id = sid;
										
										if(block[x][y + 1].id == Tile.grass){
											block[x][y + 1].id = Tile.earth;
										}
									}
								}
							}
							
							break;
						}
					}
				}
			}
		}
	}
	
	public void tick(int camX, int camY, int renW, int renH){
		if(!Inventory.isOpen){
		building(camX, camY, renW, renH);
		}
	}
	
	
	public void render(Graphics g, int camX, int camY, int renW, int renH){
		for(int x= (camX/Tile.tileSize); x<(camX/ Tile.tileSize) + renW; x++){
			for(int y= (camY/Tile.tileSize); y<(camY/ Tile.tileSize) + renH; y++){
				if(x >=0 && y >= 0 && x< worldW && y < worldH){
					block[x][y].render(g);
					
					if(block[x][y].id != Tile.air && block[x][y].id != Tile.solidAir && !Inventory.isOpen){
						if(block[x][y].contains(new Point ((Component.mse.x / Component.pixelSize) + (int)Component.sX, (Component.mse.y / Component.pixelSize) + (int)Component.sY))) {
							g.setColor(new Color(255,255,255, 60));
							g.fillRect(block[x][y].x - camX, block[x][y].y - camY, block[x][y].width -1, block[x][y].height -1);
						}
					}else{
						if(!Inventory.isOpen)
							if(block[x][y].contains(new Point ((Component.mse.x / Component.pixelSize) + (int)Component.sX, (Component.mse.y / Component.pixelSize) + (int)Component.sY))) {
								g.setColor(new Color(255,255,255, 60));
								g.drawRect(block[x][y].x - camX, block[x][y].y - camY, block[x][y].width -1, block[x][y].height -1);
							}
						}
					}
				}
			}
		}
	}
