import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Main {

    private static int width, height;
    private final static int MAX_SIZE = 100, MIN_SIZE = 1;

    public static void main(String[] args) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        width = (int) tk.getScreenSize().getWidth();
        height = (int) tk.getScreenSize().getHeight();

        BoardPanel panel = new BoardPanel(width, height);
        Palette pallete = new Palette();
        panel.add(pallete);

        DrawOnBoard drawOnBoard = new DrawOnBoard(panel, panel.getGrid());

        JFrame frame = new JFrame("White Board");
        frame.setResizable(false);
        Container content = frame.getContentPane();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height - 100);


        //Handles  the keyBoard Inputs
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    LinkedHashMap<String, Integer> grid = panel.getGrid();
//                    drawOnBoard.getStrokeBuffer().remove(drawOnBoard.getStrokeBuffer().size()-1);
                    ArrayList<ArrayList<String>> list = drawOnBoard.getStrokeBuffer();

                    ArrayList<String> lastList = list.get(list.size() - 1);
                    ArrayList<String> listToReplace = new ArrayList<>();
                    int arrayLine = 1;
                    int size = list.size();
                    boolean isFirst = true;

//                    for (String key : lastList) {
//                        String[] keyA = key.split("//");
//                        grid.remove(key, Integer.parseInt(keyA[3]));
//                        grid.put(key, 0);
//                        panel.repaint();
//                    }
                    list.remove(size - 1);
                    BoardPanel.draw = false;
//                  size = list.size();
//                    if (size == 0) {
//                        for (String key : lastList) {
//                            System.out.println("In here aaa");
//                            String[] keyA = key.split("//");
//                            grid.put(keyA[0] + "//" + keyA[1] + "//" + keyA[2], 0);
//                            panel.repaint();
//                        }
//                        return;
//                    }
//
//                    for (String key : lastList) {
//                        String[] keyA = key.split("//");
//
//
//                            grid.put(keyA[0] + "//" + keyA[1] + "//" + keyA[2], 0);
//                    }
//                    for (ArrayList<String> elements : list) {
//                    System.out.println("In here");
//                        for (String key1 : elements) {
//                            String[] key2A = key1.split("//");
//
////                            lastList.clear();
//
//
////                            System.out.println(Integer.parseInt(key2A[3]));
//                            grid.put(key2A[0] + "//" + key2A[1] + "//" + key2A[2], Integer.parseInt(key2A[3]));
//                        }
//
//                    }

                    panel.repaint();

                }


                if (e.getKeyCode() == KeyEvent.VK_B) {
                    drawOnBoard.setColor(2);
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    drawOnBoard.setColor(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    drawOnBoard.setColor(3);
                }
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    drawOnBoard.setColor(4);
                }
                if (e.getKeyCode() == KeyEvent.VK_E) {
                    drawOnBoard.setColor(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_P) {
                    int size = BoardPanel.strokeSize;
                    if (size <= MAX_SIZE) {
                        size += 5;
                    }

                    panel.setStrokeSize(size);
                }
                if (e.getKeyCode() == KeyEvent.VK_M) {
                    int size = BoardPanel.strokeSize;
                    if (size - 5 >= MIN_SIZE) {
                        size -= 5;
                    }
                    panel.setStrokeSize(size);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        content.add(panel);
        frame.setVisible(true);
    }

}