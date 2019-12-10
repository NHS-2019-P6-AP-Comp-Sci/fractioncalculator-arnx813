/**
 * @author Mr. Rasmussen
 */
package fracCalc;
import java.lang.Math;
import java.util.*;
public class FracCalc {

	
	// the main method initializes scanner that takes in calculation that user wants to solve and calls method produceAnswer and prints the return value
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
    	
    	//this for loop iterates through the string and identifies the index in which there is a space, operator, space to essentially break up the string and assign each substring as either the first value, operator or second value
    	
    	for (int i = 0; i < input.length()-3; i++) {
    		if (input.substring(i,i+1).equals(" ") && input.substring(i+2,i+3).equals(" ") && (input.substring(i+1, i+2).equals("+") || input.substring(i+1, i+2).equals("-") || input.substring(i+1, i+2).equals("*") || input.substring(i+1, i+2).equals("/"))) {
    			firstValue = input.substring(0,i);
    			operatorVal = input.substring(i+1, i+2);
    			secondValue = input.substring(i+3,input.length());
    		}
    	}
        	
    	// checks whether the second and first value are whole numbers, mixed fractions, or a not mixed fraction
    	
    	if (firstValue.indexOf("_") >= 0 && firstValue.indexOf("/") >= 0) {
    		firstWhole = firstValue.substring(0, firstValue.indexOf("_"));
    		firstNumerator = firstValue.substring(firstValue.indexOf("_")+1, firstValue.indexOf("/"));
    		firstDenominator = firstValue.substring(firstValue.indexOf("/")+1, firstValue.length());
    	} else if (firstValue.indexOf("_") < 0 && firstValue.indexOf("/") >= 0) {
    		firstWhole = "0";
    		firstNumerator = firstValue.substring(0, firstValue.indexOf("/"));
    		firstDenominator = firstValue.substring(firstValue.indexOf("/")+1, firstValue.length());
    	} else if (firstValue.indexOf("_") < 0 && firstValue.indexOf("/") < 0) {
    		firstWhole = firstValue;
    		firstNumerator = "0";
    		firstDenominator = "1";
    	}
    	
    	if (secondValue.indexOf("_") >= 0 && secondValue.indexOf("/") >= 0) {
    		secondWhole = secondValue.substring(0, secondValue.indexOf("_"));
    		secondNumerator = secondValue.substring(secondValue.indexOf("_")+1, secondValue.indexOf("/"));
    		secondDenominator = secondValue.substring(secondValue.indexOf("/")+1, secondValue.length());
    	} else if (secondValue.indexOf("_") < 0 && secondValue.indexOf("/") >= 0) {
    		secondWhole = "0";
    		secondNumerator = secondValue.substring(0, secondValue.indexOf("/"));
    		secondDenominator = secondValue.substring(secondValue.indexOf("/")+1, secondValue.length());
    	} else if (secondValue.indexOf("_") < 0 && secondValue.indexOf("/") < 0) {
    		secondWhole = secondValue;
    		secondNumerator = "0";
    		secondDenominator = "1";
    	}   
    	
    	
    	
    	int firstNumer;
    	int secondNumer;
    	
    	//converting the second and first value such that there is no whole value just a numerator or denominator
    	
    	if (Integer.parseInt(firstWhole) < 0) {
    		firstNumer = (Integer.parseInt(secondDenominator)*(Integer.parseInt(firstDenominator) * (Integer.parseInt(firstWhole)*-1) + Integer.parseInt(firstNumerator)))*-1;
    	} else {
    		firstNumer = Integer.parseInt(secondDenominator)*(Integer.parseInt(firstDenominator) * Integer.parseInt(firstWhole) + Integer.parseInt(firstNumerator));
    	}
    	
    	if (Integer.parseInt(secondWhole) < 0) {
    		secondNumer = (Integer.parseInt(firstDenominator)*(Integer.parseInt(secondDenominator) * (Integer.parseInt(secondWhole)*-1) + Integer.parseInt(secondNumerator)))*-1;
    	} else {
        	secondNumer = Integer.parseInt(firstDenominator)*(Integer.parseInt(secondDenominator) * Integer.parseInt(secondWhole) + Integer.parseInt(secondNumerator));
    	}
    	
	
    	//making the denominators the same
    	int firstDenom = Integer.parseInt(firstDenominator)* Integer.parseInt(secondDenominator);
    	int secondDenom = Integer.parseInt(firstDenominator)* Integer.parseInt(secondDenominator);
    	int denom = 0;
    	int numer = 0;
    	
    	//calculating the output/value based on the operator

    	if (operatorVal.equals("+")) {
    		numer = firstNumer + secondNumer;
    		denom = firstDenom;
    	} else if (operatorVal.equals("-")) {
    		numer = firstNumer - secondNumer;
			denom = firstDenom;
    	} else if (operatorVal.equals("*")) {
    		numer = firstNumer * secondNumer;
    		denom = firstDenom * secondDenom;
    	} else if (operatorVal.equals("/")) {
    		numer = firstNumer * secondDenom;
    		denom = secondNumer * firstDenom;
    		
    		if (denom < 0) {
    			denom *= -1;
    			numer *= -1;
    		}
    	}
    	
    	//make sure fraction simplified
    	
    	int divider = 1;
		for (int i = 1; i <= denom; i++) {
			if ((numer % i==0) && denom % i==0) {
				divider = i;
			}
		}
		
		numer /= divider;
		denom /= divider;
		
		//special case for 0, or denominator is 1 and the last else statement makes fraction mixed if possible and returns value
		
		if (numer == 0) {
			return "0";
		} else if (denom == 1) {
			return Integer.toString(numer);
		} else {
			if (Math.abs(numer) > denom) {
				return (numer/denom) + "_" + (Math.abs(numer)-(Math.abs(numer)/denom)*denom) + "/" + denom;
			}
			return numer + "/" + denom;
		}        	
    }
}