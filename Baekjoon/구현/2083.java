package Baekjoon.구현;
import java.util.*;
import java.io.*;

class P2083 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if (name.equals("#")) break;
			
			if (age > 17 || weight >= 80) {
				sb.append(name).append(" ").append("Senior").append("\n");
			}
			else {
				sb.append(name).append(" ").append("Junior").append("\n");
			}
			
		}
		System.out.println(sb);
	}
}
