package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P5596 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int m = 0;
		for (int i=0; i<4;i++) {
			m += Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int s = 0;
		for (int i=0; i<4;i++) {
			s += Integer.parseInt(st.nextToken());
		}
		
		int ans = Math.max(m, s);
		if (ans == m) {
			sb.append(m);
		} else sb.append(ans);
		
		System.out.println(sb);

	}
}
