package entity;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasCoins=29;

    public int defaultSpeed=9;


    public Player(GamePanel gp, KeyHandler keyH)
    {
        super(gp);
        this.gp=gp;
        this.keyH=keyH;

        screenX=gp.screenWidth/2 - (gp.tileSize/2);
        screenY=gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(4,24,22,20);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues()
    {
        worldX = gp.tileSize * 20;
        worldY = gp.tileSize * 1;
        speed=defaultSpeed;
        direction="up";
        //Status player
        maxLife=4;
        life=maxLife;
    }

    public void getPlayerImage()
    {
        try{
            right1= ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/V1.png"));
            right2= ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/V2.png"));
            left1= ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/V1inv.png"));
            left2= ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/V2inv.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update()
    {
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {

            if(keyH.upPressed == true)
            {
                direction="up";

            }
            else if (keyH.downPressed == true)
            {
                direction="down";

            }
            else if (keyH.leftPressed == true)
            {
                direction="left";

            }
            else if(keyH.rightPressed == true)
            {
                direction="right";

            }

            collisionOn = false;
            gp.cChecker.checkTile(this);
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //verifica coliziunea cu NPC-urile
            int npcIndex = gp.cChecker.checkEntity(this,gp.npc);
            int monsterIndex = gp.cChecker.checkEntity(this,gp.monster);

            interactNPC(npcIndex);

            if(collisionOn == false)
            {
                switch(direction)
                {
                    case "up":
                        worldY-=speed;
                        break;
                    case "down":
                        worldY+=speed;
                        break;
                    case "left":
                        worldX-=speed;
                        break;
                    case "right":
                        worldX+=speed;
                        break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 16) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if(spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }


        }
    }

    public void interactNPC(int i)
    {
        if(i !=999)
        {
            gp.gameState = gp.dialogueState;
            gp.npc[i].speak();
        }
    }
    public void pickUpObject(int i)
    {
        if(i != 999)
        {
            String objectName = gp.obj[i].name;

            switch (objectName)
            {
                case "Heart":
                    gp.playSE(1);
                    gp.hasHearts++;
                    gp.ui.showMessage("You got a heart!");
                    if(gp.hasHearts > 4)
                    {
                        gp.hasHearts=4;
                    }
                    gp.obj[i]=null;
                    break;
                case "Boot":
                    gp.playSE(1);
                    speed+=2;
                    defaultSpeed=speed;
                    Thread decreaseThread = new Thread(() -> {
                        try {
                            Thread.sleep(5000); // Asteapta 5 secunde
                            speed -= 2;
                            defaultSpeed=speed;// Scade 2 din viteza
                            System.out.println("Viteza dupa 7 secunde: " + speed); // Afiseaza viteza actualizata
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    // Porneste thread-ul de scadere a vitezei
                    decreaseThread.start();
                    gp.ui.showMessage("You got a boost!");
                    gp.obj[i]=null;
                    break;
                case "Coin":
                    gp.playSE(1);
                    hasCoins++;
                    gp.ui.showMessage("You got a coin!");
                    gp.obj[i]=null;
                    break;
                case "Chest":
                    if(gp.level == 1)
                    {
                        if (hasCoins > 6) {
                            gp.gameState = gp.finishedState;
                            gp.stopMusic();
                            gp.playSE(2);
                            break;
                        } else {
                            gp.ui.showMessage("More coins!");
                            break;
                        }
                    }
                    if(gp.level == 2)
                    {
                        if (hasCoins > 9) {
                            gp.gameState = gp.finishedState;
                            gp.stopMusic();
                            gp.playSE(2);

                            break;
                        } else {
                            gp.ui.showMessage("More coins!");
                            break;
                        }
                    }
                case "Princess":


                        if (hasCoins > 11) {
                            gp.gameState = gp.finishedState;
                            gp.stopMusic();
                            gp.playMusic(2);

                            break;
                        } else {
                            gp.ui.showMessage("More coins!");
                            break;
                        }




            }
        }
    }

    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;

        switch(direction)
        {
            case "left":
                if(spriteNum == 1) {
                    image=left1;
                }
                if(spriteNum == 2) {
                    image=left2;
                }

                break;
            case "right":
                if(spriteNum == 1)
                {
                    image=right1;
                }
                if(spriteNum == 2)
                {
                    image=right2;
                }
                break;
            case "up":
                if(spriteNum==1)
                {
                    image=left1;
                }
                if(spriteNum==2)
                {
                    image=left2;
                }


            case "down":
                if(spriteNum==1)
                {
                    image=left1;
                }
                if(spriteNum==2)
                {
                    image=left2;
                }
        }
        g2.drawImage(image, screenX , screenY , gp.tileSize, gp.tileSize,null);
    }

}
