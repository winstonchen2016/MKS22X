public class Location implements Comparable<Location>{

    private int row;
    private int col;
    private Location previous;
    private int distToStart;
    private int distToGoal;
    private boolean aStar;


    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    public int compareTo(Location other){
	if(aStar){
	    if(distToStart + distToGoal > other.getDistToStart() + other.getDistToGoal()){
		return 1;
	    }
	    else if(distToStart + distToGoal == other.getDistToStart() + other.getDistToGoal()){
		return 0;
	    }
	    else{
		return -1;
	    }
	}
	else{
	    if(distToGoal > other.getDistToGoal()){
		return 1;
	    }
	    else if(distToGoal == other.getDistToGoal()){
		return 0;
	    }
	    else{
		return -1;
	    }
	}
    }
    
    public int getRow(){
	return row;
    }
    
    public int getCol(){
	return col;
    }
    
    public Location getPrevious(){
	return previous;
    }
    
    public int getDistToStart(){
	return distToStart;
    }

    public int getDistToGoal(){
	return distToGoal;
    }

}
