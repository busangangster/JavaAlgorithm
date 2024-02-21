import java.io.*;
import java.util.*;

class P29634 {
	static int N,M;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[N][M];
		int ans = Integer.MIN_VALUE;
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == '*') {
					visited[i][j] = true;
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (arr[i][j] == '.') {
					int tmp = search(i, j);
					ans = Math.max(ans, tmp);
				}
			}
		}
		
		if (ans == Integer.MIN_VALUE) System.out.println(-1);
		else System.out.println(ans);

	}
	
	public static int search(int x, int y) {
		Queue<Node> q = new ArrayDeque<Node>();
		int cnt = 1;
		visited[x][y] = true;
		arr[x][y] = '*';
		q.offer(new Node(x,y));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (check(nx,ny) && !visited[nx][ny] && arr[nx][ny] == '.') {
					visited[nx][ny] = true;
					arr[nx][ny] = '*';
					q.offer(new Node(nx,ny));
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static boolean check(int x, int y) {
		if (0<= x && x < N && 0<= y && y < M) {
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
