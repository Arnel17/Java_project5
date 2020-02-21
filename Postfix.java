import java.util.Scanner;
import java.util.Stack;
public class Postfix{

public boolean isDigit(String token){
 boolean flag = true;
 try{
  int x = Integer.parseInt(token);
 }
 catch(Exception e){
  flag = false;
 }
 return flag;
}

public boolean isOperator(String token){
 boolean flag = false;
 switch(token){
  case "+":
  case "-":
  case "*":
  case "/":
   flag = true;break;
  default: flag = false;
 }
 return flag;
}

 public int postfixCalculator(String expression){
  int result = 0;
  int var1 = 0, var2 = 0;
  Stack<String> stack = new Stack<String>();
  String token[] = expression.split(" ");
  for(int i = 0; i < token.length; i++){
   //System.out.print(isDigit(token[i])?token[i]: " ");
   if(isDigit(token[i]))
    stack.push(token[i]);
   else if(isOperator(token[i]))
   {
     var2 =  Integer.parseInt(stack.pop());
     var1 =  Integer.parseInt(stack.pop());
     switch(token[i]){
      case "+": result = var1 + var2;  break;
      case "-": result = var1 - var2;  break;
      case "*": result = var1 * var2; break;
      case "/" : result = var1 / var2; break; 
      default: result = 0;
     }
     stack.push(result+"");
   }
  }
  return Integer.parseInt(stack.pop());
 }
 public static void main(String [] args){
  Postfix postfix = new Postfix();
  String expression = "3 5 6 * + 13 - 18 2 / + ";
  System.out.println("result = :" + postfix.postfixCalculator(expression));
 }
}