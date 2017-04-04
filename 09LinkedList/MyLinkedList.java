import java.util.*;
public class MyLinkedList{

    private class LNode{
	private int val;
	private LNode prev;
	private LNode next;

	private LNode(int i){
	    val = i;
	}
    }

    private LNode head;
    private LNode tail;
    private int size;

    public MyLinkedList(){
    }

    //private LNode getNthNode(int n){/*complete this*/}
    
    //private void addBefore(LNode location, LNode toBeAdded){/*complete this*/  }

    //private void addAfter(LNode location, LNode toBeAdded){/*complete this*/  }
    
    //private void remove(LNode target){/*complete this*/}
    
    public int size(){
	return size;
    }

    public String toString(){
	String ans = "[";
	if(size == 0){
	    return ans + "]";
	}
	LNode current = head;
        for(int i = 0; i < size; i++){
	    ans = ans + current.val + ", ";
	    current = current.next;
	}
	return ans.substring(0, ans.length() - 2) + "]";
    }

    public String toStringDebug(){
	String ans = "[";
	if(size == 0){
	    return ans + "]";
	}
	LNode current = head;
        for(int i = 0; i < size; i++){
	    ans = ans + "{";
	    if(current.prev.val == null){
		ans += "null";
	    }
	    else{
		ans += current.prev.val;
	    }
	    ans = ans + ")" + current.val + "(";
	    if(current.next.val == null){
		ans += "null";
	    }
	    else{
		ans += current.next.val;
	    }
	    ans = ans + "), ";
	    current = current.next;
	}
	return ans.substring(0, ans.length() - 2) + "]";
    }

    public boolean add(int value){
	if(size == 0){
	    head = new LNode(value);
	    tail = head;
	    size++;
	    return true;
	}
	LNode current = head;
	for(int i = 0; i < size - 1; i++){
	    current = current.next;
	}
	current.next = new LNode(value);
	size ++;
	return true;
    }

    public int get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}
	return current.val;
    }

    public int set(int index, int newValue){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	for(int i = 0; i < index; i++){
	    current = current.next;
	}
	int ret = current.val;
	current.val = newValue;
	return ret;
    }

    public int indexOf(int value){
	int ans = -1;
	LNode current = head;
	for(int i = 0; i < size; i++){
	    if(current.val == value){
		return i;
	    }
	    current = current.next;
	}
	return ans;
    }
    
}
