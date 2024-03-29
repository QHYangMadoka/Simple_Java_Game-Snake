package snake;

import java.net.URL;
import javax.swing.ImageIcon;

public class Test {
    public static URL headerURL = Test.class.getResource("/");
    public static ImageIcon headerImg = new ImageIcon(headerURL);  

    public static void main(String[] args) {
        System.out.println("Body Image URL: " + headerURL);
    }

    // 其他图片资源的定义与上面类似...
}


