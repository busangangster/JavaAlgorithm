package Baekjoon.백트래킹;
import java.io.*;
import java.util.*;

class P15650 {
    static int N,M;
	static int[] numbers;
	static boolean[] Selected;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		check(0,1);
		
	}
	
	private static void check(int cnt, int start) {
		
		if (cnt==M) {
			sb = new StringBuilder();
			for (int i=0; i< M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}
		for (int i=start; i <=N;i++) { 
 			
 			numbers[cnt] = i;
 			check(cnt+1,i+1);
 			
		}
	}
}
