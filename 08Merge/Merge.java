import java.util.*;

public class Merge{

    public Merge(){};

    public static void mergesort(int[] ary){
	if(ary.length <= 1){
	    return;
	}
	else{
	    //System.out.println("Current Array: " + toString(ary));
	    int half = ary.length/2;
	    int[] a = subArray(ary, 0, half);
	    int[] b = subArray(ary, half, ary.length);
	    mergesort(a);
	    mergesort(b);
	    //System.out.println("1st Half: " + toString(a));
	    //System.out.println("2nd Half:" + toString(b));
	    int indexa = 0;
	    int indexb = 0;
	    for(int i = 0; i < ary.length; i++){
		if(indexa >= a.length){
		    ary[i] = b[indexb];
		    indexb++;
		}
		else if(indexb >= b.length){ //no more elements in b or a has smaller/equal value element
		    ary[i] = a[indexa];
		    indexa++;
		}
		else if(b[indexb] <= a[indexa]){
		    ary[i] = b[indexb];
		    indexb++;
		}
		else{
		    ary[i] = a[indexa];
		    indexa++;
		}
	    }
	}
    }

    public static int[] subArray(int[] a, int start, int end){
	int[] b = new int[end-start];
	for(int i = start; i < end; i++){
	    b[i-start] = a[i];
	}
	return b;
    }

    public static String toString(int[] ar){
	String ans = "[";
	for(int i = 0; i < ar.length - 1; i++){
	    ans = ans + ar[i] + " ";
	}
	ans = ans + ar[ar.length - 1] + "]";
	return ans;
    }

    public static int[] randomArray(int size){
	int[] ary = new int[size];
	for (int i = 0; i < ary.length; i++){
	    ary[i] = (int)(Math.random() * ary.length - ary.length / 2);
	}
	return ary;
    }

    public static int[] randomArray(int size, int min, int max){
	int[] ary = new int[size];
	for (int i = 0; i < ary.length; i++){
	    ary[i] = (int)(Math.random() * (max - min + 1) + min);
	}
	return ary;
    }
    
    public static void main(String[] args){
	//split testing and initial testing
	//int[] z = randomArray(11);
	//System.out.println("Current Array: " + toString(z));
	//mergesort(z);
	//System.out.println("Current Array: " + toString(z));
	/*
	int[] a = randomArray(9999999);
	System.out.println("Completely random array");
	System.out.println("--------------------");
	//mergesort
	mergesort(a);
        String test = Arrays.toString(a);
        Arrays.sort(a);
	String correct = Arrays.toString(a);
	if (test.equals(correct)) {
	    System.out.println("Mergesort works!");
	}
	else {
	    System.out.println("Mergesort failed!");
	}

	a = randomArray(9999999, 0, 10);
	System.out.println("Random array with limited range");
	System.out.println("--------------------");
	//mergesort
	mergesort(a);
        test = Arrays.toString(a);
        Arrays.sort(a);
	correct = Arrays.toString(a);
	if (test.equals(correct)) {
	    System.out.println("Mergesort works!");
	}
	else {
	    System.out.println("Mergesort failed!");
	}

	a = randomArray(9999999, 0, 0);
	System.out.println("Array with all of 1 number");
	System.out.println("--------------------");
	//mergesort
	mergesort(a);
        test = Arrays.toString(a);
        Arrays.sort(a);
	correct = Arrays.toString(a);
	if (test.equals(correct)) {
	    System.out.println("Mergesort works!");
	}
	else {
	    System.out.println("Mergesort failed!");
	}

	a = randomArray(9999999);
	Arrays.sort(a);
	System.out.println("Sorted array");
	System.out.println("--------------------");
	//mergesort
	mergesort(a);
        test = Arrays.toString(a);
        Arrays.sort(a);
	correct = Arrays.toString(a);
	if (test.equals(correct)) {
	    System.out.println("Mergesort works!");
	}
	else {
	    System.out.println("Mergesort failed!");
	}
	
	int[] b = randomArray(2000000);
	Arrays.sort(b);
	for (int i = b.length - 1; i > -1; i --) {
	    a[b.length - 1 - i] = b[i];
	}
	System.out.println("Reverse sorted array");
	System.out.println("--------------------");
	//mergesort
        mergesort(a);
        test = Arrays.toString(a);
        Arrays.sort(a);
	correct = Arrays.toString(a);
	if (test.equals(correct)) {
	    System.out.println("Mergesort works!");
	}
	else {
	    System.out.println("Mergesort failed!");
	}
	*/
    }
}
