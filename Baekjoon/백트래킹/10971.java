import java.io.*;
import java.util.*;

public class Main_실버2_10971_외판원순회2_김하휼 {
	static int N;
	static boolean[] visited;
	static int[][] graph;
	static int res;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		res = Integer.MAX_VALUE;
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i=1; i<=N; i++) {
			visited[i] = true;
			DFS(i,i,1,0);
			visited[i] = false;
		}
		System.out.println(res);
	}
		
	
	public static void DFS(int start, int cur, int cnt, int sum) {
		if (cnt == N) {
			if (graph[cur][start] == 0) return;
			
			sum += graph[cur][start];
			res = Math.min(res, sum);
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if (!visited[i] && graph[cur][i] != 0) {
				visited[i] = true;
				DFS(start,i,cnt+1,sum+graph[cur][i]);
				visited[i] = false;
			}
		}
	}
}
