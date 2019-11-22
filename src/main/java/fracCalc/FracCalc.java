/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {
	
	// checkpoint 1

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	String userResp = scan.nextLine();
    	System.out.println(produceAnswer(userResp));
    }

    public static String produceAnswer(String input)
    {
    	String firstValue = "";
    	String firstWhole = "";
    	String firstNumerator = "";
    	String firstDenominator = "";
    	String operatorVal = ""; 
    	String secondValue = ""; 
    	String secondWhole = "";
    	String secondNumerator = "";
    	String secondDenominator = "";
    	for (int i = 0; i < input.length()-3; i++) {
    		if (input.substring(i,i+1).equals(" ") && input.substring(i+2,i+3).equals(" ") && (input.substring(i+1, i+2).equals("+") || input.substring(i+1, i+2).equals("-") || input.substring(i+1, i+2).equals("*") || input.substring(i+1, i+2).equals("/"))) {
    			firstValue = input.substring(0,i);
    			operatorVal = input.substring(i+1, i+2);
    			secondValue = input.substring(i+3,input.length());
 		
    		}
    	} 
    	
    	return secondValue;
//    	
//        	
//    	if (firstValue.indexOf("_") >= 0 && firstValue.indexOf("/") >= 0) {
//    		firstWhole = firstValue.substring(0, firstValue.indexOf("_"));
//    		firstNumerator = firstValue.substring(firstValue.indexOf("_")+1, firstValue.indexOf("_")+2);
//    		firstDenominator = firstValue.substring(firstValue.indexOf("/")+1, firstValue.indexOf("/")+2);
//    	} else if (firstValue.indexOf("_") < 0 && firstValue.indexOf("/") >= 0) {
//    		firstWhole = "0";
//    		firstNumerator = firstValue.substring(0, firstValue.indexOf("/"));
//    		firstDenominator = firstValue.substring(firstValue.indexOf("/")+1, firstValue.length());
//    	} else if (firstValue.indexOf("_") < 0 && firstValue.indexOf("/") < 0) {
//    		firstWhole = firstValue;
//    		firstNumerator = "0";
//    		firstDenominator = "1";
//    	}
//    	
//    	if (secondValue.indexOf("_") >= 0 && secondValue.indexOf("/") >= 0) {
//    		secondWhole = secondValue.substring(0, secondValue.indexOf("_"));
//    		secondNumerator = secondValue.substring(secondValue.indexOf("_")+1, secondValue.indexOf("_")+2);
//    		secondDenominator = secondValue.substring(secondValue.indexOf("/")+1, secondValue.indexOf("/")+2);
//    	} else if (secondValue.indexOf("_") < 0 && secondValue.indexOf("/") >= 0) {
//    		secondWhole = "0";
//    		secondNumerator = secondValue.substring(0, secondValue.indexOf("/"));
//    		secondDenominator = secondValue.substring(secondValue.indexOf("/")+1, secondValue.length());
//    	} else if (secondValue.indexOf("_") < 0 && secondValue.indexOf("/") < 0) {
//    		secondWhole = secondValue;
//    		secondNumerator = "0";
//    		secondDenominator = "1";
//    	}   
//    	
//    	int firstNumer;
//    	int secondNumer;
//    	
//    	if (Integer.parseInt(firstWhole) < 0) {
//    		firstNumer = (Integer.parseInt(secondDenominator)*(Integer.parseInt(firstDenominator) * (Integer.parseInt(firstWhole)*-1) + Integer.parseInt(firstNumerator)))*-1;
//    	} else {
//    		firstNumer = Integer.parseInt(secondDenominator)*(Integer.parseInt(firstDenominator) * Integer.parseInt(firstWhole) + Integer.parseInt(firstNumerator));
//    	}
//    	
//    	if (Integer.parseInt(secondWhole) < 0) {
//    		secondNumer = (Integer.parseInt(firstDenominator)*(Integer.parseInt(secondDenominator) * (Integer.parseInt(secondWhole)*-1) + Integer.parseInt(secondNumerator)))*-1;
//    	} else {
//        	secondNumer = Integer.parseInt(firstDenominator)*(Integer.parseInt(secondDenominator) * Integer.parseInt(secondWhole) + Integer.parseInt(secondNumerator));
//    	}
//    	
//    	int firstDenom = Integer.parseInt(firstDenominator)* Integer.parseInt(secondDenominator);
//    	int secondDenom = Integer.parseInt(firstDenominator)* Integer.parseInt(secondDenominator);
//    	
//    	
//
//    	if (operatorVal.equals("+")) {
//    			System.out.println(firstNumer + secondNumer);
//    			System.out.println(firstDenom);
//    	} else if (operatorVal.equals("-")) {
//    		System.out.println(firstNumer - secondNumer);
//			System.out.println(firstDenom);
//    	} else if (operatorVal.equals("*")) {
//    		System.out.println(firstNumer * secondNumer);
//    		System.out.println(firstDenom * secondDenom);
//    	} else if (operatorVal.equals("/")) {
//    		System.out.println(firstNumer * secondDenom);
//    		System.out.println(secondNumer * firstDenom);
//    	}
//    	
//    

        	
    }
}
