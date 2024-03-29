package Baekjoon.BFS;
import java.util.*;
import java.io.*;

class P14940 {
	static int[] nx = {1,0,-1,0};
	static int[] ny = {0,1,0,-1};
	static int arr[][],ans[][],n,m;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m]; // 지도
		visited = new boolean[n][m]; // 방문여부 확인
		ans = new int[n][m];

		int x=0,y=0; // 좌표의 값이 2일 때 해당 좌표를 찾기 위한 변수
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					x = i;
					y = j;
				} else if (arr[i][j] == 0) {
					visited[i][j] = true; // 좌표의 값이 0이면 가지 못하는 곳이기에 방문여부를 True로 초기화
				}
			}
		}

    	BFS(x,y); 

		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (!visited[i][j]) {
					ans[i][j] = -1 ;
				}
				sb.append(ans[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
  
	public static void BFS(int x,int y) {
		Queue<int []> dq = new LinkedList<>();
		dq.add(new int[] {x,y});
		visited[x][y] = true;
		
		while (!dq.isEmpty()) {
      		int[] current = dq.poll();
			
			for (int i=0;i<4;i++) {
				int xx = current[0] + nx[i];
				int yy = current[1] + ny[i];
				
				if (0<= xx && xx <n && 0<= yy && yy < m && !visited[xx][yy] && arr[xx][yy] == 1) {
					ans[xx][yy] = ans[current[0]][current[1]] + 1;
          			visited[xx][yy] = true;
          			dq.add(new int[] {xx,yy});
				}
			}
		}
	}
}