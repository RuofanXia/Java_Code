package StudentLabExam1;

import java.util.*;

//This class brought to you by Don Landrum
import java.util.Scanner;
public class LabExam1 extends ArrayStack {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		while(quit == false){
			System.out.println("Enter the string you would like to test for well-formedness or -1 to quit");
			String input = keyboard.nextLine(); //collects the String to be tested
			if(input.contains("-1")){
				System.out.println("Goodbye!");
				System.exit(0);
			}
			System.out.println(wellFormed(input));//checks the String and prints the result
		}
	}
	public static Boolean wellFormed(String aString){//checks the String, returning a boolean statement
		ArrayStack aStack = new ArrayStack();//uses a Stack built in another class
		int quotes = 0;
		for(int i = 0; i<aString.length(); i++){
			//Counts the number of quotation marks
			//there is no difference between the opening and closing quotation marks
			//the strategy used below for parentheses and other symbols will not work for quotations
			if(aString.charAt(i) == '"'){
				quotes++;
			}
			else if((aString.charAt(i) == '(') || (aString.charAt(i) == '{') || (aString.charAt(i) == '<')){
				//if the character is an opening symbol, push it onto the stack
				aStack.push(aString.charAt(i));
			}
			else if((aString.charAt(i) == ')') || (aString.charAt(i) == '}') ||  (aString.charAt(i) == '>')){
				//if the character is a closing symbol, pop the top object off of the stack
				Object a = aStack.pop();
				if(a == null){
					//if there is no top object on the stack, the closing symbol is in the wrong place, return false
					return false;
				}
				if((a.toString().equals("{") && aString.charAt(i) == '}') || (a.toString().equals("<") && aString.charAt(i) == '>') || (a.toString().equals("(") && aString.charAt(i) == ')')) {
					//do nothing; they match
				}
				else{//the characters do not match
					return false;
				}
			}
		}
		if(quotes%2 != 0){
			//if the number of quotations is not even, return false
			return false;
		}
		if(aStack.pop() == null){
			//if the stack is empty, all of the opening characters have been met by their closing characters, return true
			return true;
		}
		else{
			//if the stack is not empty, there are some unmatched opening characters, return false
			return false;
		}
	}
}