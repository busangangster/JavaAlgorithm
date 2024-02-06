package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P25628 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int k = A / 2;
		
		if (k > B) {
			sb.append(B);
		}
		else sb.append(k);
		System.out.println(sb);
	}
}
