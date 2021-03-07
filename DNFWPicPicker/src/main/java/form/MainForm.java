package form;

import core.MainLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;

import static javax.swing.JOptionPane.showMessageDialog;

public class MainForm extends JFrame {
    private JPanel panel1;
    private JButton aboutButton;
    private JButton showButton;
    public MainLogic mainLogic = new MainLogic();

    public MainForm(String title){
    super(title);

    setContentPane(panel1);
    getRootPane().setDefaultButton(showButton);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage();
            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            showRandomPic();
            }
        });
    }
    public void showMessage(){
        showMessageDialog(this,"Разработчики: Слепнёв Алексей Валерьевич и Карелин Евгений Альбертович.\n" +
                "СПБГУТ им.проф.М.А.Бонч-Бруевича, группа ИКПИ-91, факультет ИКСС.\n" +
                "Программа выводит случайную картинку из загруженных в папку программы.\n" +
                "Доступны для вывода только картинки формата *.jpg и *.png.");
    }
    public void showRandomPic(){
        Image image = mainLogic.getRandomImage();
        ImageIcon img = new ImageIcon(image);
        JLabel imgLabel = new JLabel(img);
        showMessageDialog(null, imgLabel);
    }

    public static void main(String[] args) {
        MainForm dialogFirst = new MainForm("DNFWPicPicker");
        dialogFirst.pack();
        dialogFirst.setLocationRelativeTo(null);
        dialogFirst.setVisible(true);
    }
}
