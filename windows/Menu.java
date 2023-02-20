package windows;

import javax.swing.*;

import java.awt.*;

public class Menu extends JFrame{
    public Menu() {
        String gameName = "Hooked! Crochet Clicker";
        JButton play, settings, exit;

        JLabel titleText = new JLabel(gameName);
        titleText.setFont(new Font("Verdana", Font.BOLD, 20));
        JPanel titlePanel = new JPanel();
        JPanel east, west, center;

        play = new JButton();
        play.setText("Play");
        play.addActionListener(e -> Main.gameWindow());

        settings = new JButton();
        settings.setText("Settings");
        settings.addActionListener(e -> Main.settingsWindow());

        exit = new JButton();
        exit.setText("Exit");

        center = new JPanel();
        center.setBorder(new LineBorder(Color.black, 3));
        center.setBackground(Color.cyan);
        center.setLayout(new FlowLayout(FlowLayout.CENTER));
        center.add(titleText);
        center.add(play);
        center.add(settings);
        center.add(exit);
        
        east = new JPanel();
        east.setBackground(Color.magenta);
        
        west = new JPanel();
        west.setBackground(Color.magenta);
        
        add(east);
        add(center);
        add(west);

        setSize(400, 400);
        setLayout(new GridLayout(1, 3));
        setVisible(true);
    }
}