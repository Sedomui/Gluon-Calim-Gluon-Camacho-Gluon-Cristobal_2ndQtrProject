package windows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

/**
 *
 * @authors Jacob, Justin
 */
public class Shop extends JFrame {
    
    private JPanel titlePanel = new JPanel();
    private ShopController controller;
    private JPanel upgradePanel = new JPanel(); //includes buy boxes and left and right buttons
    private JPanel buyPanel = new JPanel();
    private JLabel shopTitle = new JLabel("Shop");
    private GridLayout buyPanelGrid = new GridLayout();
    private ImageIcon prevImg = new ImageIcon("src/windows/imgs/back.png");
    private ImageIcon nextImg = new ImageIcon("src/windows/imgs/next.png");
    private JLabel next = new JLabel(nextImg);
    private JLabel prev = new JLabel(prevImg);
    
    private JLayeredPane shopPane = new JLayeredPane() {
        @Override
        public boolean isOptimizedDrawingEnabled() {
            return false;
        }
    };
   
    private ImageIcon background = new ImageIcon(Shop.class.getResource("imgs/genbg.png"));
    private JLabel pictureLabel = new JLabel(background);
  
    public Shop() {
        
        this.setTitle("Shop Menu");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLayout(new BorderLayout(20,30));

        titlePanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        titlePanel.setPreferredSize(new Dimension(740,450));
        titlePanel.setBackground(new Color(217, 217, 217));
        this.add(shopPane, BorderLayout.CENTER);

        titlePanel.setLayout(new BorderLayout());

        ImageIcon shopIcon = new ImageIcon("src/windows/imgs/shop.png");
        Image image = shopIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); 
        shopIcon = new ImageIcon(newimg); 

        shopTitle.setIcon(shopIcon);
        shopTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        titlePanel.add(shopTitle, BorderLayout.NORTH);

        upgradePanel.setBackground(new Color(203, 203, 203));
        upgradePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        upgradePanel.setLayout(new BorderLayout(25, 0));

        prev.setPreferredSize(new Dimension(75,75));
        next.setPreferredSize(new Dimension(75,75));

        
        upgradePanel.add(prev, BorderLayout.WEST);
        upgradePanel.add(next, BorderLayout.EAST);
        upgradePanel.add(buyPanel, BorderLayout.CENTER);

        buyPanelGrid.setVgap(20);
        buyPanelGrid.setHgap(20);

        buyPanel.setLayout(buyPanelGrid);
        buyPanel.setOpaque(false);

        JPanel left = UpgBuyPanel();
        JPanel mid = UpgBuyPanel();
        JPanel right = UpgDetailPanel();
        buyPanel.add(left);
        buyPanel.add(mid);
        buyPanel.add(right);
        
        titlePanel.add(upgradePanel, BorderLayout.CENTER);
        
        shopPane.add(pictureLabel, JLayeredPane.DEFAULT_LAYER);
        shopPane.add(titlePanel, JLayeredPane.PALETTE_LAYER);

        Insets insets = shopPane.getInsets();
        Dimension bgdim = pictureLabel.getPreferredSize();
        Dimension tpdim = titlePanel.getPreferredSize();

        pictureLabel.setBounds(0, 0, bgdim.width, bgdim.height);
        titlePanel.setBounds(insets.left+20,insets.top+60,tpdim.width,tpdim.height);
        
        this.setVisible(true);
    }
    
    public JPanel UpgBuyPanel(){
        JPanel upgPanel = new JPanel();
        upgPanel.setBackground(new Color(142, 225, 239));
        upgPanel.setLayout(new BorderLayout());

        JPanel upgTitlePanel = new JPanel();
        upgTitlePanel.setLayout(new GridLayout(2,1));

        JLabel upgName = new JLabel("Multiplier");
        upgName.setFont(new Font("Verdana", Font.BOLD, 23));
        JLabel upgStat = new JLabel("2x");
        upgStat.setFont(new Font("Verdana", Font.BOLD, 23));

        upgTitlePanel.add(upgName);
        upgTitlePanel.add(upgStat);

        upgPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        upgTitlePanel.setOpaque(false);
        upgTitlePanel.setBorder(new EmptyBorder(5,10,0,10));
        upgTitlePanel.setPreferredSize(new Dimension(65, 65));

        ImageIcon icon = new ImageIcon("src/windows/imgs/multiplierIcon.png");
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); 
        icon = new ImageIcon(newimg); 

        JLabel upgIcon = new JLabel();
        upgIcon.setIcon(icon);

        JLabel upgCost = new JLabel("69420 YC", SwingConstants.CENTER);
        upgCost.setOpaque(true);
        upgCost.setBackground(new Color(74, 68, 67));
        upgCost.setBorder(new EmptyBorder(10, 0, 10, 0));
        upgCost.setFont(new Font("Verdana", Font.BOLD, 20));
        upgCost.setForeground(new Color(230, 230, 230));
        
        upgPanel.add(upgTitlePanel, BorderLayout.NORTH);
        upgPanel.add(upgIcon, BorderLayout.CENTER);
        upgPanel.add(upgCost, BorderLayout.SOUTH);
        return upgPanel;
    }
    
    public JPanel UpgDetailPanel(){
        JPanel detailPanel = new JPanel();
        detailPanel.setBackground(new Color(142, 225, 239));
        detailPanel.setLayout(new BorderLayout());

        JLabel upgDetail = new JLabel("", SwingConstants.CENTER);
        upgDetail.setBorder(new EmptyBorder(10, 10, 10, 10));
        upgDetail.setFont(new Font("Verdana", Font.PLAIN, 9));
        upgDetail.setText("<html>" + "The video game Sa Atin, although released back in 2018, exploded in popularity in 2020, becoming a cultural milestone that will surely be remembered for centuries to come. In fact, many sociologists posit that Sa Atin represents the peak of human achievement. All stories that follow will forever live in the shadow cast by this titan. And no game will ever be deemed perfect again, stained by the sin of simply not being Sa Atin. Not to mention the meme culture! Hahaha! Hilarious! Whenever I see any object with a passing resemblance to a Manlilinlang, I burst into uncontrollable laughter." + "</html>");

        detailPanel.add(upgDetail, BorderLayout.CENTER);
        detailPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        return detailPanel;
    }
}
