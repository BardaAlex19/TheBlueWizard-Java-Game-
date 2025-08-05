package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Princess extends SuperObject {
    public OBJ_Princess() {
        name = "Princess";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/princess1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
