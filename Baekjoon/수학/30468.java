package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P30468 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		sum = (a+b+c+d);
		if (n*4 - sum <= 0) {
			sb.append(0);
		} else sb.append(n*4 - sum);
		System.out.println(sb);
	}
}
