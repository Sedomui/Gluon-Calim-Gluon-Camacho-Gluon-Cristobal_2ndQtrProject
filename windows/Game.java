package windows;

import java.awt.*;

import javax.swing.*;

public class Game extends JFrame {
    public Game() {
        setLayout(new BorderLayout());
        setSize(new Dimension(400, 400));
        
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.cyan);
        centerPanel.setBorder(new LineBorder(Color.black, 3));

            JButton clicker1 = new JButton();
            clicker1.setBackground(Color.PINK);
            JButton clicker2 = new JButton();
            clicker2.setBackground(Color.PINK);
            JButton clicker3 = new JButton();
            clicker3.setBackground(Color.PINK);
        
        centerPanel.add(clicker1);
        centerPanel.add(clicker2);
        centerPanel.add(clicker3);

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }
}
