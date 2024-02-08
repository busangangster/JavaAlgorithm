package Baekjoon.수학;
import java.io.*;

class P15727 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int s = Integer.parseInt(br.readLine());
		if (s% 5 == 0) sb.append(s/5);
		else sb.append(s/5+1);
		System.out.println(sb);

	}
}
