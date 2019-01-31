import javax.swing.*;
import java.awt.*;

public class Palette extends BoardPanel {

    private int width = super.width, height = super.height;


    public void paintComponent(Graphics g) {
//        System.out.println("InPaint Component");
        g.setColor(Color.BLUE);
        g.drawRect(10, height - 100, width, 40);
    }
}
