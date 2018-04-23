// Christopher Lawrence
// assignment 7
// 4-18-17

import java.util.*;
import java.awt.Point;
import java.util.LinkedList;

public class YourMazeWithPath
{       
    private InputGraphicMaze maze;
    private int R, C;  
	  private boolean visited[][];

    public YourMazeWithPath() 
    {       
       // an R rows x C columns maze
       maze = new InputGraphicMaze();
       R=maze.Rows(); C=maze.Cols();  
       visited = new boolean[R][C];
       // Path holds the cells of the path
       LinkedList<Point> Path = new LinkedList<Point>();
       // Create the path
       CreatePath(maze, 1, 1, R, C, Path);
       // show the path in the maze
       maze.showPath(Path);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow and ecol),  in L
    public boolean CreatePath(InputGraphicMaze maze,      
      int srow, int scol, int erow, int ecol, LinkedList<Point> P)
    {
		int r = srow, c = scol;

		visited[r-1][c-1]=true;
    // add to path
    P.addFirst(new Point(r,c));
    // if at end
		if((srow==erow)&&(scol==ecol))
			return true;

    // left
		if((c > 1) && (maze.can_go(r,c,'L')) && (!(visited[r-1][c-2])))
			if(CreatePath(maze,r,c-1,erow,ecol,P))
        return true;
    // right
		if((c < ecol) && (maze.can_go(r,c,'R')) && (!(visited[r-1][c])))
			if(CreatePath(maze,r,c+1,erow,ecol,P))
        return true;
    // up
    if((r > 1) && (maze.can_go(r,c,'U')) && (!(visited[r-2][c-1])))
      if(CreatePath(maze,r-1,c,erow,ecol,P))
        return true;
    // down
    if((r < erow) && (maze.can_go(r,c,'D')) && (!(visited[r][c-1])))
      if(CreatePath(maze,r+1,c,erow,ecol,P))
        return true;

    // remove from path
    P.removeFirst();
		return false;
    }

    public static void main(String[] args)
    {new YourMazeWithPath();}
}
