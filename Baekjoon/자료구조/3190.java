package Baekjoon.자료구조;
import java.util.*;
import java.io.*;

class P3190 {

	static int arr[][];
	static int n;
	static char[] direction = new char[10001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		arr = new int[n][n]; 
		
		for (int i=0;i<k;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x-1][y-1] = 2;
		}
		 
		int L = Integer.parseInt(br.readLine());
		
		for (int l=0;l<L;l++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int second = Integer.parseInt(st.nextToken());
			char di = st.nextToken().charAt(0);
			direction[second] = di;
		}
		gogo();
	}
	
	static void gogo() {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int d = 0;
		int time = 0;
		
		Deque<Point> dq = new ArrayDeque<>();
		dq.offerFirst(new Point(0,0));
		arr[0][0] = 1;
		
		while (true) {
			time++;
			Point pos = dq.getFirst();
			int cx = pos.x;
			int cy = pos.y;
			
			cx += dx[d];
			cy += dy[d];
			
			if (!isFinished(cx,cy)) {
				break;
			}
			
			dq.addFirst(new Point(cx,cy));
			
			if (arr[cx][cy] != 2) {
				Point tail = dq.removeLast();
				arr[tail.x][tail.y]= 0; 
			} 
			
			arr[cx][cy] = 1;
			
			if (direction[time] == 'D') {
				d += 1;
				if (d == 4) {
					d = 0;
				}	
			} else if (direction[time] == 'L'){
				d -= 1;
				if (d == -1) {
					d = 3;
				}
			}
			
		}
		System.out.println(time);
	}
	
	public static boolean isFinished(int x, int y) {
		if (x <0 || x >= n || y <0 || y >= n) {
			return false;
		}
		 if (arr[x][y] == 1) {
			return false;
		}
		return true;	
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}