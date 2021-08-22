//Dynamic programming
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
    int distance = readInt();
    int num = readInt();
    int[] clubs = new int[num];
    for (int i = 0; i < num; i++) clubs[i] = readInt();
    int[] least = new int[distance + 1]; Arrays.fill(least, 5281);
    least[0] = 0;

    for (int i = 0; i < least.length; i++){
      for (int j = 0; j < clubs.length; j++){
        if (i + clubs[j] <= distance){
          if (least[i] + 1 < least[i + clubs[j]]){
            least[i + clubs[j]] = least[i] + 1;
          }
        }
      }
    }

    if (least[distance] >= 5281) System.out.println("Roberta acknowledges defeat.");
    else System.out.printf("Roberta wins in %d strokes.", least[distance]);
  }
  
}
