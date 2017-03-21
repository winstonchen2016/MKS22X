public class Quick{

    public Quick(){};

    public static void quicksort(int[] a){
	part(a, 0, a.length - 1);
    }

    private static void part(int[] a, int start, int end){
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
	System.out.println("pivot: " + pivot + "  L: " + L + "  R: " + R + "  I: " + I);
	//part(a, start, L);
	//part(a, I, end);
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
    
    public static void main(String[]args){
	///*
	int[] a = {5, 7, 6, 1, 3, 2, 0, 4, 8, 9}; //standard test
	System.out.println("Initial array: " + toString(a));
	quicksort(a);	
       	System.out.println("Final array: " + toString(a) + "\n");
	int[] c = {3, 4, 5, 6, 8, 3, 5, 9, 7, 8, 5, 5, 3, 0, 5, 3, 1, 2, 3, 5}; //Dutch Flag test
	System.out.println("Initial array: " + toString(c));
	quicksort(c);
       	System.out.println("Final array: " + toString(c) + "\n");
	//*/
	/*
	int x = 0;
	while(x < 50){
	    int[] c = new int[10];
	    for(int i = 0; i < c.length; i++){
		c[i] = (int)(Math.random() * 50);
	    }
	    System.out.println("Initial array: " + toString(c));
	    quicksort(c);
	}
	*/
    }
}
