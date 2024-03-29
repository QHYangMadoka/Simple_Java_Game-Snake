package snake;

import javax.swing.*;
import java.awt.Toolkit;
public class StartGame {
    //This is a main method, the entry point of the program
    public static void main(String[] args){
        JFrame jf = new JFrame();

        jf.setTitle("Snake by QHYang_Madoka");  

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        jf.setBounds((width-800)/2,(height-800)/2,800,800);   // a square window
        jf.setVisible(true);    // Set the window to be visible
        jf.setResizable(false);   //Set window size is not adjustable

        //Create panel
        GamePanel gp = new GamePanel();
        //Put the panel into the window
        jf.add(gp);

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   // Close the window and the program will exit
        
    }


    
}
