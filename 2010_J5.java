import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//starting pair
		int y = in.nextInt() - 1;
		int x = 8 - in.nextInt();
		Pair start = new Pair(x, y);
		//ending pair
		int y2 = in.nextInt() - 1;
		int x2 = 8 - in.nextInt();
		ArrayList<Pair>[][] adj = new ArrayList[8][8];
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[i].length; j++) {
				ArrayList<Pair> list = new ArrayList<>();
				list.add(new Pair(i, j));
				if (i - 2 >= 0 && j - 1 >= 0) {
					list.add(new Pair(i-2, j-1));
				}
				if (i - 1 >= 0 && j - 2 >= 0) {
					list.add(new Pair(i-1, j-2));
				}
				if (i + 1 < 8 && j - 2 >= 0) {
					list.add(new Pair(i+1, j-2));
				}
				if (i + 2 < 8 && j - 1 >= 0) {
					list.add(new Pair(i+2, j-1));
				}
				if (i + 1 < 8 && j + 2 < 8) {
					list.add(new Pair(i+1, j+2));
				}
				if (i - 1 >= 0 && j + 2 < 8) {
					list.add(new Pair(i-1, j+2));
				}
				if (i - 2 >= 0 && j + 1 < 8) {
					list.add(new Pair(i-2, j+1));
				}
				adj[i][j] = list;
			}
		}
				
		Queue<ArrayList<Pair>> q = new LinkedList();
		int[][] dis = new int[8][8]; //shortest distance from the starting node
		boolean[][] vis = new boolean[8][8]; //keep track if visited
		
		q.add(adj[start.x][start.y]); //push the starting node into the queue
		vis[start.x][start.y] = true; //mark the starting node visited
		dis[start.x][start.y] = 0; //distance from starting node is 0
		
		while (!q.isEmpty()) {
			ArrayList<Pair> cur = q.poll(); //get the head of the queue
			//first pair is the original coordinate
			Pair ori = cur.get(0);
			for (int i = 1; i < cur.size(); i++) { 
				Pair nxt = cur.get(i);
				//get x, y coordinate
				int tempX = nxt.x; int tempY = nxt.y;
				if (!vis[tempX][tempY]) { //if not visited
					q.add(adj[tempX][tempY]); //add the newly discovered node to the queue
					vis[tempX][tempY] = true; //mark the node visited
					dis[tempX][tempY] = dis[ori.x][ori.y] + 1; 
				}
			}
		}
		System.out.println(dis[x2][y2]); 
	}
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x; this.y = y;
		}
	}

}
