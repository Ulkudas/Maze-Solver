
import java.util.* ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class MazeDrawerPanel extends JPanel 
{
    RandomMaze map ;
    MazeCreator mc;
    JPanel matrix; 
    JPanel[][] panels;
    //ImageIcon icon;
    javax.swing.Timer myClock ;
    int step ; 
    String str[] ;
    
    public MazeDrawerPanel()
    {
        step = 1;
        //icon = new ImageIcon("brick.png");
        myClock = new javax.swing.Timer(100, new TimeListener());
        mc = new MazeCreator();
        map = mc.getRandomMaze();
        str = map.getMaze();
        panels = new JPanel[map.getN()][map.getM()];
        matrix = new JPanel();
        matrix.setLayout(new GridLayout(map.getN(),map.getM()));
        
        for ( int i = 0 ; i < map.getN(); ++i)
            for ( int j = 0 ; j < map.getM(); ++j)
            {
                JPanel panel = new JPanel();
                panel.setPreferredSize (new Dimension(500/map.getN(), 500/map.getM()));
                
                if ( i == map.getTarget().x && j == map.getTarget().y)
                    panel.setBackground(Color.orange);
                else if ( i == map.getOrigin().x && j == map.getOrigin().y)
                    panel.setBackground(Color.cyan);
                else if ( str[i].charAt(j) == '#')
                    panel.setBackground(Color.black);
                else 
                    panel.setBackground(Color.white);
                panels[i][j] = panel;
                matrix.add(panel);
            }
        
        myClock.start();
        setPreferredSize (new Dimension(500, 500));
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
                JPanel holder = panels[mc.getSolution().getMazeSolution()[step].x][mc.getSolution().getMazeSolution()[step].y] ;
                holder.setBackground(Color.red);
                step ++ ;
            }
        }
    }
}