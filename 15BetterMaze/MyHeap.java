import java.util.*;

public class MyHeap{
    
    public ArrayList <Location> data;
    public int size;
    public int k;

    public MyHeap(){
	data = new ArrayList<Location>();
	data.add(null);
	size = 0;
	k = 1;
    }
    
    public MyHeap(boolean b){ //true: construct empty max heap, false: construct empty min heap.
	data = new ArrayList<Location>();
	data.add(null);
	size = 0;
	if(b){
	    k = 1;
	}
	else{
	    k = -1;
	}
    }

    public int size(){
	return size;
    }
    
    public void add(Location l){
	data.add(l); //appends to the end
	size += 1; //fixes size
	pushUp(size); //fixes array if necessary
    }

    public Location remove(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	Location ans = data.get(1);
	data.set(1, data.get(data.size() - 1));
	data.remove(data.size() - 1);
	size -= 1;
	pushDown(1);
	return ans;
    }

    private void pushUp(int n){
	if(parent(n) == -1){ //root or bad index
	    return;
	}
	else if(k * data.get(parent(n)).compareTo(data.get(n)) < 0){ //if parent has lower val
	    swap(parent(n), n); //swap if true
	    pushUp(parent(n)); //recurses upwards
	}
	else{ //parent has larger or equal val
	    return; //no swap needed, end
	}
    }
    
    private void pushDown(int n){
	//System.out.println(toString());
	//System.out.println("current n = " + n);
	//System.out.println("current size = " + size);
	if(hasLeft(n) && hasRight(n)){ //two children (also tests if index is out of bounds)
	    if(k * data.get(left(n)).compareTo(data.get(n)) > 0 && k * data.get(right(n)).compareTo(data.get(n)) > 0){ //both children greater
		if(k * data.get(left(n)).compareTo(data.get(right(n))) > 0){ //left > right
		    swap(left(n), n); //swap with left
		    pushDown(left(n)); //recurse down and left
		}
		else{ //right >= left
		    swap(right(n), n); //swap with right
		    pushDown(right(n)); //recurse down and right
		}
	    }
	    else if(k * data.get(left(n)).compareTo(data.get(n)) > 0){ //only left greater
		swap(left(n), n); //swap with left
		pushDown(left(n)); //recurse down and left
	    }
	    else if(k * data.get(right(n)).compareTo(data.get(n)) > 0){ //only right greater
		swap(right(n), n); //swap with right
		pushDown(right(n)); //recurse down and right
	    }
	    else{ //none greater, end
		return;
	    }
	}
	else if(hasLeft(n)){ //left child only
	    if(k * data.get(left(n)).compareTo(data.get(n)) > 0){ //left greater
		swap(left(n), n); //swap with left
		pushDown(left(n)); //recurse down and left
	    }
	     else{ //left not greater, end
		return;
	    }
	}
	else if(hasRight(n)){ //right child only
	    if(k * data.get(right(n)).compareTo(data.get(n)) > 0){ //right greater
		swap(right(n), n); //swap with right
		pushDown(right(n)); //recurse down and right
	    }
	    else{ //right not greater, end
		return;
	    }
	}
	else{ //no children, end
	    return;
	}
    }

    private boolean hasLeft(int n){
	return 2 * n <= size;
    }

    private boolean hasRight(int n){
	return 2 * n + 1 <= size;
    }
    
    private int left(int n){
	return 2 * n;
    }

    private int right(int n){
	return 2 * n + 1;
    }

    private int parent(int n){
	if(n <= 1){
	    return -1;
	}
	else{
	    return n / 2;
	}
    }
    
    private void swap(int a, int b){
	Location tempA = data.get(a);
	Location tempB = data.get(b);
	data.set(a, tempB);
	data.set(b, tempA);
    }

    public static void main(String[]args){
	/*
	MyHeap a = new MyHeap();
	//adding
	a.add("a");
	System.out.println(a.size()); //1
	System.out.println(a.toString());
	a.add("b");
	System.out.println(a.size()); //2
	System.out.println(a.toString());
	a.add("ab");
	System.out.println(a.size()); //3
	System.out.println(a.toString());
	a.add("bc");
	System.out.println(a.size()); //4
	System.out.println(a.toString());
	a.add("z");
	System.out.println(a.size()); //5
	System.out.println(a.toString());
	a.add("c");
	System.out.println(a.size()); //6
	System.out.println(a.toString());
	System.out.println();
	//peeking
	System.out.println(a.peek()); //"z"
	System.out.println();
	//removing
	System.out.println(a.remove()); //"z"
	System.out.println(a.size()); //5
	System.out.println(a.toString());
	System.out.println(a.remove()); //"c"
	System.out.println(a.size()); //4
	System.out.println(a.toString());
	System.out.println(a.remove()); //"bc"
	System.out.println(a.size()); //3
	System.out.println(a.toString());
	System.out.println(a.remove()); //"b"
	System.out.println(a.size()); //2
	System.out.println(a.toString());
	System.out.println(a.remove()); //"ab"
	System.out.println(a.size()); //1
	System.out.println(a.toString());
	System.out.println(a.remove()); //"a"
	System.out.println(a.size()); //0
	System.out.println(a.toString());
	//System.out.println(a.remove()); //NoSuchElementException
	System.out.println();
	*/
    }
}
