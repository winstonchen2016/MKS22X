import java.util.*;
public class MyHeap{
    
    public ArrayList <String> data;
    public int size;
    public int k;

    public MyHeap(){
	data = new ArrayList<String>();
	data.add(null);
	size = 0;
	k = 1;
    }
    
    public MyHeap(boolean b){
	data = new ArrayList<String>();
	data.add(null);
	size = 0;
	if(b){
	    k = 1;
	}
	else{
	    k = -1;
	}
    }
    
    public void add(String s){
	data.add(s); //appends to the end
	size += 1; //fixes size
	pushUp(size); //fixes array if necessary
    }

    public String remove(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String ans = data.get(1);
	data.set(1, null);
	
	size -= 1;
	return ans;
    }
    
    public String peek(){
	return data.get(1); //looks at topmost val and returns it
    }
    
    private void pushUp(int n){
	if(parent(n) == -1){ //root or bad index
	    return;
	}
	else if(k * data.get(parent(n)).compareTo(data.get(n)) < 0){ //if parent has lower val
	    swap(parent(n), n); //swap if true
	    return pushUp(parent(n)); //recurses upwards
	}
	else{ //parent has larger or equal val
	    return; //no swap needed, end
	}
    }
    
    private void pushDown(int n){
	if(hasLeft(n) && hasRight(n)){ //two children
	    if(k * data.get(left(n)).comapreTo(data.get(n)) > 0 && k * data.get(right(n)).compareTo(data.get(n)) > 0){ //both children greater
		if(k * data.get(left(n)).comapreTo(data.get(right(n))) > 0){ //left > right
		    swap(left(n), n); //swap with left
		    pushDown(left(n)); //recurse down and left
		}
		else{ //right >= left
		    swap(right(n), n); //swap with right
		    pushDown(right(n)); //recurse down and right
		}
	    }
	    else if(k * data.get(left(n)).comapreTo(data.get(n)) > 0){ //only left greater
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
	return 2 * n + 1
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
	String tempA = data.get(a);
	String tempB = data.get(b);
	data.set(a, tempB);
	data.set(b, tempA);
    }
}
