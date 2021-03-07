package form;

import core.MainLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static javax.swing.JOptionPane.showMessageDialog;

public class NewForm  extends JFrame {
    private UpdJPanel tilePanel = new UpdJPanel();
    private JButton aboutButton = new JButton("О программе");
    private JButton showButton = new JButton("Вывести картинку");
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
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(null,"Разработчики: Слепнёв Алексей Валерьевич и Карелин Евгений Альбертович.\n" +
                        "СПБГУТ им.проф.М.А.Бонч-Бруевича, группа ИКПИ-91, факультет ИКСС.\n" +
                        "Программа выводит случайную картинку из загруженных в папку программы.\n" +
                        "Доступны для вывода только картинки формата *.jpg и *.png.");
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
