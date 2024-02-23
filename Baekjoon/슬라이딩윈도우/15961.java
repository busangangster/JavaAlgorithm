package Baekjoon.슬라이딩윈도우;
import java.util.*;
import java.io.*;

class P15961 {
    static int N,D,K,C;
	static int[] arr;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int [N];
		visited = new int[D+1];
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		int count = 0;
		
		for (int i=0; i<K; i++) {
			if (visited[arr[i]] == 0) {
				count++;
			}
			visited[arr[i]]++;
		}
		
		int ans = count;
		
		for (int i=1; i<N; i++) {
			visited[arr[i-1]]--;
			if (visited[arr[i-1]] == 0) {
				count--;
			}
			
			int idx = (i+K-1) % N;
			if (visited[arr[idx]] == 0) {
				count++;
			}
			visited[arr[idx]]++;
			
			if (visited[C] == 0) {
				ans = Math.max(ans,count+1);
			}
			else {
				ans = Math.max(ans,count);
				
			}
		}
		System.out.println(ans);
		

	}

}
