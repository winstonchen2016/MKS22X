import java.util.*;

public class FrontierPriorityQueue implements Frontier{
    
    private MyHeap H;

    public FrontierPriorityQueue(){
	H = new MyHeap(false);
    }

    public void add(Location l){
	H.add(l);
    }

    public Location next(){
	return H.remove();
    }

    public int size(){
	return H.size();
    }
}
