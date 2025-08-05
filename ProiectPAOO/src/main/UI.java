package main;

import object.OBJ_Coin;
//import object.OBJ_HEARTS;
import object.OBJ_Heart;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;



public class UI {
    GamePanel gp;
    Graphics2D g2;
    BufferedImage heart_full,heart_3v4,heart_half,heart_1v4,heart_blank;
    Font arial_40,arial_70B;
    BufferedImage HeartImage;
    BufferedImage CoinImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public String currentDialogue = "";
    public int commandNum = 0;

    static double playTime;
    DecimalFormat dFormat = new DecimalFormat("#00.00");


    public UI(GamePanel gp)
    {

        this.gp=gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        arial_70B = new Font("Arial",Font.BOLD,70);
//        OBJ_Heart heart = new OBJ_Heart();
//        HeartImage = heart.image;
        OBJ_Coin coin = new OBJ_Coin();
        CoinImage = coin.image;

        //SuperObject heart = new OBJ_HEARTS(gp);
    }

    public void showMessage(String text)
    {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2)
    {
        this.g2= g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if(gp.gameState   == gp.titleState)
        {
            drawTitleScreen();
        }

        if(gp.gameState == gp.finishedState)
        {
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text = null;
            int textLength;
            int x;
            int y;

            if(gp.level == 1)
            {
                text = "You finished the first level!";
            }
            if(gp.level == 2)
            {
                text= "You finished the second level!";
            }
            if(gp.level == 3)
            {
                text="You saved the princess!";
            }
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2;
            g2.drawString(text,x,y);

            text = "Timp estimat: " + dFormat.format(playTime)+"!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize * 1);
            g2.drawString(text,x,y);


            g2.setFont(arial_70B);
            g2.setColor(Color.magenta);
            text = "Congratulations";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize * 1);
            g2.drawString(text,x,y);



        }
        else if(gp.gameState == gp.playState)
        {
            drawLife(gp);
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(CoinImage, gp.tileSize/2,85,gp.tileSize,gp.tileSize,null);
            g2.drawString("x "+gp.player.hasCoins,80,120);

            playTime +=(double)1/60;
            g2.drawString("Timp:"+dFormat.format(playTime),gp.tileSize * 15, 700);

            if(messageOn == true)
            {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message,gp.tileSize * 15,gp.tileSize * 1);

                messageCounter++;

                if(messageCounter > 90)
                {
                    messageCounter=0;
                    messageOn = false;
                }
            }
        }



        if(gp.gameState == gp.pauseState)
        {
            drawPauseScreen();
        }

        if(gp.gameState == gp.dialogueState)
        {
            drawDialogueScreen();
        }
    }

    private void drawLife(GamePanel gp) {
        BufferedImage image = null, image2 = null, image3 = null, image4 = null, image5 = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/HealthBarFull.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/HealthBar3-4.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/HealthBarJumate.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/objects/HealthBar1-4.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/objects/HealthBarGol.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Check if any image is null and handle the error
        if (image == null || image2 == null || image3 == null || image4 == null || image5 == null) {
            System.err.println("One or more health bar images could not be loaded.");
            return;
        }

        // Draw the appropriate image based on the player's hearts
        switch (gp.hasHearts) {
            case 4:
                g2.drawImage(image, 40, 10, null);
                break;
            case 3:
                g2.drawImage(image2, 40, 10, null);
                break;
            case 2:
                g2.drawImage(image3, 40, 10, null);
                break;
            case 1:
                g2.drawImage(image4, 40, 10, null);
                break;
            case 0:
                g2.drawImage(image5, 40, 10, null);
                break;
            default:
                // If hearts value is out of expected range, draw blank or handle accordingly
                System.err.println("Unexpected number of hearts: " + gp.hasHearts);
                break;
        }
    }

    private void drawTitleScreen() {

        BufferedImage wallpaperImage = null;
        try {
            wallpaperImage= ImageIO.read(getClass().getClassLoader().getResourceAsStream("TitleScreen/TitleScreen.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(wallpaperImage, 0, 0, gp.screenWidth, gp.screenHeight, null);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,90F));
        String text = "The Blue Wizard";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 3;
        //Umbre pentru text
        g2.setColor(Color.gray);
        g2.drawString(text,x+3,y+5);
        //Text principal
        g2.setColor(Color.white);
        g2.drawString(text,x,y);

        //Meniu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
        text = "NEW GAME";
        x=getXforCenteredText(text);
        y+=gp.tileSize * 9;
        g2.setColor(Color.gray);
        g2.drawString(text,x+3,y+5);


        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        if(commandNum == 0)
        {
            g2.drawString(">",x-gp.tileSize+6,y);
            g2.drawString("<",x+gp.tileSize*5+4,y);
        }

        text = "LOAD GAME";
        x=getXforCenteredText(text);
        y+=gp.tileSize;
        g2.setColor(Color.gray);
        g2.drawString(text,x+3,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        if(commandNum == 1)
        {
            g2.drawString(">",x-gp.tileSize+6,y);
            g2.drawString("<",x+gp.tileSize*5+27,y);
        }

        text = "EXIT";
        x=getXforCenteredText(text);
        y+=gp.tileSize;
        g2.setColor(Color.gray);
        g2.drawString(text,x+3,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        if(commandNum == 2)
        {
            g2.drawString(">",x-gp.tileSize+6,y);
            g2.drawString("<",x+gp.tileSize*2+5,y);
        }


    }


    public void drawPauseScreen()
    {
        String text = "PAUSED";
        int x=getXforCenteredText(text);
        int y=gp.screenHeight/2;
        g2.drawString(text, x,y);

        text = "Press Y to save the game!";
        x=getXforCenteredText(text);
        y=gp.screenHeight - 50;
        g2.drawString(text,x,y);
    }
    public void drawDialogueScreen()
    {
        //Marime fereastra
        int x = gp.tileSize * 11;
        int y = 50;
        int width = gp.screenWidth - (gp.tileSize * 12);
        int height = gp.tileSize * 5;
        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
        x +=gp.tileSize/2;
        y +=gp.tileSize-15;
        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y+=30;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height)
    {
        Color DialogueBackground = new Color(222, 209, 144,220);
        g2.setColor(DialogueBackground);
        g2.fillRoundRect(x,y,width,height,35,35);
        DialogueBackground = new Color(135, 95, 46);
        g2.setColor(DialogueBackground);
        g2.setStroke((new BasicStroke(4)));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }
    public int getXforCenteredText(String text)
    {
        int length=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x=gp.screenWidth/2 - length/2;
        return x;
    }

}
