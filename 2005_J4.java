import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws IOException {
		int b = readInt(); //width of the board/num of columns
		int a = readInt(); //height of the board/num of rows
		int cutb = readInt(); //width of the cutout piece
		int cuta = readInt(); //height of the cutout piece
		int numOfSteps = readInt(); //number of steps
		int[][] array = new int[a][b];
		for (int i = 0; i < cutb; i++) {
			for (int j = 0; j < cuta; j++) {
				array[j][i] = 1;
				array[j][array[0].length - i - 1] = 1;
				array[array.length - j - 1][i] = 1;
				array[array.length - j - 1][array[0].length - i - 1] = 1;
			}
		}
		
		int numOfStepsTaken = -1;
		int x = 0;
		int y = cutb - 1;
		Loop:
		while (numOfStepsTaken < numOfSteps) {
			boolean boo = true;
			while (array[x][y+1] != 1) {
				boo = false;
				y++;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (array[x][y+1] == 1 && array[x+1][y] != 1) {
				boo = false; 
				x++;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (y < array[0].length - 1 && array[x - 1][y] == 1 && array[x][y+1] != 1) {
				boo = false;
				y++;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (array[x + 1][y] != 1) {
				boo = false;
				x++;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;

			while (array[x + 1][y] == 1 && array[x][y-1] != 1) {
				boo = false;
				y--;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (x < array.length - 1 && array[x][y+1] == 1 && array[x+1][y] != 1) {
				boo = false;
				x++;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (array[x][y-1] != 1) {
				boo = false;
				y--;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (array[x][y-1] == 1 && array[x-1][y] != 1) {
				boo = false;
				x--;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (y > 0 && array[x + 1][y] == 1 && array[x][y-1] != 1) {
				boo = false;
				y--;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (array[x-1][y] != 1) {
				boo = false;
				x--;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (array[x - 1][y] == 1 && array[x][y+1] != 1) {
				boo = false;
				y++;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
			boo = true;
			while (array[x - 1][y] != 1) {
				boo = false;
				x--;
				array[x][y] = 1;
				numOfStepsTaken++;
				if (numOfStepsTaken >= numOfSteps) {
					break Loop;
				}
			}
			if (boo) {break Loop;}
		}
		
		System.out.println(y + 1);
		System.out.println(x + 1);
	}

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      static String next () throws IOException {
	    	 while (st == null || !st.hasMoreTokens())
	    	 st = new StringTokenizer(br.readLine().trim());
	    	 return st.nextToken();
	      }
		  static long readLong () throws IOException {
		    return Long.parseLong(next());
		  }
		  static int readInt () throws IOException {
		    return Integer.parseInt(next());
		  }
		  static double readDouble () throws IOException {
		    return Double.parseDouble(next());
		  }
		  static char readCharacter () throws IOException {
		    return next().charAt(0);
		  }
		  static String readLine () throws IOException {
		    return br.readLine().trim();
		  }

}
