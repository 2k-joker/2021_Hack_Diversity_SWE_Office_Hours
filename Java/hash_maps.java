/// By: Merna Alghannam

import java.util.*; 
import java.io.*;

class Hashes {

  public static int maxSocksPairs(int[] arr){
    if(arr.length == 0)
      return 0;

    HashSet<Integer> unmatched = new HashSet<>();
    int pairs = 0;
    for(int i = 0; i < arr.length; i++) {
        if(!unmatched.add(arr[i])) {
            unmatched.remove(arr[i]);
            pairs++;
        }
    }
    return pairs;
  }

  static int[] longestRange(int arr[]){
    if(arr.length < 1){
      System.out.println("invalid entry");
      return null;
    }

    HashMap<Integer, Boolean> S = new HashMap<Integer, Boolean>();
    int[] range = new int[2]; 
    int upper = 0;
    int lower = 0;



    int longestRange = 0;
    int currentRange = 0;

    for (int n : arr){
      S.put(n, false);
    }

    for (int n : arr) {
      if (!S.get(n)) {
        upper = n + 1 ;
        lower = n - 1;
        while (S.containsKey(upper)){
          S.put(upper, true);
          upper += 1;
        }
        while (S.containsKey(lower)){
          S.put(lower, true);
          lower -= 1;
        }
        currentRange = upper - lower;
        if (currentRange > longestRange){
          longestRange = currentRange;
          range[1] = upper - 1;
          range[0] = lower + 1;
        }
      }
    }

    return range;
  }

  static int sherlockAndAnagram(String s){
    if(s.length() < 1){
     return 0;
    }
    HashMap<String, Integer> valMap = new HashMap<>();

    for(int i = 0; i < s.length(); i++){
        for(int j = i; j < s.length(); j++){
            char[] valC = s.substring(i, j+1).toCharArray();
            Arrays.sort(valC);
            String val = new String(valC);
            if (valMap.containsKey(val)) 
                valMap.put(val, valMap.get(val)+1);
            else 
                valMap.put(val, 1);
        }
    }
    int result = 0;
    for(String key: valMap.keySet()){
        int n = valMap.get(key);
        result += (n * (n-1))/2;
    }
    return (result);
  }

  public static void main(String[] args) {
    //max socks pairs
    int[] sockpair = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
    System.out.println(maxSocksPairs(sockpair));

    //max findLongestConseqSubseq
    int arr[] = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
    int n = arr.length;

    int[] ans = longestRange(arr);
    System.out.println(
        "Length of the Longest consecutive subsequence is "
        + "[" + ans[0] + "," + ans[1] + "]");

    //sherlock and anagram
    System.out.println(sherlockAndAnagram("mom"));
  }

}
