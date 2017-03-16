public class QuickSelect{

    public QuickSelect(){};

    public static int part(int[] data, int start, int end){
	int L = start + 1;
	int R = end;
	int M = (int)(Math.random() * (end - start + 1) + start);
	int pivot = data[M];
	System.out.println("pivot index: " + M);
	System.out.println("pivot element: " + pivot);
	swap(data, start, M);
	System.out.println("Initial array: " + toString(data) + "\n");
	while(L < R){
	    while(data[L] < pivot && L < end){
		L ++;
	    }
	    while(data[R] > pivot && R > start){
		R --;
	    }
	    System.out.println("L: " + L);
	    System.out.println("R: " + R);
	    System.out.println("Before swap: " + toString(data));
	    if(L < R){
		swap(data, L, R);
	    }
	    System.out.println("After  swap: " + toString(data));
	    if(data[L] == pivot && data[R] == pivot){
		L++;
		R--;
	    }
	}
	System.out.println("\nFinal L: " + L);
	System.out.println("Final R: " + R);
	System.out.println("Final array: " + toString(data));
	//swap(data, 0, M);
	return 1;
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
	int[] a = {999, 999, 999, 4, 1, 0, 3, 2, 999, 999, 999};
	System.out.println(part(a, 0, 10));
	//swap (a, 2, 3);
	//System.out.println(toString(a));
    }
}
