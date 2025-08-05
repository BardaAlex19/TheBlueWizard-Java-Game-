package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import main.GamePanel;

public class OBJ_HEARTS extends SuperObject
{
    GamePanel gp;
    public OBJ_HEARTS(GamePanel gp)
    {
        this.gp=gp;
        name = "HEARTS";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("objects/HealthBarFull.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("objects/HealthBar3-4.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("objects/HealthBarJumate.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("objects/HealthBar1-4.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("objects/HealthBarGol.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }



}
