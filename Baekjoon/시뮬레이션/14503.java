package Baekjoon.시뮬레이션;
import java.util.*;
import java.io.*;

class P14503 {
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int cnt = 1;
	static int n,m,r,c,d;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
				
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		st = new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(r,c,d);
		System.out.println(cnt);
	}
	
	public static void solve(int x, int y, int dir) {
		
		arr[x][y] = -1;
		
		for (int i=0;i<4;i++) {
			dir = (dir+3)%4;
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (arr[nx][ny] == 0) {
					cnt++;
					solve(nx,ny,dir);
					return;
			}	
		}
	}
		
	int d = (dir+2) % 4;
	int bx = x + dx[d];
	int by = y + dy[d];
	
	if (0 <= bx && bx < n && 0 <= by && by <m) {
		if (arr[bx][by] != 1) {
			solve(bx,by,dir);
		}
	}
	}
}