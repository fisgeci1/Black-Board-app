import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class BoardPanel extends JPanel {
    public BoardPanel() {
    }

    public int width, height;
    private boolean drawBlack = true;
    public static int mousePointX, mousePointY;
    protected static int strokeSize = 10;
    private LinkedHashMap<String, Integer> grid = new LinkedHashMap<>(width * height);
    public static boolean draw = true;

    Color[] colors = {Color.black, Color.white, Color.blue, Color.red, Color.cyan};

    public BoardPanel(int width, int height) {

        this.height = height;
        this.width = width;

        draw = true;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j ++) {
////                System.out.println(i +"==" + j);
//                grid.put(i + "//" + j + "//" + strokeSize  + "//" +  10, 0);
//            }
//        }
//    System.out.println(width*height == grid.size());
    }


    public void paintComponent(Graphics g) {
        if (drawBlack) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, height);
            drawBlack = false;
        } else {
            if (draw) {
                for (Map.Entry<String, Integer> entry : grid.entrySet()) {
//            System.out.println(entry.getKey());
                    ////Paint with the selected  color ///////
                    if (!(entry.getValue().equals(0))) {
                        String[] num = entry.getKey().split("//");
//                System.out.println(entry.getValue());

                        g.setColor(colors[entry.getValue()]);
//                    g.fillRect(Integer.parseInt(num[0]), Integer.parseInt(num[1]), Integer.parseInt(num[2]), Integer.parseInt(num[2]));
//                    g.drawLine(Integer.parseInt(num[0]),Integer.parseInt(num[1]),Integer.parseInt(num[0]),Integer.parseInt(num[1]));
                        Graphics2D g2 = (Graphics2D) g;
                        Rectangle2D rect = new Rectangle2D.Double(Double.parseDouble(num[0]), Double.parseDouble(num[1]), Integer.parseInt(num[2]), Integer.parseInt(num[2]));
                        g2.fill(rect);
                    }

                    ///Erase (Paint black) //////////////////
//        else if (entry.getValue().equals(0)) {
//            String[] num = entry.getKey().split("//");
////                    System.out.println(entry.getValue());
//            g.setColor(colors[entry.getValue()]);
//            Graphics2D g2 = (Graphics2D) g;
//            Rectangle2D rect = new Rectangle2D.Double(Double.parseDouble(num[0]), Double.parseDouble(num[1]), Integer.parseInt(num[2]), Integer.parseInt(num[2]));
//            g2.fill(rect);
////                    g.drawLine(Integer.parseInt(num[0]),Integer.parseInt(num[1]),Integer.parseInt(num[0]),Integer.parseInt(num[1]));
//        }
                }
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, width, height);
                ArrayList<ArrayList<String>> list = DrawOnBoard.getStrokeBuffer();


                for (ArrayList<String> elements : list) {
                    for (String key : elements) {
                        System.out.println("In here");
                        String[] num = key.split("//");
                        g.setColor(colors[Integer.parseInt(num[3])]);
                        Graphics2D g2 = (Graphics2D) g;
                        Rectangle2D rect = new Rectangle2D.Double(Double.parseDouble(num[0]), Double.parseDouble(num[1]), Integer.parseInt(num[2]), Integer.parseInt(num[2]));
                        g2.fill(rect);
                    }
                }
            }
        }
//        g.drawOval(mousePointX,mousePointY,strokeSize,strokeSize);
    }

    public LinkedHashMap<String, Integer> getGrid() {
        return grid;
    }

    public int getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    public void setDrawBlack(boolean drawBlack) {
        System.out.println("In set black");
        this.drawBlack = drawBlack;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

}

