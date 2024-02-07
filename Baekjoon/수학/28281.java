package Baekjoon.수학;
import java.io.*;
import java.util.*;

class P28281 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans;
		int min_v = Integer.MAX_VALUE;
		for (int i=0;i<N-1;i++) {
			ans = (arr[i]*X) + (arr[i+1]*X);
			min_v = Math.min(min_v,ans);
		}
		sb.append(min_v);
		System.out.println(sb);
		
	}
}
