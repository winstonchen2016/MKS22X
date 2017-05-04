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
	data.add(s);
	
	size += 1;
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
	return data.get(1);
    }
    
    private void pushUp(){
	
    }
    
    private void pushDown(){
	
    }
    
    private void swap(int a, int b){
	String tempA = data.get(a);
	String tempB = data.get(b);
	data.set(a, tempB);
	data.set(b, tempA);
    }
}
