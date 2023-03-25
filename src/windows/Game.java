package windows;

import javax.swing.*;

import classes.Player;

import java.awt.*;

/**
 *
 * @authors Alex, Justin
 */

public class Game extends JFrame { 
    
    private JLayeredPane gamePane, menulayer, shoplayer;
    private GameController controller;
    private JPanel container, east, west, center; //Sections of the Game Menu
    private JPanel userBoard, moneyBoard, orders, crochs, cours, timePanel, timeBoard;
    private JPanel orHead, crHead, coHead, orContent, crContent, coContent, userLabels, userButtons;
    private JPanel menuclick, shopclick; //menu and shop button panels
    private JPanel itemClick1, itemClick2, itemClick3; //item panels that the player assigns crocheters to
    private JPanel crochList1, crochList2, crochList3, itemInfo1, itemInfo2, itemInfo3, progress1, progress2, progress3; //item panel components
    private JScrollPane orderBoard, crochBoard, courBoard;
    private JButton menu, shop, inventory, data;
    private JLabel pictureLabel, menubg, shopbg, orTitle, crTitle, coTitle, name, level, money, amount, timer;
    
    // private static Integer lvl = 1, time = 90; //actual variables will be consolidated once the Model classes are introduced
    // private static double cash = 0.0;
    
    private ImageIcon gamebg = new ImageIcon(Game.class.getResource("imgs/genbg2.png"));
    private ImageIcon gray = new ImageIcon(Game.class.getResource("imgs/gray.png"));
    private ImageIcon grey = new ImageIcon(Game.class.getResource("imgs/gray2.png"));
    private ImageIcon gear = new ImageIcon(Game.class.getResource("imgs/gear.png"));
    private ImageIcon knit = new ImageIcon(Game.class.getResource("imgs/knit.png"));
    private ImageIcon bike = new ImageIcon(Game.class.getResource("imgs/bike.png"));
    private ImageIcon home = new ImageIcon(Game.class.getResource("imgs/shop.png"));
    private ImageIcon worker = new ImageIcon(Game.class.getResource("imgs/person.png"));
    private Image grayscale = gray.getImage().getScaledInstance(260,40,Image.SCALE_DEFAULT);
    private Image greyscale = grey.getImage().getScaledInstance(260,250,Image.SCALE_DEFAULT);
    private Image gearscale = gear.getImage().getScaledInstance(38,38,Image.SCALE_SMOOTH);
    private Image knitscale = knit.getImage().getScaledInstance(38,38,Image.SCALE_SMOOTH);
    private Image bikescale = bike.getImage().getScaledInstance(38,38,Image.SCALE_SMOOTH);
    private Image homescale = home.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
    private Image workerscale = worker.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    private Color translucent = new Color(230,230,230,150);
    
