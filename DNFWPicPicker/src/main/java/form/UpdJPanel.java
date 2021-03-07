package form;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UpdJPanel extends JPanel {
    BufferedImage image;

    @Override
    public void paintComponent(Graphics g){
        if(image == null) return;
        g.drawImage(image.getScaledInstance(
                this.getWidth(), this.getHeight(),0),
                0, 0, this);
    }

    public void updateBuffer(BufferedImage image){
        if(image == null) return;

        this.image=image;
        repaint();
    }
}
