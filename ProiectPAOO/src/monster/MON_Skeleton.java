package monster;
import entity.Entity;
import main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class MON_Skeleton extends Entity
{

    public MON_Skeleton(GamePanel gp) {
        super(gp);
        String name = "Skeleton";
        direction = "right";
        speed = 2;
        maxLife = 3;
        life=maxLife;

        solidArea.x = 3;
        solidArea.y = 12;
        solidArea.width = 42;
        solidArea.height = 36;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }
    public void getImage() {
        try {
            left1 = ImageIO.read(getClass().getResourceAsStream("/Monster/go_3.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Monster/go_7.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Monster/go_3_og.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Monster/go_7_og.png"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load images", e);
        }

        // Check if any image is null and handle the error
        if (left1 == null || left2 == null || right1 == null || right2 == null) {
            throw new RuntimeException("One or more images could not be loaded.");
        }
    }

    public void setAction()
    {
        actionLockCounter++;
        if(actionLockCounter == 180)
        {
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i <= 25)
            {
                direction = "up";
            }
            if(i>25 && i <=50)
            {
                direction="down";
            }
            if(i>50 && i <=75)
            {
                direction = "left";
            }
            if(i> 75 && i <= 100)
            {
                direction = "right";
            }
            actionLockCounter=0;
        }
    }
}
