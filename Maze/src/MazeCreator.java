import java.util.* ;

public class MazeCreator
{
    RandomMaze maze;
    MazeSolver solution; 
    
    public MazeCreator()
    {
        do
        {
            maze = new RandomMaze();
            solution = new MazeSolver(maze);
        }while( solution.getMinStep() == 50);
    
    }
    
    RandomMaze getRandomMaze(){ return maze ; }
    MazeSolver getSolution(){ return solution ; }
}