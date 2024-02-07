package Baekjoon.구현;
import java.io.*;

class P5300 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		for (int i=1; i<= N;i++) {	
			sb.append(i).append(" ");
			if (i % 6 == 0) {
				sb.append("Go!").append(" ");
			}
		}
		if (N % 6 != 0) {
			sb.append("Go!");
		}
		System.out.println(sb);
	}
}
