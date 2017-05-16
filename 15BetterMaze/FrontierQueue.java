public class FrontierQueue implements <Frontier>{
    
    private ArrayDeque<Location> Q;

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
