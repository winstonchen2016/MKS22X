import java.util.*;
public class StackCalc{

    private static boolean isOp(String s){
	return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%");
    }

    private static double apply(String op, double a, double b){
	if(op.equals("+")){
	    return (b + a);
	}
	else if(op.equals("-")){
	    return (b - a);
	}
	else if(op.equals("*")){
	    return (b * a);
	}
	else if(op.equals("/")){
	    return (b / a);
	}
	else{
	    return (b % a);
	}
    }
    
    public static double eval(String s){
	String[] tokens = s.split(" ");
	Stack <Double> values = new Stack <Double>();
	for(int i = 0; i < tokens.length; i++){
	    if(isOp(tokens[i])){
		values.push(apply(tokens[i], values.pop(), values.pop()));
	    }
	    else{
		values.push(Double.parseDouble(tokens[i]));
	    }
	    //System.out.println("" + values.peek());
	}
	return values.pop();
    }

    /*
    public static void main(String[]args){
	System.out.println(eval("10 2.0 +"));
	System.out.println("12.0");
	System.out.println(eval("11 3 - 4 + 2.5 *"));
	System.out.println("30.0");
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
	System.out.println("893.0");
    }
    */
}
