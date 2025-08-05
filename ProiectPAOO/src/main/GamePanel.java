package main;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {
    //Setarile Ecranului
    public int level = 1;
    public final int originalTileSize = 16; //Marimea originala a unui Tile
     public final int Scale = 3;
    public final int tileSize = originalTileSize * Scale; //32x32 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol; //512 pixels
    public final int screenHeight = tileSize * maxScreenRow;// 384 pixels

    //Setarile lumii
    public final int maxWorldCol = 48;
    public final int maxWorldRow = 48;



    //FPS
    int FPS=60;

    //Sistem
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();

    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[30];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];

    //Game state
    public final int titleState = 0;

    public final int playState = 1;
    public final int pauseState = 2;

    public final int dialogueState = 3;
    public final int finishedState = 4;
    public int gameState = titleState;

    public int hasHearts=2;





    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Dimensiunile ferestrei
        this.setBackground(Color.lightGray ); //Culoarea fundalului
        this.setDoubleBuffered(true); //Ajuta la performanta jocului
        this.addKeyListener(keyH);
        this.setFocusable(true); // GamePanel-ul este focusat pentru primirea intrarilor de la tastatura

    }

    public void setupGame()
    {
//



            if (level == 1)
                tileM.loadMap("/maps/map1.txt");
            else if (level == 2)
                tileM.loadMap("/maps/map2.txt");
            else if (level == 3)
                tileM.loadMap("/maps/map3.txt");


        aSetter.setObject();
        aSetter.setNPC();
        if(level == 1) {
            aSetter.setMonster(level);
        }


        playMusic(0);
            DatabaseManager.createTableIfNotExists();



    }
    public void saveGame()
    {
        DatabaseManager.savePlayerState(level);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval=1000000000/FPS; // 0.016 secunde.

        // Se deseneaza un frame la o perioada de 0.016 secunde astfel incat sa avem 60 de imagini pe secunde
        double nextDrawTime=System.nanoTime() + drawInterval;
        while (gameThread != null) {
            //Update: actualizeaza informatiile despre caracter precum pozitia
            update();
            //Draw: Deseneaza informatiile actualizate pe ecran
            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime=remainingTime/1000000;

                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);
                nextDrawTime +=drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update()
    {
        if(gameState == playState)
        {
            player.update();

            for(int i=0;i<npc.length;i++)
            {
                if(npc[i] != null)
                {
                    npc[i].update();
                }
            }
            for(int i=0;i<monster.length;i++)
            {
                if(monster[i]!=null)
                {
                    monster[i].update();
                }
            }
        }
        if(gameState == pauseState)
        {


        }
        if(gameState==titleState){


        }

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;

        //Ecran principal
        if(gameState == titleState)
        {
            ui.draw(g2);
        }
        else {


            //Tile
            tileM.draw(g2);

            //Obiect
            for (int i = 0; i < obj.length; i++)
            {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }

            //NPC

            for (int i = 0; i < npc.length; i++)
            {
                if (npc[i] != null) {
                    npc[i].draw(g2);
                }
            }

            for (int i = 0; i < monster.length; i++)
            {
                if (monster[i] != null) {
                    monster[i].draw(g2);
                }
            }

            //Personaj
            player.draw(g2);

            //UI
            ui.draw(g2);



            }
        g2.dispose();
    }

    public void playMusic(int i)
    {
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic()
    {
        music.stop();
    }

    public void playSE(int i)
    {
        se.setFile(i);
        se.play();

    }

}
