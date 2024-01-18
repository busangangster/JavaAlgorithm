package Baekjoon.BFS;
import java.util.*;
import java.io.*;

class P1012 {
	static int[] nx = {1,0,-1,0};
	static int[] ny = {0,1,0,-1};
	static int arr[][];
	static int n,m,k;
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int ans = 0;
			arr = new int[n][m];
			visited = new boolean[n][m];
			
			for (int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			
			for (int i=0;i<n;i++) {
				for (int j=0;j<m;j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						BFS(i,j);
						ans++;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void BFS(int x,int y) {	
		Queue<int[]> dq = new LinkedList<>();
		dq.add(new int[] {x,y});
		visited[x][y] = true;
		
		while (!dq.isEmpty()) {
			int[] current = dq.poll();
			
			for (int i=0;i<4;i++) {
				int xx = current[0] + nx[i];
				int yy = current[1] + ny[i];
				
				if (0 <= xx && xx <n && 0 <= yy && yy < m && !visited[xx][yy] && arr[xx][yy] == 1) {
					visited[xx][yy] = true;
					dq.add(new int[] {xx,yy});
				}
				
			}
		}	
	}
}