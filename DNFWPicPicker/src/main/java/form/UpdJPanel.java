package form;

import org.imgscalr.Scalr;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UpdJPanel extends JPanel {
    private BufferedImage image;

    @Override
    public void paintComponent(Graphics g) {
        if (image == null) return;

        BufferedImage resizedImg = Scalr.resize(image, Scalr.Method.QUALITY,
                this.getWidth(), this.getHeight());
        g.clearRect(0,0,this.getWidth(), this.getHeight());

        g.drawImage(resizedImg, (this.getWidth()-resizedImg.getWidth())/2,
                (this.getHeight()-resizedImg.getHeight())/2, this);

    }

    public static BufferedImage getScaledImage(BufferedImage image, int width, int height) throws IOException {
        int imageWidth  = image.getWidth();
        int imageHeight = image.getHeight();

        double scaleX = (double)width/imageWidth;
        double scaleY = (double)height/imageHeight;
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

        return bilinearScaleOp.filter(
                image,
                new BufferedImage(width, height, image.getType()));
    }


    public void updateBuffer(BufferedImage image){
        if(image == null) return;

        this.image=image;
        repaint();
    }
}
