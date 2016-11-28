

import java.util.* ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class MazeDrawerPanel2 extends JPanel 
{
    RandomMaze map ;
    MazeCreator mc;
    JPanel matrix; 
    JLabel[][] labels;
    ImageIcon cobble, wall , road;
    javax.swing.Timer myClock ;
    int step ; 
    String str[] ;
    
    public MazeDrawerPanel2()
    {
        step = 0;
        
        cobble = new ImageIcon("Cobble.jpg");
        wall = new ImageIcon("Wall.png");
        road = new ImageIcon("Road.jpg");
        
        myClock = new javax.swing.Timer(100, new TimeListener());
       
        mc = new MazeCreator();
        map = mc.getRandomMaze();
        str = map.getMaze();
        
        labels = new JLabel[map.getN()][map.getM()];
        
        matrix = new JPanel();
        matrix.setLayout(new GridLayout(map.getN(),map.getM()));
        
        for ( int i = 0 ; i < map.getN(); ++i)
            for ( int j = 0 ; j < map.getM(); ++j)
            {
                labels[i][j] = new JLabel();
                
                if ( str[i].charAt(j) == '#')
                    labels[i][j].setIcon(wall);
                else 
                    labels[i][j].setIcon(cobble);
                
 
                matrix.add(labels[i][j]);
            }
        
        myClock.start();
        setPreferredSize (new Dimension(40*map.getN(), 40*map.getN()));
        setBackground (Color.black);
        add(matrix);
        
    } 
    
    private class TimeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if ( step == mc.getSolution().getMinStep())
                myClock.stop();
            else
            {
                JLabel holder = labels[mc.getSolution().getMazeSolution()[step].x][mc.getSolution().getMazeSolution()[step].y] ;
                holder.setIcon(road);
                step ++ ;
            }
        }
    }
}