// By: Merna Alghannam //

import java.util.Arrays;
public class Main{
     public static void main(String []args){
        //maximumTickets Function call
        int A[] = { 3, 7, 2, 9, 4 };
        // Given sum k
        int k = 15;
        int n = A.length;
        // Function call
        System.out.println(maximumTickets(A, k));
        //minimumSwaps function call
        int[] a = {1, 5, 4, 3, 2};
        System.out.println(minimumSwaps(a));
        //isPangram function call
        String str = "The quick brown fox jumps over the lazy dog"; 
        if (isPangram(str) == true) 
            System.out.println(str + " is a pangram."); 
        else
            System.out.println(str + " is not a pangram.");
     }
     //Runtime: O(n)
    static int maximumTickets(int prices[], int k){
        //there is nothing in array or n price
        if (prices.length ==0 || k <= 0)
            return 0;
        //sort array to ease adding
        //you want the max number of max_tickets
        //therfore, you want to start with small numbers
        Arrays.sort(prices);
        int max_tickets = 0;
        //loop until you get a total of at most k
        for (int i = 0; i < prices.length; i++){
            k -= prices[i];
            if (k < 0)
                break;
            max_tickets += 1;
        }
        return max_tickets;
    }
    //function called in minimumSwaps
    static int[] swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }
    // Runtime: O(n^2)
    static int minimumSwaps(int arr[]){
      if (arr.length <= 1)
        return 0;
      int count = 0;
        //bubble sort the array, and count the number of swaps
      for (int i = 0; i < arr.length; i++){
        while (arr[i] != i+1){
            //call swap function to swap the values
          arr = swap(i, arr[i]-1, arr);
          count += 1;
        }
      }
      return count;
    }
    // Runtime: O(n)
    static boolean isPangram(String str){
        //case when it cannot be a pangram
        if (str.length() < 26){
            return false;
        }
        boolean[] mark = new boolean[26]; 
        // For indexing in mark[] 
        int index = 0; 
        // Traverse all characters 
        for (int i = 0; i < str.length(); i++) { 
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') // If uppercase character, subtract 'A'
                index = str.charAt(i) - 'A'; 
            else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') // If lowercase character, subtract 'a' 
                index = str.charAt(i) - 'a'; 
            else                // If this character is other than english lowercase and uppercase characters. 
                continue; 
            mark[index] = true; 
        } 
        // Return false if any character is unmarked 
        for (int i = 0; i <= 25; i++) {
            if (mark[i] == false) {
                return (false); 
            }
        }
        // If all characters were present 
        return true;
    }
}
