package Baekjoon.백트래킹;
import java.util.*;
import java.io.*;

class P15649 {
    static int n,m;
	static int[] numbers;
	static boolean[] check;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		check = new boolean[n+1];
		numbers  = new int[m];
		permutation(0);
		
		System.out.println(sb);
	}
	
	private static void permutation(int cnt) {
		if (cnt == m) {
			for (int n:numbers) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i =1; i<=n;i++) {
			if (check[i]) continue;
			
			numbers[cnt] = i;
			check[i] = true;
			permutation(cnt+1);
			check[i] = false;
		}
	}
}
