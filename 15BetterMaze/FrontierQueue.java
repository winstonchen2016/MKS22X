import java.util.*;

public class FrontierQueue implements Frontier{
    
    private ArrayDeque<Location> Q;

    public FrontierQueue(){
	Q = new ArrayDeque<Location>();
    }

    public void add(Location l){
	Q.add(l);
    }

    public Location next(){
	return Q.removeFirst();
    }

    public int size(){
	return Q.size();
    }
}
