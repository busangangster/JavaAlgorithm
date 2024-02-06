package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P2845 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<5;i++) {
			sb.append(Integer.parseInt(st.nextToken()) - (L*P)).append(" ");
		}
		System.out.println(sb);
		
	}
}
