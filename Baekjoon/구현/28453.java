package Baekjoon.구현;
import java.io.*;
import java.util.*;

class P28453 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N;i++) {
			int s = Integer.parseInt(st.nextToken());
			
			if (s == 300) sb.append(1);
			else if (275 <= s) sb.append(2);
			else if ( 250 <= s) sb.append(3);
			else if ( s < 250) sb.append(4);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
