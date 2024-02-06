package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P19698 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int ans = (w/l) * (h/l);
		if (ans > n) sb.append(n);
		else sb.append(ans);
		System.out.println(sb);
	}
}
