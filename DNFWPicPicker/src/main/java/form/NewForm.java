package form;

import core.MainLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class NewForm  extends JFrame {
    private UpdJPanel tilePanel = new UpdJPanel();
    private JButton aboutButton = new JButton("");
    private JButton showButton = new JButton("showButton");
    private MainLogic mainLogic = new MainLogic();


    NewForm(){
        super("Chess");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,100,800,600);
        add(tilePanel, BorderLayout.CENTER);
        add(aboutButton, BorderLayout.NORTH);
        add(showButton, BorderLayout.SOUTH);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRandomPic();
            }
        });
    }

    public void showRandomPic(){
        BufferedImage image = mainLogic.getRandomImage();

        tilePanel.updateBuffer(image);

    }


    public static void main(String[] args) {
        NewForm c = new NewForm();
        c.setVisible(true);
    }

}
