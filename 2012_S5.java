//Dynamic Programming
import java.util.*;
import java.io.*;
public class Main {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String next () throws IOException {
	  while (st == null || !st.hasMoreTokens())
	  st = new StringTokenizer(br.readLine().trim());
	  return st.nextToken();
	}
	static int readInt () throws IOException {
	  return Integer.parseInt(next());
	}
  
  public static void main(String[] args) throws IOException{ 
    int r = readInt(), c = readInt();
    int[][] array = new int[r][c]; 
    for (int i = 0; i < array.length; i++)
      for (int j = 0; j < array[i].length; j++)
        array[i][j] = -1;
    array[0][0] = 1;
    int cat = readInt();
    for (int i = 0; i < cat; i++){
      array[readInt() - 1][readInt() - 1] = 0;
    }

    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[i].length; j++){
        if (array[i][j] != 0 && !(i == 0 && j == 0)){
          int sum = 0;
          if (i != 0) sum += array[i-1][j];
          if (j != 0) sum += array[i][j-1];
          array[i][j] = sum;
        }
      }
    }
    System.out.println(array[r-1][c-1]);

  }
  
}
