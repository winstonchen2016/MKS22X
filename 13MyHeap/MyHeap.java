import java.util.*;
public class MyHeap{
    
    public ArrayList <String> data;
    public int size;
    public int k;

    public MyHeap(){
	data = new ArrayList<String>();
	size = 0;
	k = 1;
    }
    
    public MyHeap(boolean b){
	data = new ArrayList<String>();
	size = 0;
	if(b){
	    k = 1;
	}
	else{
	    k = -1;
	}
    }


}
