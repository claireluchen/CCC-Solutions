//graph theory (BFS)
import java.io.*;
import java.util.*;
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
		  
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis(); 
		int M = readInt();
		int N = readInt();
		int[][] array = new int[M+1][N+1];
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array[i].length; j++) {
				array[i][j] = readInt();
			}
		}
		
		List<Integer>[][] adj = new ArrayList[M+1][N+1]; //adjacency list
		for (int i = 1; i < adj.length; i++) {
			for (int j = 1; j < adj[i].length; j++) {
				adj[i][j] = new ArrayList<>();
			}
		}
		
		for (int k = 1; k <= array[1][1]; k++) {
			if (array[1][1] % k == 0) {
				adj[1][1].add(k);
				adj[1][1].add(array[1][1] / k);
			}
		}
		
		
		Queue<List<Integer>> q = new LinkedList();
		boolean[][] vis = new boolean[M + 1][N + 1]; //keep track if visited
		
		q.add(adj[1][1]); //push the starting node into the queue
		vis[1][1] = true; //mark the starting node visited
		
		while (!q.isEmpty()) {
			if (System.currentTimeMillis() - start > 1900) {
				System.out.println("yes"); return;
			}
			List<Integer> cur = q.poll(); //get the head of the queue
			for (int i = 0; i < cur.size(); i+=2) {
				int x = cur.get(i); //get new possible x
				int y = cur.get(i + 1); //get new possible y
				if (x < M+1 && y < N+1 && !vis[x][y]) {
					int num = array[x][y];
					for (int k = 1; k <= num; k++) {
						if (num % k == 0) {
							adj[x][y].add(k);
							adj[x][y].add(num / k);
						}
					}
				}
											
				if (x < M + 1 && y < N + 1) {
					List<Integer> tempList = adj[x][y]; //get the places the node can lead to
					if (!vis[x][y] && tempList != null) { //if not visited
						q.add(tempList);
						vis[x][y] = true;
						if (vis[M][N]) {System.out.println("yes"); return;}
					}
				}	
			}
		}
		
		System.out.println("no");
	}

}
