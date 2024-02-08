package Baekjoon.구현;
import java.io.*;
import java.util.*;

class P15963 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		if (N-M == 0) sb.append(1);
		else sb.append(0);
		System.out.println(sb);
	}
}