    public Game() {
        this.setSize(1010,635);
        this.setTitle("Game Menu");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //((JComponent) this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        Dimension buttondim = new Dimension(260,50);
        Dimension rigid = new Dimension(0,25);
        Font buttonfont = new Font(null,Font.BOLD,30);
        Font smallfont = new Font(null,Font.BOLD,25);
        Font timerfont = new Font(Font.DIALOG_INPUT,Font.BOLD,36);
        
        gamePane = new JLayeredPane() {
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
        };
        container = new JPanel(new BorderLayout());
        container.setPreferredSize(new Dimension(1000,600));
        container.setOpaque(false);
        
        pictureLabel = new JLabel(gamebg);
        
        menulayer = new JLayeredPane() {
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
        };
        menubg = new JLabel(new ImageIcon(grayscale));
        menuclick = new JPanel();
        menuclick.setOpaque(false);
        menu = new JButton("Menu");
        menu.setPreferredSize(buttondim);
        menu.setIcon(new ImageIcon(gearscale));
        menu.setFont(buttonfont);
        menu.setForeground(Color.black);
        menu.setHorizontalAlignment(SwingConstants.LEFT);
        menu.setBorderPainted(false); 
        menu.setContentAreaFilled(false); 
        menu.setFocusPainted(false); 
        menu.setOpaque(false);
        menuclick.add(menu);
        
        menulayer.add(menubg, JLayeredPane.DEFAULT_LAYER);
        menulayer.add(menu, JLayeredPane.PALETTE_LAYER);
        
        menubg.setBounds(0,0,buttondim.width,buttondim.height);
        menu.setBounds(0,0,buttondim.width,buttondim.height);
        
        shoplayer = new JLayeredPane() {
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
        };
        shopbg = new JLabel(new ImageIcon(grayscale));
        shopclick = new JPanel();
        shopclick.setOpaque(false);
        shop = new JButton("Shop");
        shop.setPreferredSize(buttondim);
        shop.setIcon(new ImageIcon(homescale));
        shop.setFont(buttonfont);
        shop.setForeground(Color.black);
        shop.setHorizontalAlignment(SwingConstants.LEFT);
        shop.setBorderPainted(false); 
        shop.setContentAreaFilled(false); 
        shop.setFocusPainted(false); 
        shop.setOpaque(false);
        shopclick.add(shop);
        
        shoplayer.add(shopbg, JLayeredPane.DEFAULT_LAYER);
        shoplayer.add(shop, JLayeredPane.PALETTE_LAYER);
        
        shopbg.setBounds(0,0,buttondim.width,buttondim.height);
        shop.setBounds(0,0,buttondim.width,buttondim.height);
        
        crochs = new JPanel();
        crochs.setLayout(new BoxLayout(crochs, BoxLayout.Y_AXIS));
        crochs.setPreferredSize(new Dimension(260,120));
        crochs.setOpaque(true);
        crochs.setBackground(translucent);
        //crochs.setBorder(BorderFactory.createLineBorder(Color.black,2));
        crHead = new JPanel();
        crHead.setPreferredSize(new Dimension(260,50));
        crHead.setOpaque(false);
        crTitle = new JLabel("Crocheters");
        crTitle.setIcon(new ImageIcon(knitscale));
        crTitle.setFont(buttonfont);
        crTitle.setForeground(Color.black);
        crHead.add(crTitle);
        crContent = new JPanel();
        crContent.setLayout(new BoxLayout(crContent, BoxLayout.Y_AXIS));
        crContent.setPreferredSize(new Dimension(260,200));
        crContent.setOpaque(false);
        
        crochBoard = new JScrollPane(crContent);
        crochBoard.setLayout(new ScrollPaneLayout());
        crochBoard.setOpaque(false);
        crochBoard.getViewport().setOpaque(false);
        crochBoard.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        crochBoard.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        crochs.add(crHead);
        crochs.add(crochBoard);
        
        cours = new JPanel();
        cours.setLayout(new BoxLayout(cours, BoxLayout.PAGE_AXIS));
        cours.setPreferredSize(new Dimension(260,120));
        cours.setOpaque(true);
        cours.setBackground(translucent);
        //cours.setBorder(BorderFactory.createLineBorder(Color.black,2));
        coHead = new JPanel();
        coHead.setPreferredSize(new Dimension(260,50));
        coHead.setOpaque(false);
        coTitle = new JLabel("Couriers");
        coTitle.setIcon(new ImageIcon(bikescale));
        coTitle.setFont(buttonfont);
        coTitle.setForeground(Color.black);
        coHead.add(coTitle);
        coContent = new JPanel();
        coContent.setLayout(new BoxLayout(coContent, BoxLayout.Y_AXIS));
        coContent.setPreferredSize(new Dimension(260,200));
        coContent.setOpaque(false);
                
        courBoard = new JScrollPane(coContent);
        courBoard.setLayout(new ScrollPaneLayout());
        courBoard.setOpaque(false);
        courBoard.getViewport().setOpaque(false);
        courBoard.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        courBoard.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        cours.add(coHead);
        cours.add(courBoard);
 
        west = new JPanel();
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        west.setPreferredSize(new Dimension(260,600));
        west.setOpaque(false);
        west.setBorder(BorderFactory.createLineBorder(Color.black,1));
        
        west.add(Box.createRigidArea(new Dimension(0,5)));
        west.add(menulayer);
        west.add(Box.createRigidArea(new Dimension(0,5)));
        west.add(shoplayer);
        west.add(Box.createRigidArea(new Dimension(0,5)));
        west.add(crochs);
        west.add(Box.createRigidArea(new Dimension(0,10)));
        west.add(cours);
        west.add(Box.createRigidArea(new Dimension(0,5)));
        
        itemClick1 = new JPanel();
        itemClick1.setLayout(new BoxLayout(itemClick1, BoxLayout.Y_AXIS));
        itemClick1.setOpaque(false);
        crochList1 = new JPanel();
        crochList1.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        crochList1.setPreferredSize(new Dimension(400,30));
        crochList1.setOpaque(false);
        itemInfo1 = new JPanel(new GridBagLayout());
        itemInfo1.setPreferredSize(new Dimension(400,95));
        itemInfo1.setBorder(BorderFactory.createLineBorder(Color.black,1));
        progress1 = new JPanel();
        progress1.setPreferredSize(new Dimension(400,25));
        progress1.setBorder(BorderFactory.createLineBorder(Color.black,1));
        
        itemClick1.add(crochList1);
        itemClick1.add(itemInfo1);
        itemClick1.add(progress1);
        
        itemClick2 = new JPanel();
        itemClick2.setLayout(new BoxLayout(itemClick2, BoxLayout.Y_AXIS));
        itemClick2.setOpaque(false);
        crochList2 = new JPanel();
        crochList2.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        crochList2.setPreferredSize(new Dimension(400,30));
        crochList2.setOpaque(false);
        itemInfo2 = new JPanel(new GridBagLayout());
        itemInfo2.setPreferredSize(new Dimension(400,95));
        itemInfo2.setBorder(BorderFactory.createLineBorder(Color.black,1));
        progress2 = new JPanel();
        progress2.setPreferredSize(new Dimension(400,25));
        progress2.setBorder(BorderFactory.createLineBorder(Color.black,1));
        
        itemClick2.add(crochList2);
        itemClick2.add(itemInfo2);
        itemClick2.add(progress2);
        
        itemClick3 = new JPanel();
        itemClick3.setLayout(new BoxLayout(itemClick3, BoxLayout.Y_AXIS));
        itemClick3.setOpaque(false);
        crochList3 = new JPanel();
        crochList3.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        crochList3.setPreferredSize(new Dimension(400,30));
        crochList3.setOpaque(false);
        itemInfo3 = new JPanel(new GridBagLayout());
        itemInfo3.setPreferredSize(new Dimension(400,95));
        itemInfo3.setBorder(BorderFactory.createLineBorder(Color.black,1));
        progress3 = new JPanel();
        progress3.setPreferredSize(new Dimension(400,25));
        progress3.setBorder(BorderFactory.createLineBorder(Color.black,1));
        
        itemClick3.add(crochList3);
        itemClick3.add(itemInfo3);
        itemClick3.add(progress3);
        
        timePanel = new JPanel(new GridBagLayout());
        timePanel.setPreferredSize(new Dimension(400,60));
        timePanel.setOpaque(false);
        timeBoard = new JPanel(new GridBagLayout());
        timeBoard.setPreferredSize(new Dimension(100,50));
        timeBoard.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        timeBoard.setOpaque(true);
        timeBoard.setBackground(Color.black);
        timer = new JLabel(Integer.toString(Player.getTime())); //actual value to be changed
        timer.setFont(timerfont);
        timer.setForeground(Color.red);
        
        timeBoard.add(timer, new GridBagConstraints());
        timePanel.add(timeBoard, new GridBagConstraints());
        
        center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setPreferredSize(new Dimension(490,600));
        center.setOpaque(false);
        
        center.setBorder(BorderFactory.createCompoundBorder(
            (BorderFactory.createLineBorder(Color.black,1)),
            (BorderFactory.createEmptyBorder(20,45,20,45))));
        center.add(itemClick1);
        center.add(Box.createRigidArea(rigid));
        center.add(itemClick2);
        center.add(Box.createRigidArea(rigid));
        center.add(itemClick3);
        center.add(Box.createRigidArea(rigid));
        center.add(timePanel);
        
        name = new JLabel("J9Kp0z", SwingConstants.LEFT); //value to be replaced
        name.setFont(smallfont);
        name.setForeground(Color.black);
        level = new JLabel("Level: " + Player.getLevel(), SwingConstants.LEFT); //value to be replaced
        level.setFont(smallfont);
        level.setForeground(Color.black);
        
        inventory = new JButton("Inventory");
        inventory.setPreferredSize(new Dimension(90,30));
        inventory.setFont(new Font(null,Font.BOLD,16));
        inventory.setForeground(Color.black);
        inventory.setBorder(BorderFactory.createLineBorder(Color.black,2));
        inventory.setOpaque(true);
        inventory.setBackground(new Color(62,167,168));
        
        data = new JButton("Data");
        data.setPreferredSize(new Dimension(60,30));
        data.setFont(new Font(null,Font.BOLD,16));
        data.setForeground(Color.black);
        data.setBorder(BorderFactory.createLineBorder(Color.black,2));
        data.setOpaque(true);
        data.setBackground(new Color(62,167,168));
        
        userBoard = new JPanel(new BorderLayout());
        userBoard.setPreferredSize(new Dimension(260,110));
        //userBoard.setBorder(BorderFactory.createLineBorder(Color.black,1));
        userBoard.setOpaque(true);
        userBoard.setBackground(translucent);
        
        userLabels = new JPanel();
        userLabels.setLayout(new BoxLayout(userLabels, BoxLayout.Y_AXIS));
        userLabels.setPreferredSize(new Dimension(160,100));
        userLabels.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        userLabels.setOpaque(false);
        
        userButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        userButtons.setPreferredSize(new Dimension(120,100));
        userButtons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        userButtons.setOpaque(false);
        
        userLabels.add(name);
        userLabels.add(level);
        userButtons.add(inventory);
        userButtons.add(data);
        
        userBoard.add(userLabels, BorderLayout.WEST);
        userBoard.add(userButtons, BorderLayout.EAST);
        
        orders = new JPanel();
        orders.setLayout(new BoxLayout(orders, BoxLayout.Y_AXIS));
        orders.setPreferredSize(new Dimension(260,340));
        orders.setOpaque(true);
        orders.setBackground(translucent);
        //orders.setBorder(BorderFactory.createLineBorder(Color.black,2));
        orHead = new JPanel();
        orHead.setPreferredSize(new Dimension(260,50));
        orHead.setOpaque(false);
        orTitle = new JLabel("Order Board");
        orTitle.setFont(buttonfont);
        orTitle.setForeground(Color.black);
        orHead.add(orTitle);
        orContent = new JPanel();
        orContent.setLayout(new BoxLayout(orContent, BoxLayout.Y_AXIS));
        orContent.setPreferredSize(new Dimension(260,340));
        orContent.setOpaque(false);
        
        orderBoard = new JScrollPane(orContent);
        orderBoard.setLayout(new ScrollPaneLayout());
        orderBoard.setOpaque(false);
        orderBoard.getViewport().setOpaque(false);
        orderBoard.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        orderBoard.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        orders.add(orHead);
        orders.add(orderBoard);
        
        moneyBoard = new JPanel();
        moneyBoard.setLayout(new BoxLayout(moneyBoard, BoxLayout.Y_AXIS));
        moneyBoard.setPreferredSize(new Dimension(260,110));
        moneyBoard.setOpaque(true);
        moneyBoard.setBackground(translucent);
        moneyBoard.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        money = new JLabel("Currency: ");
        money.setFont(buttonfont);
        money.setForeground(Color.black);
        amount = new JLabel("$" + Player.getYarnCoins(), SwingConstants.LEFT); // value to be replaced
        amount.setFont(smallfont);
        amount.setForeground(Color.black);
        
        moneyBoard.add(money);
        moneyBoard.add(amount);
        
        east = new JPanel();
        east.setLayout(new BorderLayout(0,10));
        east.setPreferredSize(new Dimension(260,600));
        east.setOpaque(false);
        
        east.setBorder(BorderFactory.createCompoundBorder(
            (BorderFactory.createLineBorder(Color.black,1)),
            (BorderFactory.createEmptyBorder(5,0,5,0))));
        east.add(userBoard, BorderLayout.NORTH);
        east.add(orders, BorderLayout.CENTER);
        east.add(moneyBoard, BorderLayout.SOUTH);
        
        container.add(west, BorderLayout.LINE_START);
        container.add(center, BorderLayout.CENTER);
        container.add(east, BorderLayout.LINE_END);
        
        gamePane.add(pictureLabel, JLayeredPane.DEFAULT_LAYER);
        gamePane.add(container, JLayeredPane.PALETTE_LAYER);
        
        pictureLabel.setBounds(0,0,1000,600);
        container.setBounds(0,0,1000,600);
        
        this.add(gamePane);
        this.setVisible(true);
    }
    
    public Component[] getChildren() {
        return this.getContentPane().getComponents();
    }
    public Component getComponent(int index) {
        return this.getContentPane().getComponents()[index];
    }
    
}