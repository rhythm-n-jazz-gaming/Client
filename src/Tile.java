import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Tile {
	public static int tileSize = 20;
	public static int invLength = 6;
	public static int invHeight = 4;
	public static int invCellSize = 25;
	public static int invCellSpace = 4;
	public static int invBorderSpace = 4;
	public static int invItemBorder = 3;
	public static int maxMobs = 5;
	
	//Blocks & Paintings
	public static final int[] air = {-1,-1};
	public static final int[] earth = {0,0};
	public static final int[] grass = {1,0};
	public static final int[] sand = {2,0};
	public static final int[] jared = {3,0};
	public static final int[] solidAir = {4,0};
	public static final int[] wood = {5,0};
	public static final int[] stone = {6,0};
	public static final int[] bedrock = {7,0};
	public static final int[] leaves = {8,0};
	
	//Ores
	public static final int[] coal = {0,1};
	public static final int[] lapiz = {1,1};
	public static final int[] redstone = {2,1};
	
	// Mobs
	public static int[] mobRed = {0,26};
	public static int[] character = {0,28};
	
	public static BufferedImage tileset_terrain;
	public static BufferedImage tile_cell;
	public static BufferedImage tile_select;
	
	// Loads Images
	public Tile(){
		try{
			InputStream in_terrain = getClass().getResourceAsStream("tileset_terrain.png");
			Tile.tileset_terrain = ImageIO.read(in_terrain);
			
			InputStream in_cell = getClass().getResourceAsStream("tile_cell.png");
			Tile.tile_cell = ImageIO.read(in_cell);
			
			InputStream in_select = getClass().getResourceAsStream("tile_select.png");
			Tile.tile_select = ImageIO.read(in_select);
		}catch(Exception e){e.printStackTrace();}
	}
	
}
