public class ExpressionTree{
    
    /*instance variables, constructors, and some methods not shown*/
  
    /*accessor method for the value, precondition is that isValue() is true.*/
    private double getValue(){    /*implementation not shown*/ }

    /*accessor method for the operation, precondition is that isOp() is true.*/
    private char getOp(){    /*implementation not shown*/  }    

    /* accessor method for left, precondition is that isOp() is true.*/
    private ExpressionTree getLeft(){    /*implementation not shown*/  }

    /* accessor method for right, precondition is that isOp() is true.*/
    private ExpressionTree getRight(){    /*implementation not shown*/  }

    private boolean isOp(){    /*implementation not shown*/  }

    private boolean isValue(){    /*implementation not shown*/  }


    /* you write these four methods, hint: think recursively */

    /*return the expression as an infix notation string with parenthesis*/
    /* The sample tree at the top would be: "( 3 + (2 * 10))"     */
    public String toString(){
	if(isValue()){
	    return getValue() + "";
	}
	else{
	    return "(" + getLeft() + " " + getOp() + " " + getRight() + ")";
	}
    }

    /*return the expression as a postfix notation string without parenthesis*/
    /* The sample tree would be: "3 2 10 * +"     */
    public String toStringPostfix(){
	if(isValue()){
	    return getValue() + "";
	}
	else{
	    return "" + getLeft().toStringPostfix() + " " + getRight().toStringPostfix() + " " + getOp + " ";
	}
    }

    /*return the expression as a prefix notation string without parenthesis*/
    /* The sample tree would be: "+ 3 * 2 10"     */
    public String toStringPrefix(){
	if(isValue()){
	    return getValue() + "";
	}
	else{
	    return "" + getOp() + " " + getLeft().toStringPrefix() + " " + getRight().toStringPrefix() + " ";
	}
    }

    /*return the value of the expression tree*/
    public double evaluate(){
	if(isValue()){
	    return getValue();
	}
	else if(getOp() == '+'){
	    return getLeft().evaluate() + getRight().evluate();
	}
	else if(getOp() == '-'){
	    return getLeft().evaluate() - getRight().evluate();
	}
	else if(getOp() == '*'){
	    return getLeft().evaluate() * getRight().evluate();
	}
	else{
	    return getLeft().evaluate() / getRight().evluate();
	}
	
    }

}
