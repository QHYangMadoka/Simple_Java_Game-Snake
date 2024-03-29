package snake;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * @author QHYang_Madoka
 * GamePanel must inherit JPanel before it can have the function of a panel
 * 
 */

public class GamePanel extends JPanel{
    int length;   //Define the length of the snake
    int[] snakeX = new int[200];  //An array specifically used to store the X-axis coordinates of the snake
    int[] snakeY = new int[200];  //An array specifically used to store the Y-axis coordinates of the snake
    String direction;   //initial head direction
    boolean isStart = false;  // The game is paused by default
    Timer timer;

    //Define the coordinates of food
    int foodX;
    int foodY;
    //Define score
    int score;
    boolean isDead = false; //Determine the state of death


    public void init(){
        //Initialize snake length = 3;
        length = 3;
        //Initialize snake head coordinates
        snakeX[0] = 175;
        snakeY[0] = 275;
        //Initialize the coordinates of the first section of the body
        snakeX[1] = 150;
        snakeY[1] = 275;
        //Initialize the coordinates of the second section of the body
        snakeX[2] = 125;
        snakeY[2] = 275;

        direction = "R";  // U D L R


        foodX = 300;
        foodY = 400;

        score = 0;

    }


    public GamePanel(){
        init();
        //Add keyboard event listening
        this.setFocusable(true); 
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int KeyCode =e.getKeyCode();
                System.out.println(KeyCode);
                if (KeyCode == KeyEvent.VK_SPACE){ 
                    if (isDead){
                        //Restart
                        init();
                        isDead = false;
                    } else{   // Space to start or pause
                        isStart = !isStart;
                        repaint();
                    } 
                }

                if (KeyCode == KeyEvent.VK_UP){   // Listen for up arrow
                    direction = "U";
                    repaint();
                }

                if (KeyCode == KeyEvent.VK_DOWN){   // Listen for down arrow
                    direction = "D";
                    repaint();
                }

                if (KeyCode == KeyEvent.VK_LEFT){   // Listen for left arrow
                    direction = "L";
                    repaint();
                }

                if (KeyCode == KeyEvent.VK_RIGHT){   // Listen for right arrow
                    direction = "R";
                    repaint();
                }

            }
        });

        timer = new Timer(150,new ActionListener() {
            //The code for the snake's movement must be placed in the event listener
            @Override
            public void actionPerformed(ActionEvent e){ 
                if (isStart && isDead == false){  // Only listen when the game is started
                    for (int i = length - 1; i>0; i--){
                        snakeX[i] = snakeX[i-1];
                        snakeY[i] = snakeY[i-1];
                    }

                    // move head
                    if ("R".equals(direction)){
                       snakeX[0] += 25;
                    }
                    if ("L".equals(direction)){
                        snakeX[0] -= 25;
                    }
                    if ("U".equals(direction)){
                        snakeY[0] -= 25;
                    }
                    if ("D".equals(direction)){
                        snakeY[0] += 25;
                    }
                    //Prevent snake going out of boundary
                    if (snakeX[0] > 800){
                        snakeX[0] = 25;
                    }
                    if (snakeX[0] < 0){
                        snakeX[0] = 775;
                    }
                    if (snakeY[0]<125){
                        snakeY[0] = 750;
                    }
                    if (snakeY[0] > 775){
                        snakeY[0] = 150; 
                    }

                    //Detect whether the snake has eaten food
                    if (snakeX[0] == foodX && snakeY[0] == foodY){
                        //Length increases by 1
                        length++;
                        //Refresh food coordinates
                        foodX = ((int)(Math.random()*30) + 1) * 25;  //[0, 800]
                        foodY = (new Random().nextInt(25))*25 + 125;  //[125, 775]
                        score += 10;
                    }

                    repaint();
                }

                //Death judgment
                for (int i = 1; i< length; i++){
                    if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                        isDead = true;
                    }
                }

            }
        });    //Initialize timer 
        timer.start();   // start the timer
    }


    /*
     * paintComponent is a special method, it is the main method of the graphics version.
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // Fill background color
        this.setBackground(new Color(226,224,217));

        Images.headerImg.paintIcon(this, g, 10, 10);
        Images.header2Img.paintIcon(this, g, 130, 10);

        g.setColor(new Color(185,222,216));    //set pen color
        g.fillRect(0,125,800,650);  //Draw a rectangle

        //Draw our snake
        if ("R".equals(direction)){
            Images.rightImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("L".equals(direction)){
            Images.leftImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("U".equals(direction)){
            Images.upImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("D".equals(direction)){
            Images.downImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        
        for (int i = 1; i < length; i++){
            Images.bodyImg.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        // If the game is paused, there should be a prompt in the middle of the interface
        if (isStart == false){
            g.setColor(new Color(114,98,255));
            g.setFont(new Font("Arial",Font.BOLD, 40));
            g.drawString("Press space to start!", 250, 300);
        }

        //Paint food
        Images.foodImg.paintIcon(this, g, foodX, foodY);
        //Add score board
        g.setColor(new Color(127,0,225));
        g.setFont(new Font("Arial",Font.BOLD, 30));
        g.drawString("Score: " + score, 620, 50);

        //Game over reminder
        if(isDead){
            g.setColor(new Color(255,128,0));
            g.setFont(new Font("Arial",Font.BOLD, 30));
            g.drawString("Game Over! Press Space to Restart!", 150, 330);
        }


    }
    
}
