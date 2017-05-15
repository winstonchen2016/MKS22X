public class Location implements Comparable<Location>{

    public int row;
    public int col;
    public Location previous;
    public int distToStart;
    public int distToGoal;
    public boolean aStar;

    public Location(int r, int c, Location previous, int distToStart, int distToGoal){
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
    }

    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
	this(r, c, previous, distToStart, distToGoal);
	this.aStar = aStar;
    }

    public int CompareTo(Location other){
	
    }
    
}
