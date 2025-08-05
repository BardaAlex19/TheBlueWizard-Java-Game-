package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager
{
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp)
    {
        this.gp=gp;
        System.out.println("Level: "+this.gp.level);
        tile = new Tile[20];
        mapTileNum = new int[gp.maxWorldRow][gp.maxWorldCol];
        getTileImage();
        loadMap("/maps/map3.txt");



    }

    public void getTileImage()
    {
        if(gp.level == 1) {
            try {
                tile[0] = new Tile();
                tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));



                tile[1] = new Tile();
                tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bush.png"));



                tile[2] = new Tile();
                tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water2.jpg"));
                tile[2].collision = true;



                tile[3] = new Tile();
                tile[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/tree1.png")));
                tile[3].collision = true;


                tile[4] = new Tile();
                tile[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/dirt.png")));



                tile[5] = new Tile();
                tile[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/wood.jpg")));


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(gp.level == 2)
        {
            try {
                tile[0] = new Tile();
                tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Snow.png"));

                tile[1] = new Tile();
                tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/FrozenBush.png"));
                tile[1].collision = true;

                tile[2] = new Tile();
                tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/FrozenDirt.png"));


                tile[3] = new Tile();
                tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ice01.jpg"));


                tile[4] = new Tile();
                tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ice02.jpg"));

                tile[5] = new Tile();
                tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ice03.jpg"));

                tile[6] = new Tile();
                tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/igloo.png"));
                tile[6].collision = true;

                tile[7] = new Tile();
                tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Rock.png"));
                tile[7].collision = true;


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(gp.level == 3)
        {
            try {
                tile[0] = new Tile();
                tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/FloorLevel3.png"));

                tile[1] = new Tile();
                tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/FireTile.png"));
                tile[1].collision = true;

                tile[2] = new Tile();
                tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Lava.png"));


                tile[3] = new Tile();
                tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lava_rock.png"));
                tile[3].collision = true;


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader((is)));


            int col=0;
            int row=0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow)
            {
                String line = br.readLine();

                while(col < gp.maxWorldCol)
                {
                    String []numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }

                if(col == gp.maxWorldCol)
                {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){

        }
    }
    public void draw(Graphics2D g2)
    {
        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];
            if(tile[tileNum]!=null)
            {
                int worldX = worldCol * gp.tileSize;
                int worldY = worldRow * gp.tileSize;
                int screenX = worldX - gp.player.worldX + gp.player.screenX;
                int screenY = worldY - gp.player.worldY + gp.player.screenY;

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;


            if(worldCol == gp.maxWorldCol)
            {
                worldCol=0;

                worldRow++;

            }
        }
        
    }
}
