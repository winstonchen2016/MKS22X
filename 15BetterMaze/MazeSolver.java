import java.util.*;

public class MazeSolver{

    private Maze maze;
    private Frontier f;
    private boolean animate;
    private boolean aStar = false;

    MazeSolver(String filename) {
	this(filename,false);
    }
    
    MazeSolver(String filename, boolean animate){ //filename - input name of the maze file, animate - true for animating your maze.
	maze = new Maze(filename);
	this.animate = animate;
    }

    public void solve(){
	solve(1);
    }
    
    public void solve(int style){ //style is 0-3, where 0-DFS, 1-BFS , 2-BestFirst, 3-A*
	boolean solved = false;
	if(style == 0){
	    f = new FrontierStack();
	}
	else if(style == 1){
	    f = new FrontierQueue();
	}
	else if(style == 2){
	    f = new FrontierPriorityQueue();
	}
	else if(style == 3){
	    f = new FrontierPriorityQueue();
	    aStar = true;
	}
	else{
	    throw new IndexOutOfBoundsException("The input must be between 0 and 3. 0-DFS, 1-BFS , 2-BestFirst, 3-A*");
	}
	f.add(maze.getStart());
	while(f.size() > 0 && !solved){
	    Location current = f.next();
	    if(current.getRow() == maze.getEnd().getRow() && current.getCol() == maze.getEnd().getCol()){ //if solved, then trace back to start with '@'
		solved = true;
		while(current.getPrevious() != null){
		    maze.set(current.getRow(), current.getCol(), '@');
		    current = current.getPrevious();
		}
		maze.set(current.getRow(), current.getCol(), '@');
		if(animate){
		    System.out.println(maze.toString(0));
		}
		return;
	    }
	    maze.set(current.getRow(), current.getCol(), '.'); //sets traversed spaces to '.'
	    for(Location n : getNeighbors(current, aStar)){ //if not solved, add valid neighbors to frontier and process those
		f.add(n);
		maze.set(n.getRow(), n.getCol(), '?'); //sets frontier spaces to '?'
	    }
	    if(animate){
		System.out.println(maze.toString(50));
	    }
	}
    }

    private ArrayList<Location> getNeighbors(Location l, boolean b){
	ArrayList<Location> ans = new ArrayList<Location>();
	//if an adjacent space is empty, add it to the arraylist
	if(maze.get(l.getRow() + 1, l.getCol()) == ' '){
	    ans.add(new Location(l.getRow() + 1, l.getCol(), l, calcDistToStart(l), calcDistToEnd(l), aStar));
	}
	if(maze.get(l.getRow(), l.getCol() + 1) == ' '){
	    ans.add(new Location(l.getRow(), l.getCol() + 1, l, calcDistToStart(l), calcDistToEnd(l), aStar));
	}
	if(maze.get(l.getRow() - 1, l.getCol()) == ' '){
	    ans.add(new Location(l.getRow() - 1, l.getCol(), l, calcDistToStart(l), calcDistToEnd(l), aStar));
	}
	if(maze.get(l.getRow(), l.getCol() - 1) == ' '){
	    ans.add(new Location(l.getRow(), l.getCol() - 1, l, calcDistToStart(l), calcDistToEnd(l), aStar));
	}
	return ans;
    }
    
    private int calcDistToStart(Location l){
	int startR = maze.getStart().getRow();
	int startC = maze.getStart().getCol();
	int row = l.getRow();
	int col = l.getCol();
	return Math.abs(startR - row) + Math.abs(startC - col);
    }

    private int calcDistToEnd(Location l){
	int endR = maze.getEnd().getRow();
	int endC = maze.getEnd().getCol();
	int row = l.getRow();
	int col = l.getCol();
	return Math.abs(endR - row) + Math.abs(endC - col);
    }
    
    public String toString(){ //calls the toString of the maze instanceVariable.
	return maze.toString();
    }
    
    public String toString(int ms){ //call the toString of the maze instanceVariable that takes an int parameter.
	return maze.toString(ms);
    }

    public static void main(String[] args){
	//testing each maze with every algorithm
	/*
	MazeSolver a0 = new MazeSolver("data1.txt", true);
	a0.solve(0);
	MazeSolver a1 = new MazeSolver("data1.txt", true);
	a1.solve(1);
	MazeSolver a2 = new MazeSolver("data1.txt", true);
	a2.solve(2);
	MazeSolver a3 = new MazeSolver("data1.txt", true);
	a3.solve(3);
	*/
	/*
	MazeSolver b0 = new MazeSolver("data2.txt", true);
	b0.solve(0);
	MazeSolver b1 = new MazeSolver("data2.txt", true);
	b1.solve(1);
	MazeSolver b2 = new MazeSolver("data2.txt", true);
	b2.solve(2);
	MazeSolver b3 = new MazeSolver("data2.txt", true);
	b3.solve(3);
	*/
	/*
	MazeSolver c0 = new MazeSolver("data3.txt", true);
	c0.solve(0);
	MazeSolver c1 = new MazeSolver("data3.txt", true);
	c1.solve(1);
	MazeSolver c2 = new MazeSolver("data3.txt", true);
	c2.solve(2);
	MazeSolver c3 = new MazeSolver("data3.txt", true);
	c3.solve(3);
	*/
	/*
	MazeSolver d0 = new MazeSolver("data4.txt", true);
	d0.solve(0);
	MazeSolver d1 = new MazeSolver("data4.txt", true);
	d1.solve(1);
	MazeSolver d2 = new MazeSolver("data4.txt", true);
	d2.solve(2);
	MazeSolver d3 = new MazeSolver("data4.txt", true);
	d3.solve(3);
	*/
	/*
	//TOO BIG TO TEST ON HOME COMPUTER
	MazeSolver e0 = new MazeSolver("data5.txt", true);
	e0.solve(0);
	MazeSolver e1 = new MazeSolver("data5.txt", true);
	e1.solve(1);
	MazeSolver e2 = new MazeSolver("data5.txt", true);
	e2.solve(2);
	MazeSolver e3 = new MazeSolver("data5.txt", true);
	e3.solve(3);
	*/
	//If you run this there should be NO OUTPUT AT ALL:
	MazeSolver s = new MazeSolver("data1.txt");
	s.solve(1);
	String ans = s.toString();
    }
}
