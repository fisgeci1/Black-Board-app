import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class DrawOnBoard {
    private JPanel board;
    private LinkedHashMap<String, Integer> grid;
    private int buffer;
    private ArrayList<String> strokes = new ArrayList<>();
    private static  ArrayList<ArrayList<String>> strokeBuffer = new ArrayList<>();
    int num = 0;
    private int color = 1;
    public static int layer = 0;


    public DrawOnBoard(JPanel board, LinkedHashMap<String, Integer> grid) {
        this.board = board;
        this.grid = grid;

        /////////Handles the mouse   input ////////////////////////////
        board.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(MouseInfo.getPointerInfo().getLocation());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int size = 0;
                if (x >= 0 && y >= 0) {

                    size = BoardPanel.strokeSize;
                    PointerInfo mouse = MouseInfo.getPointerInfo();
                    String key = (mouse.getLocation().getX()) + "//" + (mouse.getLocation().getY()) + "//" + size;
                    String key2 = (mouse.getLocation().getX()) + "//" + (mouse.getLocation().getY()) + "//" + size + "//"+color;


                    BoardPanel.draw = true;
                    strokes.add(key2);
                    grid.put(key, color);
                    board.repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                strokeBuffer.add(strokes);
                System.out.println(strokes);

//                System.out.println(strokeBuffer.get(strokeBuffer.size() - 1));
                strokes = new ArrayList<>();

                grid.clear();
                BoardPanel.draw = false;
                board.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        /////////////Handles the mouse movement ////////////////////////

        board.addMouseMotionListener(new MouseAdapter() {


            @Override
            public void mouseDragged(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();
                int size = 0;
                if (x >= 0 && y >= 0) {
                    size = BoardPanel.strokeSize;


                    PointerInfo mouse = MouseInfo.getPointerInfo();
//                    System.out.printf("%f -%f",mouse.getLocation().getX(),mouse.getLocation().getY());

                    String key = (mouse.getLocation().getX()) + "//" + (mouse.getLocation().getY()) + "//" + size;
                    String key2 = (mouse.getLocation().getX()) + "//" + (mouse.getLocation().getY()) + "//" + size + "//" + color;


                    BoardPanel.draw = true;
                    strokes.add(key2);
                    grid.put(key, color);
                    board.repaint();
                }
            }
        });
//        board.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                BoardPanel.mousePointX = e.getX();
//                BoardPanel.mousePointY = e.getY();
//            }
//        });

    }

    private void setGrid(int x, int y) {
        board.repaint();
    }

    public void setColor(int color) {
        this.color = color;
    }

    public static ArrayList<ArrayList<String>> getStrokeBuffer() {
        return strokeBuffer;
    }
}
