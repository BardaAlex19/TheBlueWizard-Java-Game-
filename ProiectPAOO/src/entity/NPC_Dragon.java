package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Dragon extends Entity {
    public NPC_Dragon(GamePanel gp)
    {
        super(gp);
        direction="down";
        speed = 1;
        getImage();
        setDialogue();
    }
    public void getImage()
    {
        try{
            left1= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/101.png"));
            left2= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/102.png"));
            left3= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/103.png"));
            left4= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/104.png"));
            left5= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/105.png"));

            right1= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/000.png"));
            right2= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/001.png"));
            right3= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/002.png"));
            right4= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/003.png"));
            right5= ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/004.png"));




        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setDialogue()
    {
        dialogues[0] = "Hello, my friend \nTo complete this level, you need to: \n-collect all coins; \n-avoid all enemies; \n-retrieve the lost chest! \n-press Y to save the game! \nGood Luck!";

    }

    public void setAction()
    {
        actionLockCounter++;
        if(actionLockCounter == 360)
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

    //Metoda seamana cu cea din entity, dar va ramane aici in caz de personajul spune ceva care nu vor putea spune celelalte personaje
    public void speak()
    {
        super.speak();
    }

}
