import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int x = 0; x < t; x++){
      String result = "";
      String input = in.next();
      for (int i= 0; i < input.length() && result.length() < 10; i++){
       String cur = input.substring(i, i+1);
       if (cur.equals("-")){
       }else if (cur.equals("A") || cur.equals("B") || cur.equals("C")){
         result += "2";
       }else if (cur.equals("D") || cur.equals("E") || cur.equals("F")){
         result += "3";
       }else if (cur.equals("G")|| cur.equals("H")|| cur.equals("I")){
         result += "4";
       }else if (cur.equals("J")|| cur.equals("K")|| cur.equals("L")){
         result += "5";
       }else if (cur.equals("M")|| cur.equals("N")|| cur.equals("O")){
         result += "6";
       }else if (cur.equals("P")|| cur.equals("Q")|| cur.equals("R")|| cur.equals("S")){
         result += "7";
       }else if (cur.equals("T")|| cur.equals("U")|| cur.equals("V")){
         result += "8";
       }else if (cur.equals("W")|| cur.equals("X")|| cur.equals("Y")|| cur.equals("Z")){
         result += "9";
       }else{
         int a = Integer.parseInt(cur);
         result += a;
       }
      }
      System.out.printf("%s-%s-%s%n", result.substring(0, 3), result.substring(3, 6), result.substring(6));
    }
  }
}
