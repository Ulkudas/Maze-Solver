import java.lang.Math;
import java.util.* ; 
import java.awt.* ; 
public class RandomMaze
{
    String[] maze ;
    int n, m, cnt, originX, originY, targetX, targetY;
    
    public RandomMaze()
    {
        n = 15 + (int)(Math.random()*2);
        m = n;
        
        maze = new String[n];
        for ( int i = 0 ; i < n ; ++i)
            maze[i] = "";
        do
        {
            originX = 0;//(int)(Math.random()*(n-1));
            originY = 0;//(int)(Math.random()*(m-1));
            
            targetX = n-1;//(int)(Math.random()*(n-1));
            targetY = n-1;//(int)(Math.random()*(m-1));
        
        } while(targetX == originX && targetY == originY);
       
        for ( int i = 0 ; i < n; ++i)
        {    
            for ( int j =0 ; j < m; ++j)
            {
               if ( i == targetX && j == targetY)
                   maze[i] += 'Y';
               else if ( i == originX && j == originY)
                   maze[i] += 'X';
               else if ( Math.random() >= 0.4)
                   maze[i] += '#';
               else
                   maze[i] += '*';
                  
            }
            
        }
        
    }
    
    Point getTarget(){ return new Point(targetX, targetY); }
    Point getOrigin(){ return new Point(originX, originY); }
    int getN(){ return n; }
    int getM(){ return m; }
    String[] getMaze(){ return maze; }
}