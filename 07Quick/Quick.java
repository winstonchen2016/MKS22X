import java.util.*;

public class Quick{

    public Quick(){};

    public static void quicksort(int[]ary){
	qsortH(ary, 0, ary.length - 1);
    }

    private static void qsortH(int[] a, int start, int end){
	if(a.length == 0){
	    return;
	}
	int L = start; //left
	int I = start; //current index
	int R = end; //right
	int K = (int)(Math.random() * (end - start + 1) + start);
	int pivot = a[K];
	swap(a, start, K); //moves pivot to beginning for easier sorting
	//System.out.println("Initial array: " + toString(data) + "\n");
	while(I <= R){
	    if(a[I] < pivot){ //swaps L and R if they are on the wrong sides
		swap(a, I, L);
		L++;
		I++;
	    }
	    else if(a[I] > pivot){
		swap(a, I, R);
		R--;
	    }
	    else{
		I++;
	    }
	}
	//System.out.println("Start: "  + start + "  End: " + end + "  Pivot Index: " + K + "  Pivot: " + pivot + "  L: " + L + "  R: " + R + "  I: " + I);
	//System.out.println("Current array: " + toString(a));
	if(L - start > 1 || end - R > 1){
	    if(L - start > 1){
		qsortH(a, start, L - 1);
	    }
	    if(end - R > 1){
		qsortH(a, I, end);
	    }
	}
    }

    public static int quickselect(int[]ary, int k){
	return qselectH(ary, 0, ary.length - 1, k);
    }

    private static int qselectH(int[] a, int start, int end, int k){
	int L = start; //left
	int I = start; //current index
	int R = end; //right
	int K = (int)(Math.random() * (end - start + 1) + start);
	int pivot = a[K];
	swap(a, start, K); //moves pivot to beginning for easier sorting
	//System.out.println("Initial array: " + toString(data) + "\n");
	while(I <= R){
	    if(a[I] < pivot){ //swaps L and R if they are on the wrong sides
		swap(a, I, L);
		L++;
		I++;
	    }
	    else if(a[I] > pivot){
		swap(a, I, R);
		R--;
	    }
	    else{
		I++;
	    }
	}
	//System.out.println("Start: "  + start + "  End: " + end + "  k: " + k + "  Pivot Index: " + K + "  Pivot: " + pivot + "  L: " + L + "  R: " + R + "  I: " + I);
	//System.out.println("Current array: " + toString(a));
	if(a[k] < pivot){
	    if(L > start){
		return qselectH(a, start, L - 1, k);
	    }
	    else{
		return a[R]; //strating block of same elements
	    }
	}
	else if(a[k] > pivot){
	    return qselectH(a, R + 1, end, k);
	}
	else{
	    //if(R == a.length - 1){
	    //return a[R];  //ending block of same elements
	    //}
	    //else{
	    return a[R];
	    //}
	}
    }

    public static void swap(int[] ar, int a, int b){
	int temp = ar[a];
	ar[a] = ar[b];
	ar[b] = temp;
    }
	
    public static String toString(int[] ar){
	String ans = "[";
	for(int i = 0; i < ar.length - 1; i++){
	    ans = ans + ar[i] + " ";
	}
	ans = ans + ar[ar.length - 1] + "]";
	return ans;
    }

    public static boolean checkSorted(int[] a){
	if(a.length == 0){
	    return true;
	}
	else{
	    for(int i = 1; i < a.length; i++){
		if(a[i] < a[i-1]){
		    return false;
		}
	    }
	}
	return true;
    }
    
    public static void main(String[]args){
	/*
	int[] z = {};
	quicksort(z);
	System.out.println(checkSorted(z));
	int[] a = {5, 7, 6, 1, 3, 2, 0, 4, 8, 9}; //standard test
	//System.out.println("Initial Array: " + toString(a));
	quicksort(a);
       	//System.out.println("Final Array: " + toString(a) + "\n");
	System.out.println(checkSorted(a));
	int[] b = {3, 4, 5, 6, 8, 3, 5, 9, 7, 8, 5, 5, 3, 0, 5, 3, 1, 2, 3, 5}; //Dutch Flag test
	//System.out.println("Initial Array: " + toString(b));
	quicksort(b);
       	//System.out.println("Final Array: " + toString(b) + "\n");
	System.out.println(checkSorted(b));
	*/
	/*
	int x = 0;
	while(x < 50){
	    int[] c = new int[1000000];
	    for(int i = 0; i < c.length; i++){
		c[i] = (int)(Math.random() * 50);
	    }
	    //System.out.println("Initial array: " + toString(c));
	    quicksort(c);
	    //System.out.println("Final array: " + toString(c));
	    System.out.println(checkSorted(c));
	}
	*/
	/*
	int[] A = {5, 7, 6, 1, 3, 2, 0, 4, 8, 9}; //standard test
	int q = quickselect(A, 5);
	quicksort(A);
	System.out.println(q == A[5]);
	int[] B = {3, 4, 5, 6, 8, 3, 5, 9, 7, 8, 5, 5, 3, 0, 5, 3, 1, 2, 3, 5}; //Dutch Flag test
        int w = quickselect(B, 17);
	quicksort(B);
	System.out.println(w == B[17]);
	*/
	/*
	int x = 0;
	while(x < 50){
	    int[] C = new int[9999999];
	    for(int i = 0; i < C.length; i++){
		C[i] = (int)(Math.random() * 50);
	    }
	    int k = 1 + (int)Math.random() * 9999997;
	    int l = quickselect(C, k);
	    Arrays.sort(C);
	    System.out.println(l == C[k]);
	}
	*/
	/* //duplicate testing
	int[] D = {0, 0, 0, 0, 0};
	int y = quickselect(D, 3);
	Arrays.sort(D);
	System.out.println(y == D[3]);
	int[] E = {0, 9, 0, 5, 9};
	int z = quickselect(D, 4);
	Arrays.sort(D);
	System.out.println(y == D[4]);
	int Z = quickselect(D, 0);
	Arrays.sort(D);
	System.out.println(y == D[0]);	
	*/
    }
}
