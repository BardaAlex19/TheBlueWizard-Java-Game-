package main;

import entity.NPC_Dragon;
import monster.MON_Minotaur;
import monster.MON_Penguin;
import monster.MON_Skeleton;
import object.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp)
    {
        this.gp=gp;
    }

    public void setObject()
    {
        if(gp.level == 1) {


            gp.obj[0] = new OBJ_Boot();
            gp.obj[0].worldX = 20 * gp.tileSize;
            gp.obj[0].worldY = 7 * gp.tileSize;

            gp.obj[1] = new OBJ_Boot();
            gp.obj[1].worldX = 10 * gp.tileSize;
            gp.obj[1].worldY = 18 * gp.tileSize;

            gp.obj[2] = new OBJ_Heart();
            gp.obj[2].worldX = 37 * gp.tileSize;
            gp.obj[2].worldY = 5 * gp.tileSize;

            gp.obj[3] = new OBJ_Coin();
            gp.obj[3].worldX = 10 * gp.tileSize;
            gp.obj[3].worldY = 10 * gp.tileSize;

            gp.obj[4] = new OBJ_Coin();
            gp.obj[4].worldX = 35 * gp.tileSize;
            gp.obj[4].worldY = 12 * gp.tileSize;

            gp.obj[5] = new OBJ_Coin();
            gp.obj[5].worldX = 17 * gp.tileSize;
            gp.obj[5].worldY = 19 * gp.tileSize;

            gp.obj[6] = new OBJ_Coin();
            gp.obj[6].worldX = 15 * gp.tileSize;
            gp.obj[6].worldY = 15 * gp.tileSize;

            gp.obj[7] = new OBJ_Coin();
            gp.obj[7].worldX = 40 * gp.tileSize;
            gp.obj[7].worldY = 40 * gp.tileSize;

            gp.obj[8] = new OBJ_Coin();
            gp.obj[8].worldX = 35 * gp.tileSize;
            gp.obj[8].worldY = 20 * gp.tileSize;

            gp.obj[9] = new OBJ_Coin();
            gp.obj[9].worldX = 30 * gp.tileSize;
            gp.obj[9].worldY = 30 * gp.tileSize;

            gp.obj[10] = new OBJ_Heart();
            gp.obj[10].worldX = 32 * gp.tileSize;
            gp.obj[10].worldY = 16 * gp.tileSize;

            gp.obj[11] = new OBJ_Heart();
            gp.obj[11].worldX = 8 * gp.tileSize;
            gp.obj[11].worldY = 40 * gp.tileSize;

            gp.obj[12] = new OBJ_Boot();
            gp.obj[12].worldX = 11 * gp.tileSize;
            gp.obj[12].worldY = 42 * gp.tileSize;

            gp.obj[13] = new OBJ_Boot();
            gp.obj[13].worldX = 39 * gp.tileSize;
            gp.obj[13].worldY = 45 * gp.tileSize;

            gp.obj[14] = new OBJ_Chest();
            gp.obj[14].worldX = 46 * gp.tileSize;
            gp.obj[14].worldY = 31 * gp.tileSize;
        }
        if(gp.level == 2)
        {
            gp.obj[0] = new OBJ_Boot();
            gp.obj[0].worldX = 11 * gp.tileSize;
            gp.obj[0].worldY = 10 * gp.tileSize;

            gp.obj[1] = new OBJ_Heart();
            gp.obj[1].worldX = 8 * gp.tileSize;
            gp.obj[1].worldY = 8 * gp.tileSize;

            gp.obj[2] = new OBJ_Chest();
            gp.obj[2].worldX = 23 * gp.tileSize;
            gp.obj[2].worldY = 46 * gp.tileSize;

            gp.obj[3] = new OBJ_Coin();
            gp.obj[3].worldX = 42 * gp.tileSize;
            gp.obj[3].worldY = 3 * gp.tileSize;

            gp.obj[4] = new OBJ_Coin();
            gp.obj[4].worldX = 37 * gp.tileSize;
            gp.obj[4].worldY = 5 * gp.tileSize;

            gp.obj[5] = new OBJ_Coin();
            gp.obj[5].worldX = 15 * gp.tileSize;
            gp.obj[5].worldY = 15 * gp.tileSize;

            gp.obj[6] = new OBJ_Coin();
            gp.obj[6].worldX = 7 * gp.tileSize;
            gp.obj[6].worldY = 40 * gp.tileSize;

            gp.obj[7] = new OBJ_Coin();
            gp.obj[7].worldX = 35 * gp.tileSize;
            gp.obj[7].worldY = 24 * gp.tileSize;

            gp.obj[8] = new OBJ_Coin();
            gp.obj[8].worldX = 23 * gp.tileSize;
            gp.obj[8].worldY = 23 * gp.tileSize;

            gp.obj[9] = new OBJ_Coin();
            gp.obj[9].worldX = 5 * gp.tileSize;
            gp.obj[9].worldY = 5 * gp.tileSize;

            gp.obj[10] = new OBJ_Coin();
            gp.obj[10].worldX = 42 * gp.tileSize;
            gp.obj[10].worldY = 42 * gp.tileSize;

            gp.obj[11] = new OBJ_Coin();
            gp.obj[11].worldX = 27 * gp.tileSize;
            gp.obj[11].worldY = 11 * gp.tileSize;

            gp.obj[12] = new OBJ_Coin();
            gp.obj[12].worldX = 19 * gp.tileSize;
            gp.obj[12].worldY = 32 * gp.tileSize;

            gp.obj[13] = new OBJ_Boot();
            gp.obj[13].worldX = 44 * gp.tileSize;
            gp.obj[13].worldY = 18 * gp.tileSize;

            gp.obj[14] = new OBJ_Boot();
            gp.obj[14].worldX = 14 * gp.tileSize;
            gp.obj[14].worldY = 27 * gp.tileSize;

            gp.obj[15] = new OBJ_Boot();
            gp.obj[15].worldX = 23 * gp.tileSize;
            gp.obj[15].worldY = 40 * gp.tileSize;

            gp.obj[16] = new OBJ_Heart();
            gp.obj[16].worldX = 27 * gp.tileSize;
            gp.obj[16].worldY = 40 * gp.tileSize;

            gp.obj[17] = new OBJ_Heart();
            gp.obj[17].worldX = 3 * gp.tileSize;
            gp.obj[17].worldY = 43 * gp.tileSize;

            gp.obj[18] = new OBJ_Heart();
            gp.obj[18].worldX = 30 * gp.tileSize;
            gp.obj[18].worldY = 14 * gp.tileSize;
        }
        if(gp.level == 3)
        {
            gp.obj[0] = new OBJ_Boot();
            gp.obj[0].worldX = 28 * gp.tileSize;
            gp.obj[0].worldY = 40 * gp.tileSize;

            gp.obj[1] = new OBJ_Boot();
            gp.obj[1].worldX = 15 * gp.tileSize;
            gp.obj[1].worldY = 12 * gp.tileSize;

            gp.obj[2] = new OBJ_Princess();
            gp.obj[2].worldX = 23 * gp.tileSize;
            gp.obj[2].worldY = 3 * gp.tileSize;

            gp.obj[3] = new OBJ_Coin();
            gp.obj[3].worldX = 42 * gp.tileSize;
            gp.obj[3].worldY = 3 * gp.tileSize;

            gp.obj[4] = new OBJ_Coin();
            gp.obj[4].worldX = 37 * gp.tileSize;
            gp.obj[4].worldY = 5 * gp.tileSize;

            gp.obj[5] = new OBJ_Coin();
            gp.obj[5].worldX = 15 * gp.tileSize;
            gp.obj[5].worldY = 15 * gp.tileSize;

            gp.obj[6] = new OBJ_Coin();
            gp.obj[6].worldX = 7 * gp.tileSize;
            gp.obj[6].worldY = 40 * gp.tileSize;

            gp.obj[7] = new OBJ_Coin();
            gp.obj[7].worldX = 36 * gp.tileSize;
            gp.obj[7].worldY = 25 * gp.tileSize;

            gp.obj[8] = new OBJ_Coin();
            gp.obj[8].worldX = 13 * gp.tileSize;
            gp.obj[8].worldY = 29 * gp.tileSize;

            gp.obj[9] = new OBJ_Coin();
            gp.obj[9].worldX = 43 * gp.tileSize;
            gp.obj[9].worldY = 39 * gp.tileSize;

            gp.obj[10] = new OBJ_Coin();
            gp.obj[10].worldX = 28 * gp.tileSize;
            gp.obj[10].worldY = 39 * gp.tileSize;

            gp.obj[11] = new OBJ_Coin();
            gp.obj[11].worldX = 20 * gp.tileSize;
            gp.obj[11].worldY = 10 * gp.tileSize;

            gp.obj[12] = new OBJ_Coin();
            gp.obj[12].worldX = 4 * gp.tileSize;
            gp.obj[12].worldY = 45 * gp.tileSize;

            gp.obj[13] = new OBJ_Coin();
            gp.obj[13].worldX = 28 * gp.tileSize;
            gp.obj[13].worldY = 38 * gp.tileSize;

            gp.obj[14] = new OBJ_Coin();
            gp.obj[14].worldX = 29 * gp.tileSize;
            gp.obj[14].worldY = 39 * gp.tileSize;

            gp.obj[15] = new OBJ_Coin();
            gp.obj[15].worldX = 29 * gp.tileSize;
            gp.obj[15].worldY = 38 * gp.tileSize;





        }

    }

    public void setNPC()
    {
        gp.npc[0] = new NPC_Dragon(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 5;
    }

    public void setMonster(int lvl)
    {
        if(lvl == 1) {
            gp.monster[0] = new MON_Skeleton(gp);
            gp.monster[0].worldX = gp.tileSize * 10;
            gp.monster[0].worldY = gp.tileSize * 6;

            gp.monster[1] = new MON_Skeleton(gp);
            gp.monster[1].worldX = gp.tileSize * 38;
            gp.monster[1].worldY = gp.tileSize * 27;

            gp.monster[2] = new MON_Skeleton(gp);
            gp.monster[2].worldX = gp.tileSize * 8;
            gp.monster[2].worldY = gp.tileSize * 4;

            gp.monster[3] = new MON_Skeleton(gp);
            gp.monster[3].worldX = gp.tileSize * 38;
            gp.monster[3].worldY = gp.tileSize * 27;

            gp.monster[4] = new MON_Skeleton(gp);
            gp.monster[4].worldX = gp.tileSize * 5;
            gp.monster[4].worldY = gp.tileSize * 40;

            gp.monster[5] = new MON_Skeleton(gp);
            gp.monster[5].worldX = gp.tileSize * 45;
            gp.monster[5].worldY = gp.tileSize * 9;

            gp.monster[6] = new MON_Skeleton(gp);
            gp.monster[6].worldX = gp.tileSize * 9;
            gp.monster[6].worldY = gp.tileSize * 42;
        }

        if(lvl == 2)
        {
            gp.monster[0] = new MON_Penguin(gp);
            gp.monster[0].worldX = gp.tileSize * 10;
            gp.monster[0].worldY = gp.tileSize * 6;

            gp.monster[1] = new MON_Penguin(gp);
            gp.monster[1].worldX = gp.tileSize * 38;
            gp.monster[1].worldY = gp.tileSize * 27;

            gp.monster[2] = new MON_Penguin(gp);
            gp.monster[2].worldX = gp.tileSize * 18;
            gp.monster[2].worldY = gp.tileSize * 4;

            gp.monster[3] = new MON_Penguin(gp);
            gp.monster[3].worldX = gp.tileSize * 38;
            gp.monster[3].worldY = gp.tileSize * 23;

            gp.monster[4] = new MON_Penguin(gp);
            gp.monster[4].worldX = gp.tileSize * 7;
            gp.monster[4].worldY = gp.tileSize * 40;

            gp.monster[5] = new MON_Penguin(gp);
            gp.monster[5].worldX = gp.tileSize * 41;
            gp.monster[5].worldY = gp.tileSize * 9;

            gp.monster[6] = new MON_Penguin(gp);
            gp.monster[6].worldX = gp.tileSize * 12;
            gp.monster[6].worldY = gp.tileSize * 35;
        }
        if(lvl == 3)
        {
            gp.monster[0] = new MON_Minotaur(gp);
            gp.monster[0].worldX = gp.tileSize * 15;
            gp.monster[0].worldY = gp.tileSize * 6;

            gp.monster[1] = new MON_Minotaur(gp);
            gp.monster[1].worldX = gp.tileSize * 38;
            gp.monster[1].worldY = gp.tileSize * 27;

            gp.monster[2] = new MON_Minotaur(gp);
            gp.monster[2].worldX = gp.tileSize * 13;
            gp.monster[2].worldY = gp.tileSize * 4;

            gp.monster[3] = new MON_Minotaur(gp);
            gp.monster[3].worldX = gp.tileSize * 38;
            gp.monster[3].worldY = gp.tileSize * 27;

            gp.monster[4] = new MON_Minotaur(gp);
            gp.monster[4].worldX = gp.tileSize * 5;
            gp.monster[4].worldY = gp.tileSize * 40;

            gp.monster[5] = new MON_Minotaur(gp);
            gp.monster[5].worldX = gp.tileSize * 45;
            gp.monster[5].worldY = gp.tileSize * 9;

            gp.monster[6] = new MON_Minotaur(gp);
            gp.monster[6].worldX = gp.tileSize * 9;
            gp.monster[6].worldY = gp.tileSize * 42;
        }

    }



}
