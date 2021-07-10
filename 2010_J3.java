import java.util.*;
public class Main {
  static int a, b;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    String x = "";
    while (!input.equals("7")){
      switch(input.charAt(0)){
        case '1': 
          x = input.charAt(2) + "";
          int n = Integer.parseInt(input.substring(4));
          if (x.equals("A")) a = n;
          else b = n;
          break;
        case '2':
          x = input.charAt(2) + "";
          if (x.equals("A")) System.out.println(a);
          else System.out.println(b);
          break;
        default: method(input);
      }
      input = in.nextLine();
    }
  }

  public static void method(String input){
    int ord = Integer.parseInt(input.substring(0, 1));
    char x = input.charAt(2);
    char y = input.charAt(4);
    if (x == 'A'){
      if (y == 'A'){
        switch(ord){
          case 3: a += a; break;
          case 4: a *= a; break;
          case 5: a -= a; break;
          case 6: a /= a; break;
        }   
      }else{
        switch(ord){
          case 3: a += b; break;
          case 4: a *= b; break;
          case 5: a -= b; break;
          case 6: a /= b; break;
        }
      }
    }else{
      if (y == 'B'){
        switch(ord){
          case 3: b += b; break;
          case 4: b *= b; break;
          case 5: b -= b; break;
          case 6: b /= b; break;
        }
      }else{
        switch(ord){
          case 3: b += a; break;
          case 4: b *= a; break;
          case 5: b -= a; break;
          case 6: b /= a; break;
        }
      }
    }
  }
}
