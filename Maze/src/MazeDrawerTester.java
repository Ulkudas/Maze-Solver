import java.util.* ;
import java.awt.* ;
import javax.swing.* ;
import java.awt.event.*;

public class MazeDrawerTester
{
    public static void main(String[] args)
    { 
        JFrame myFrame = new JFrame("Maze Drawer");
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.getContentPane().add(new MazeDrawerPanel());
        
        myFrame.pack();
        myFrame.setVisible(true);        
    }
}