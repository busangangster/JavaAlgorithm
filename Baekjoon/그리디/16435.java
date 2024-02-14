package Baekjoon.그리디;
import java.io.*;
import java.util.*;

class P16435 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(arr);
		for (int i=0; i<N; i++) {
			if (L >= arr[i]) L++;
			else break;
		}
		sb.append(L);
		System.out.println(sb);
	}
}
