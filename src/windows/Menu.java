package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Justin
 */
public class Menu extends JFrame {
    
    private JLayeredPane menuPane;
    private MenuController controller;
    private final JPanel boxPanel, pb, qb; //consolidated to remove settings button
    private JLabel titleLabel, pictureLabel;
    private final JButton play, quit;
    
    private ImageIcon background = new ImageIcon(Menu.class.getResource("imgs/menubg.png"));
    private ImageIcon title = new ImageIcon(Menu.class.getResource("imgs/title.png"));
    private Image bgscale = background.getImage().getScaledInstance(801,450,Image.SCALE_SMOOTH);
    
    public Menu() {
        
        this.setTitle("Main Menu");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(801,450);
        this.setResizable(false);
        
        menuPane = new JLayeredPane() {
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
        };
        
        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.setPreferredSize(new Dimension(471,270));
        boxPanel.setOpaque(false);
        
        titleLabel = new JLabel();
        titleLabel.setIcon(title);
        
        pictureLabel = new JLabel();
        pictureLabel.setIcon(new ImageIcon(bgscale));
        
        Dimension buttonsize = new Dimension(200,30);
        
        pb = new JPanel();
        pb.setOpaque(false);
        play = new JButton("Play");
        play.setPreferredSize(buttonsize);
        play.setFont(new Font("Verdana", Font.BOLD, 12));
        play.setOpaque(true);
        play.setBackground(Color.white);
        pb.add(play);
        
        qb = new JPanel();
        qb.setOpaque(false);
        quit = new JButton("Quit");
        quit.setPreferredSize(buttonsize);
        quit.setFont(new Font("Verdana", Font.BOLD, 12));
        quit.setOpaque(true);
        quit.setBackground(Color.white);
        qb.add(quit);
        
        boxPanel.add(titleLabel);
        boxPanel.add(Box.createRigidArea(new Dimension(0,30)));
        boxPanel.add(pb);
        boxPanel.add(qb);
        
        menuPane.add(pictureLabel, JLayeredPane.DEFAULT_LAYER);
        menuPane.add(boxPanel, JLayeredPane.PALETTE_LAYER);
        
        Insets insets = menuPane.getInsets();
        Dimension bpdim = boxPanel.getPreferredSize();
        Dimension pldim = pictureLabel.getPreferredSize();
        
        pictureLabel.setBounds(0,0,pldim.width,pldim.height);
        boxPanel.setBounds(insets.left+165,insets.top+90,bpdim.width,bpdim.height);
        
        controller = new MenuController(this, play, quit);
        play.addActionListener(controller);
        quit.addActionListener(controller);
        this.addWindowListener(controller);
        
        this.add(menuPane);
        this.setVisible(true);
    }
}
