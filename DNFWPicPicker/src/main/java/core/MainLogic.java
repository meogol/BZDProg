package core;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Random;

public class MainLogic {
    private   File folder = new File(System.getProperty("user.dir")+"\\img");

    public Image getImage(int id){
        if(!checkDir())
            return null;

        var listFiles = folder.listFiles(new Filter("png,jpg"));

        if(listFiles != null && listFiles.length >=id) {
            try {
                return ImageIO.read(listFiles[id]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return null;
    }

    public Image getRandomImage(){
        if(!checkDir())
            return null;

        var listFiles = folder.listFiles(new Filter("png,jpg"));
        Random rand = new Random();

        if(listFiles == null) return null;

        try {
            return ImageIO.read(listFiles[rand.nextInt(listFiles.length)]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean checkDir() {
        if (!folder.exists())
            return folder.mkdir();

        return true;
    }
    
}
