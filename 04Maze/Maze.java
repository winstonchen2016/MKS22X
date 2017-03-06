import java.util.*;
import java.io.*;

public class Maze{

    private char[][] maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
        animate = false;
	ArrayList<String> lines = new ArrayList<String>();
	int numRows = 0;
	int numCols = 0;
	int numE = 0;
	int numS = 0;
	try{
	    File text = new File(filename); 
	    Scanner inf = new Scanner(text);
	    while(inf.hasNextLine()){
		numRows ++;
		String l = inf.nextLine();
		lines.add(l);
		//System.out.println(lines.toString());
	    }
	    for(int i = 0; i < lines.get(0).length(); i++){
		numCols++;
	    }
	    maze = new char[numRows][numCols];
	    for(int r = 0; r < maze.length; r++){
		for(int c = 0; c < maze[0].length; c++){
		    maze[r][c] = lines.get(r).charAt(c);
		    if(maze[r][c] == 'S'){
			numS += 1;
		    }
		    if(maze[r][c] == 'E'){
			numE += 1;
		    }
		}
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path.");
	    System.exit(1);
	}
	if(numE != 1 || numS != 1){
	    System.out.println("Maze requires exactly one E and exactly one S.");
	    System.exit(1);
	}
    }
    
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
    
    public void setAnimate(boolean b){
        animate = b;
    }
    
    
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
    
    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int startr=-1,startc=-1;

	//Initialize starting row and startint col with the location of the S.
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		if(maze[r][c] == 'S'){
		    startr = r;
		    startc = c;
		}
	    }
	}
	maze[startr][startc] = ' ';//erase the S, and start solving!
	return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

      The S is replaced with '@' but the 'E' is not.

      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
        if(maze[row][col] == 'E'){
	    return true;
	}
	else if(maze[row][col] == '#' || maze[row][col] == '.' || maze[row][col] == '@'){
	    return false;
	}
	else{
	    maze[row][col] = '@';
	    if(solve(row + 1, col) || solve(row - 1, col) || solve(row, col + 1) || solve(row, col - 1)){
		return true;
	    }
	    else{
		maze[row][col] = '.';
	    }
	}
        return false; //so it compiles
    }

    public String toString(){
	String s = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		s += maze[r][c];
	    }
	    s += '\n';
	}
	return s;
    }
}
