package Baekjoon.BFS;
import java.io.*;
import java.util.*;

class P4179 {
    static int R,C, start_x,start_y;
	static char[][] graph;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static Queue<Pos> fire = new ArrayDeque<>();
	static Queue<Pos> ji = new ArrayDeque<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graph = new char[R][C];
		visited1 = new boolean[R][C];
		visited2 = new boolean[R][C];

		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				if (s.charAt(j) == 'F') {
					fire.offer(new Pos(i, j));
					visited1[i][j] = true;
				}
				else if (s.charAt(j) == 'J'){
					ji.offer(new Pos(i,j));
					visited2[i][j] = true;
					graph[i][j] = '.';
				}
				else {
					graph[i][j] = s.charAt(j);
				}
			}
		}

		int ans = bfs();
		System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);

    }

	public static int bfs() {
		int time = 0;

		while (!ji.isEmpty()) {

			int fireSize = fire.size();
			int jiSize = ji.size();

			for (int i=0; i<fireSize; i++) {

				Pos cur = fire.poll();

				for (int j=0; j<4; j++) {
					int fx = cur.x + dx[j];
					int fy = cur.y + dy[j];

					if (fx < 0 || fx >= R || fy < 0 || fy >= C) continue;

					if (graph[fx][fy] == '#') continue;
					if (visited1[fx][fy]) continue;
				
					graph[fx][fy] = 'F';
					fire.offer(new Pos(fx, fy));
					visited1[fx][fy] = true;
					
				}
			}

			for (int i=0; i< jiSize; i++) {
				Pos tmp = ji.poll();

				for (int j=0; j<4; j++) {
	
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
	
					if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
						return time+1;
					}
					// System.out.println(nx+" " + ny);
	
					if (graph[nx][ny] != '.') continue;
					if (visited2[nx][ny]) continue;

					ji.offer(new Pos(nx,ny));
					visited2[nx][ny] = true;
					
				}
			}
			time++;
		}
		return -1;
	}

	public static boolean check(int x,int y) {
		if ( 0 <= x && x < R && 0 <= y && y < C) return true;
		else return false;
	}

	public static boolean done(int x, int y){
		if (x == 0 || y == 0 || x == R-1 || y == C-1) return false;
		else return true;
	}
}

class Pos {
	int x,y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;

	}
}
