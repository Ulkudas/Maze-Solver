
import java.util.*;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class MazeSolver
{
    
    String[] myMaze ;
    public Point[] mazeSolution ;
    Point[] currentPath ;
    int n, m, minStep ;
    int targetX, targetY ;
    boolean[][] hash ;
    final int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}} ;
  
    public MazeSolver( RandomMaze givenMaze) 
    {
       myMaze = givenMaze.getMaze() ;
       mazeSolution = new Point[55] ;
       currentPath = new Point[55] ;
       
       minStep = 50 ;
       
       n = givenMaze.getN() ;
       m= givenMaze.getM() ;
       
       hash = new boolean[n][m] ;
       
       for ( int i = 0 ; i < n ; ++i)
           for ( int j = 0; j < m ; ++j)
               hash[i][j] = false ;
           
       targetX = givenMaze.getTarget().x ;
       targetY = givenMaze.getTarget().y ;
       
       DFS(givenMaze.getOrigin().x, givenMaze.getOrigin().y, 0) ;
 
       
    }
   
    private void DFS ( int x, int y, int step)
    {
       
        if ( step >= minStep) return ;
        
        if ( x == targetX && y == targetY)
        {

            minStep = step ;
            for ( int i = 0 ; i < step ; ++i)
                mazeSolution[i] = currentPath[i] ;
            mazeSolution[step] = new Point(x,y) ;
            minStep ++ ;
            return ;
        }
        
        hash [x][y] = true ;
        
        for ( int i = 0 ; i < 4; ++i)
        {
            int k = x + direction[i][0] ;
            int t = y + direction[i][1] ;
            
            if ( k >= 0 && k < n && t >= 0 && t < m)
                if ( !hash[k][t] && myMaze[k].charAt(t) != '#')
                {
                    currentPath[step] = new Point(x,y) ;
                    DFS(k,t,step + 1) ;
                }
        }
        
        hash[x][y] = false ;
    }
    
    public int getMinStep(){ return minStep ; }
    public Point[] getMazeSolution(){ return mazeSolution ; }
    
   

}