public class Recursion{ 
    public static String name(){
	return "Chen,Winston";
    }
    
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException("Please input a non-negative number.");
	}
	else if(n == 0){
	    return 0;
	}
	else{
	    return sqrtH(n, n / 2);
	}
    }
    
    private static double sqrtH(double n, double guess){
	if(isCloseEnough(n, guess * guess)){
	    return guess;
	}
	else{
	    return sqrtH(n, (n/guess + guess) / 2);
	}
    }
    
    private static boolean isCloseEnough(double a, double b){
	return (Math.abs(a-b)/a * 100 <= 0.0000000000001);
    }

    public static void main(String[]args){
	System.out.println(name()); //should be "Chen,Winston"
	//sqrt(-1); //should throw IllegalArgumentException
	System.out.println(sqrt(0)); //should be 0
	System.out.println(sqrt(4)); //should be ~2
	System.out.println(sqrt(2)); //should be ~1.4142135623731
	System.out.println(sqrt(100)); //should be ~10
	System.out.println(sqrt(.1)); //should be ~0.3162277660168
	System.out.println(sqrt(.0001)); //should be ~0.01
	System.out.println(sqrt(.000001)); //should be ~0.001
    }
}
