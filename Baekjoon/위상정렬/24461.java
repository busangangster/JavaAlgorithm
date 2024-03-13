package Baekjoon.위상정렬;
import java.io.*;
import java.util.*;

class P24461 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int N;
	static int[] inDegrees; 
	static ArrayList<Integer> ans = new ArrayList<>();
	static ArrayList<Integer> tmp = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}

		inDegrees = new int[N];
		

		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
			inDegrees[b]++;
			inDegrees[a]++;

		}

		ts();
		Collections.sort(tmp);
		for (int v:tmp) {
			sb.append(v).append(" ");
		}
		System.out.println(sb);

	}

	public static void ts() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=0; i<inDegrees.length; i++) {
			if (inDegrees[i] == 1) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {

			int t = q.size();

			if (t <= 2) {
				for (int i=0; i<t; i++) {
					int cur = q.poll();
					tmp.add(cur);
	
					for (int next: graph.get(cur)) {
						inDegrees[next]--;
						if (inDegrees[next] == 1) {
							q.offer(next);
						}
					}
				}
			}
			else {
				for (int i=0; i<t; i++) {
					int cur = q.poll();
	
					for (int next: graph.get(cur)) {
						inDegrees[next]--;
						if (inDegrees[next] == 1) {
							q.offer(next);
						}
					}
				}
			}
		}
	}
}
