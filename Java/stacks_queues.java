/// By: Merna Alghannam


import java.util.*; 
import java.io.*;

public class StacksAndQueues { 

  static class QueueofS  {  
    static Stack<Character> in = new Stack<Character>();  
    static Stack<Character> out = new Stack<Character>(); 
  
    static void enQueue(char x)  
    {  
        // Move all elements from in to out 
        while (!in.isEmpty()) {  
            out.push(in.pop());   
        }  
  
        // Push item into in  
        in.push(x);  
  
        // Push everything back to in  
        while (!out.isEmpty())  
        {  
            in.push(out.pop());   
        }  
    }  
  
    // Dequeue an item from the queue  
    static char deQueue()  
    {  
        // if first stack is empty  
        if (in.isEmpty())  
        {  
            System.out.println("Q is Empty");  
            System.exit(0);  
        }  
  
        // Return top of in  
        char x = in.peek();  
        in.pop();  
        return x;  
    } 

    static char peak(){
      char x = in.peek(); 
      return x;
    } 

    static void printStack(Stack<Character> s) { 
      // If stack is empty then return 
      if (s.isEmpty()) 
          return; 
      
      char x = s.peek(); 
  
      // Pop the top element of the stack 
      s.pop(); 
  
      // Recursively call the function PrintStack 
      printStack(s); 
  
      // Print the stack element starting 
      // from the bottom 
      System.out.print(x + " "); 
  
      // Push the same element onto the stack 
      // to preserve the order 
      s.push(x); 
    } 

    static void printQueue(){
      // Move all elements from in to out 
      while (!in.isEmpty()) {  
          out.push(in.pop());  
      } 

      printStack(out);

      // Push everything back to in  
      while (!out.isEmpty()) {  
          in.push(out.pop()); 
      } 
      System.out.println();
    }
  };
  
  // function to check if brackets are balanced 
  static boolean areBracketsBalanced(String str) { 
      Stack<Character> s = new Stack<Character>(); 

      for (int i = 0; i < str.length(); i++)  
      { 
          char x = str.charAt(i); 

          if (x == '(' || x == '[' || x == '{')  { 
              // Push the element in the stack 
              s.push(x); 
              continue; 
          } 

          // IF current current character is not opening 
          // bracket, then it must be closing. So stack 
          // cannot be empty at this point. 
          if (s.isEmpty()) 
              return false; 
          char c; 
          switch (x) { 
          case ')': 
              c = s.pop(); 
              if (c == '{' || c == '[') 
                  return false; 
              break; 
          case '}': 
              c = s.pop(); 
              if (c == '(' || c == '[') 
                  return false; 
              break; 
          case ']': 
              c = s.pop(); 
              if (c == '(' || c == '{') 
                  return false; 
              break; 
          } 
      } 

      // Check Empty Stack 
      return (s.isEmpty()); 
  } 

  // This function return the sorted stack 
  public static Stack<Integer> sortstack(Stack<Integer> original) { 
      Stack<Integer> newStack = new Stack<Integer>(); 
      while(!original.isEmpty()) 
      { 
          // pop out the first element 
          int tmp = original.pop(); 
        
          // while temporary stack is not empty and 
          // top of stack is greater than temp 
          while(!newStack.isEmpty() && newStack.peek() > tmp) { 
              // pop from temporary stack to original stack 
            original.push(newStack.pop()); 
          } 
            
          // push temp in tempory of stack 
          newStack.push(tmp); 
      } 
      return newStack; 
  } 

  public static void runQueries(String queries){
    QueueofS q = new QueueofS();  

    if (queries == null || queries.length() == 0){
      System.out.println("INFO: No queries to run");
      return;
    }

    String[] query = queries.split(" ");
    
    for (int i = 0; i < query.length; i++){
      if (query[i].length() == 2 && query[i].charAt(0) == '1'){     
        q.enQueue(query[i].charAt(1));
      }else if (query[i].length() == 1 && query[i].charAt(0) == '2'){
        q.deQueue();
      }else if (query[i].length() == 1 && query[i].charAt(0) == '3'){
        System.out.println("peaking element at top: " + q.peak());
      }else{
        System.out.println("ERROR: Invalid query");
      }
      System.out.println("printing queue:");
      q.printQueue();
    } 
  }
  
  // Driver code 
  public static void main(String[] args) { 
      String expr = "([{}])"; 

      // Function call  for areBracketsBalanced
      if (areBracketsBalanced(expr)) 
          System.out.println("Balanced "); 
      else
          System.out.println("Not Balanced "); 

      // Function call for sortstack
      Stack<Integer> input = new Stack<Integer>(); 
      input.add(34); 
      input.add(3); 
      input.add(31); 
      input.add(98); 
      input.add(92); 
      input.add(23); 
  
      Stack<Integer> tmpStack = sortstack(input); 
      System.out.println("Sorted numbers are:"); 
    
      while (!tmpStack.empty()) 
      { 
          System.out.print(tmpStack.pop()+" "); 
      }  
      System.out.println("\n");

      //function call for runQueries
      runQueries("12 23 11 3 22 33 1 2 3");
  } 
}
