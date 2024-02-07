package Baekjoon.수학;
import java.io.*;
import java.util.*;

class P15025 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if (a == 0 && b == 0) sb.append("Not a moose");
		else if (a==b) sb.append("Even").append(" ").append(a+b);
		else if (a != b) sb.append("Odd").append(" ").append(Math.max(a, b)*2);
		
		System.out.println(sb);
	} 
}
