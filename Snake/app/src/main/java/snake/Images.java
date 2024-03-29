package snake;
/**
 * @author QHYang_Madoka
 * This class is specially used to obtain pictures in the game
 */
import java.net.URL;

import javax.swing.ImageIcon;

public class Images {
    // Encapsulate the path of the image into an object
    public static URL bodyURL = Images.class.getResource("/images/body.png");
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);  

    public static URL downURL = Images.class.getResource("/images/down.png");
    public static ImageIcon downImg = new ImageIcon(downURL);  

    public static URL foodURL = Images.class.getResource("/images/food.png");
    public static ImageIcon foodImg = new ImageIcon(foodURL);  

    public static URL headerURL = Images.class.getResource("/images/header.jpg");
    public static ImageIcon headerImg = new ImageIcon(headerURL);  

    public static URL header2URL = Images.class.getResource("/images/header2.jpg");
    public static ImageIcon header2Img = new ImageIcon(header2URL);  

    public static URL leftURL = Images.class.getResource("/images/left.png");
    public static ImageIcon leftImg = new ImageIcon(leftURL);  

    public static URL rightURL = Images.class.getResource("/images/right.png");
    public static ImageIcon rightImg = new ImageIcon(rightURL);  

    public static URL upURL = Images.class.getResource("/images/up.png");
    public static ImageIcon upImg = new ImageIcon(upURL);  

}
    

