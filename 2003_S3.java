//Graph theory (BFS)
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
	
	public static void main(String[] args) throws IOException{
		int numOfWood = readInt();
		int rows = readInt();
		int cols = readInt();
		ArrayList<Integer>[][] adj = new ArrayList[rows][cols];
		
		int roomInstalled = 0;
		int totalRoomMeter = 0;
		char[][] array = new char[rows][cols];
		String[] inputStrings = new String[rows];
		for (int i = 0; i < array.length; i++) {
			String str = next();
			inputStrings[i] = str;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = inputStrings[i].charAt(j);
				if (array[i][j] == '.') {
					totalRoomMeter++;
				}
				adj[i][j] = new ArrayList();
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == '.') {
					if (j != 0) {
						if (array[i][j-1] == '.') {
							adj[i][j].add(i); adj[i][j].add(j-1);
						}	
					}
					if (j != array[i].length - 1) {
						if (array[i][j+1] == '.') {
							adj[i][j].add(i); adj[i][j].add(j+1);
						}
					}
					if (i != 0) {
						if (array[i-1][j] == '.') {
							adj[i][j].add(i-1); adj[i][j].add(j);
						}
					}
					if (i != array.length - 1) {
						if (array[i+1][j] == '.') {
							adj[i][j].add(i+1); adj[i][j].add(j);
						}
					}
					
				}
			}
		}
		
		ArrayList<Integer> roomSize = new ArrayList<>();
		int tempTotalRoomMeter = 0;
		int size = 0;
		for (int i = 0; i < adj.length && tempTotalRoomMeter < totalRoomMeter; i++) {
			for (int j = 0; j < adj[i].length && tempTotalRoomMeter < totalRoomMeter; j++) {				
				if(array[i][j] == '.') {	
					if (adj[i][j].isEmpty()) {roomSize.add(1); continue;}
					Queue<ArrayList<Integer>> q = new LinkedList();
					q.add(adj[i][j]);
					while (!q.isEmpty()) {
						ArrayList<Integer> list = q.poll();
						for (int k = 0; k < list.size() - 1; k+=2) {
							int x = list.get(k), y = list.get(k+1);
							if (array[x][y] == '.') {
								size++;
								array[x][y] = 'I';
								q.add(adj[x][y]);
							}
						}
						
					}
					roomSize.add(size);
					tempTotalRoomMeter += size;
					size = 0;
				}
			}
		}
			
		
		Collections.sort(roomSize);
		for (int i = roomSize.size() - 1; i >= 0; i--) {
			int curSize = roomSize.get(i);
			if (numOfWood - curSize >= 0) {
				numOfWood -= curSize;
				roomInstalled++;
			}else {
				break;
			}
		}
		
		if (roomInstalled != 1) {
			System.out.println(roomInstalled +" rooms, " + numOfWood + " square metre(s) left over");
		}else {
			System.out.println(roomInstalled +" room, " + numOfWood + " square metre(s) left over");
		}
	}

}
