package windows;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Justin
 */
public class MenuController implements ActionListener, WindowListener {
    
    private JFrame menu;
    private JButton play, quit;
    private Game gameScreen;
    
    public MenuController(JFrame m, JButton p, JButton q) {
        menu = m;
        play = p;
        quit = q;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play) {
            gameScreen = new Game();
            menu.dispose();
        }
        else if(e.getSource() == quit) {
            windowClosing(null);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        String ObjButtons[] = {"Yes","No"};
        int PromptResult = JOptionPane.showOptionDialog(
            null,
            "Are you sure you want to quit?",
            "Confirm Exit",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.WARNING_MESSAGE,null,
            ObjButtons,
            ObjButtons[1]
        );

        if(PromptResult==JOptionPane.YES_OPTION){
            System.exit(0);
        }  
    }

    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
}
