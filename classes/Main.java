package classes;

import javax.swing.JFrame;

public class Main {
    public static JFrame window;
    public static void main(String[] args) {
        System.out.println("menuWindowTest");
        window = new Menu();
    }
    public static void gameWindow() {
        window = new Game();
    }
    public static void settingsWindow() {
        window = new Settings();
    }
}