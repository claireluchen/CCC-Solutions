import java.io.*;
import java.util.*;
import java.math.BigInteger;
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
		  static char readCharacter () throws IOException {
			    return next().charAt(0);
		  }
		  static ArrayList<Integer> result = new ArrayList<>();
		  
	public static void main(String[] args) throws IOException{
		int t = readInt();
		for (int z = 0; z < t; z++) {
			int r = readInt(), c = readInt();
			char[][] input = new char[r][c];
			ArrayList<Pair>[][] adj = new ArrayList[r][c];
						for (int i = 0; i < adj.length; i++) {
				String line = next(); //
			for (int j = 0; j < adj[i].length; j++) {
				input[i][j] = line.charAt(j); //
//				input[i][j] = readCharacter();
				adj[i][j] = new ArrayList();
				}
			}
			for (int i = 0; i < input.length; i++) { //adjacency matrix
				for (int j = 0; j < input[i].length; j++) {
					char tempChar = input[i][j];
					adj[i][j].add(new Pair(i, j));
					if (tempChar == '+') {
						if (i != 0 && input[i-1][j] != '*') {
							adj[i][j].add(new Pair(i - 1, j));
						}
						if (i != input.length - 1 && input[i+1][j] != '*') {
							adj[i][j].add(new Pair(i + 1, j));
						}
						if (j != 0 && input[i][j-1] != '*') {
							adj[i][j].add(new Pair(i, j - 1));
						}
						if (j != input[i].length - 1 && input[i][j+1] != '*') {
							adj[i][j].add(new Pair(i, j + 1));
						}
					}else if (tempChar == '-') {
						if (j != 0 && input[i][j-1] != '*') {
							adj[i][j].add(new Pair(i, j - 1));
						}
						if (j != input[i].length - 1 && input[i][j+1] != '*') {
							adj[i][j].add(new Pair(i, j + 1));
						}
					}else if (tempChar == '|') {
						if (i != 0 && input[i-1][j] != '*') {
							adj[i][j].add(new Pair(i - 1, j));
						}
						if (i != input.length - 1 && input[i+1][j] != '*') {
							adj[i][j].add(new Pair(i + 1, j));
						}
					}
				}
			}
			
			//adj[][] is an adjacency matrix storing Pairs where it can lead to
			Queue<ArrayList<Pair>> q = new LinkedList();
			int[][] dis = new int[r][c]; //shortest distance from the starting house
			boolean[][] vis = new boolean[r][c]; //keep track if visited
			Pair[][] pre = new Pair[r][c];
			
			q.add(adj[0][0]); //push the house starting with into the queue
			vis[0][0] = true; //mark the starting house visited
			dis[0][0] = 0; //distance from starting house is 0
			pre[0][0] = new Pair(0, 0);
			
			while (!q.isEmpty()) {
				ArrayList<Pair> cur = q.poll(); //get the head of the queue
				if (!cur.isEmpty()) {
					Pair coordinateOfCur = cur.get(0);					
					for (int i = 1; i < cur.size(); i++) { //for each pair (representing a place cur leads to)
						Pair pair = cur.get(i);
						int x = pair.x;
						int y = pair.y;
						pre[x][y] = new Pair(coordinateOfCur.x, coordinateOfCur.y);
						if (!vis[x][y]) {
							q.add(adj[x][y]);
							vis[x][y] = true;
							dis[x][y] = dis[pre[x][y].x][pre[x][y].y] + 1; 
						}
					}
				}
				
			}
			
			if (vis[r-1][c-1]) {
				result.add(dis[r - 1][c - 1] + 1);							
			}else {
				result.add(-1);
			}
		}	
		for (int i = 0; i < result.size(); i++) {System.out.println(result.get(i));}
	}
	static class Pair{
		int x, y;
		Pair (int po, int vo){
			x = po; y = vo;
		}		
	}

}
