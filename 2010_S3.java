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
    int n = readInt();
    int[] housePos = new int[n];
    boolean[] vis = new boolean[n];
    for (int i = 0; i < n; i++){
      housePos[i] = readInt();
    }
    Arrays.sort(housePos);
    int numHydrant = readInt();

    int high = 999999, low = 0;
    int x = (high + low) / 2; 
    int min = Integer.MAX_VALUE;
    
    for (; high >= low; x = (high + low) / 2){
      boolean possible = false;

      //each hydrant covers x meters
      for (int z = 0; z < x; z++){
        vis = new boolean[n];
        int reachPos = housePos[0] - z; int fromHouseIndex = 0;
        for (int i = 0; i < numHydrant; i++){ 
          vis[fromHouseIndex] = true;
          reachPos = housePos[fromHouseIndex] + x - 1;
          int j = fromHouseIndex;
          
          for (; j < n && housePos[j] <= reachPos; j++){
            vis[j] = true;
          }
          if (j < n){
            fromHouseIndex = j;
            reachPos = housePos[j];
          }
        }
        if (vis[n - 1]){
          possible = true; break;
        }
      }
      
      //change high / low
      if (possible){
        high = x - 1;
        min = Math.min(min, x);
      }else{
        low = x + 1;
      }
    }

    System.out.println(min / 2);
  }
  
}
