import java.io.*;
import java.util.*;

public class Main {
	static int N,M,K;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		int cnt = 0;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (!visited[i][j]) {
					search(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void search(int x, int y) {
		Queue<Node> q = new ArrayDeque<Node>();
		visited[x][y] = true;
		q.offer(new Node(x,y));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (check(nx,ny)) {
					if (!visited[nx][ny]) {
						if (Math.abs(arr[cur.x][cur.y] - arr[nx][ny]) <= K) {
							visited[nx][ny] = true;
							q.offer( new Node(nx,ny));
						}
					}
				}
			}
		}		
	}
	
	public static boolean check(int x, int y) {
		if (0<= x && x < N && 0 <= y && y <M) {
			return true;
		}
		return false;
	}

}

class Node {
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
