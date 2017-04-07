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

    private LNode getNthNode(int n){
	int half = size/2;
	if(n < half){
	    LNode current = head;
	    for(int i = 0; i < n; i++){
		current = current.next;
	    }
	}
	else{
	    LNode current = tail;
	    for(int i = size; i > n; i--){
		current = current.prev;
	    }
	}
	return current;
    }
    
    private void addBefore(LNode location, LNode toBeAdded){
	toBeAdded.next = location;
	toBeAdded.prev = location.prev;
	location.prev = toBeAdded;
	try{
	    toBeAdded.prev.next = toBeAdded;
	}catch(NullPointerException e){
	    return;
	}
    }

    private void addAfter(LNode location, LNode toBeAdded){
	toBeAdded.prev = location;
	toBeAdded.next = location.next;
	location.next = toBeAdded;
	try{
	    toBeAdded.next.prev = toBeAdded;
	}catch(NullPointerException e){
	    return;
	}
    }
        
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
	ans = ans + "(null)" + current.val + "(" + current.next.val + "), ";
	current = current.next;
        for(int i = 1; i < size - 1; i++){
	    ans = ans + "(" +  current.prev.val + ")" + current.val + "(" + current.next.val + "), ";
	    current = current.next;
	}
	ans = ans + "{" +  current.prev.val + ")" + current.val + "(null)]";
	    return ans;
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
	addAfter(current, new LNode(value));
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

    public int remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException e;
	}
	LNode x = getNthNode(index);
	int ans = x.val;
	if(index == 0){
	    head = x.next;
	}
	else if(index = size - 1){
	    tail = x.prev;
	}
	else if(size == 1){
	    head = null;
	    tail = null;
	}
	else{
	    x.prev.next = x.next;
	    x.next.prev = x.prev;
	}
	return ans;
    }
    
}
