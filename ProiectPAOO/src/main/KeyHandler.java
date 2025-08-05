package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

import entity.Player;

public class KeyHandler implements KeyListener
{

    public boolean upPressed,downPressed,leftPressed,rightPressed,shiftPressed;
    GamePanel gp;

    public KeyHandler(GamePanel gp)
    {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code=e.getKeyCode();
        if(gp.gameState == gp.titleState)
        {
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
            {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0)
                {
                    gp.ui.commandNum = 2;
                }
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN )
            {
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 2)
                {
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER)
            {
                if(gp.ui.commandNum == 0)
                {
                    gp.setupGame();
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNum == 1)
                {
                    PlayerState playerState = DatabaseManager.loadPlayerState();
                    if (playerState != null) {
                        gp.level = playerState.level;
                        gp.tileM.getTileImage();
                        gp.aSetter.setMonster(gp.level);
                        gp.setupGame();
                        gp.gameState = gp.playState;
                    }
                    //Aici o sa fie load game-ul;
                }
                if(gp.ui.commandNum == 2)
                {
                    System.exit(0);
                }
            }
        }
        if(gp.gameState == gp.playState)
        {
            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
            {
                upPressed=true;
            }
            if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT )
            {
                leftPressed=true;
            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
            {
                downPressed=true;
            }
            if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
            {
                rightPressed=true;
            }
            if(code == KeyEvent.VK_SHIFT)
            {
                gp.player.speed=gp.player.defaultSpeed-2;
            }
            if(code == KeyEvent.VK_P)
            {
                gp.gameState = gp.pauseState;

            }
        }
        //Pause State
        else if(gp.gameState == gp.pauseState)
        {
            if(code == KeyEvent.VK_P)
            {
                gp.gameState = gp.playState;
            }
            if(code == KeyEvent.VK_Y)
            {
                gp.saveGame();
            }
        }
        //Dialogue State
        if(gp.gameState == gp.dialogueState)
        {
            if(code == KeyEvent.VK_ENTER)
            {
                gp.gameState = gp.playState;
            }
        }
        if(gp.gameState == gp.finishedState)
        {
            if(code == KeyEvent.VK_ENTER)
            {
                gp.level++;
                gp.aSetter.setMonster(gp.level);
                gp.setupGame();
                gp.gameState = gp.playState;
                gp.tileM.getTileImage();
                gp.hasHearts=2;
                gp.player.hasCoins=0;
                UI.playTime = 0;

                ;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code =e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
        {
            upPressed=false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
        {
            leftPressed=false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
        {
            downPressed=false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
        {
            rightPressed=false;
        }
        if(code == KeyEvent.VK_SHIFT)
        {
            gp.player.speed=gp.player.defaultSpeed;
        }
    }
}
