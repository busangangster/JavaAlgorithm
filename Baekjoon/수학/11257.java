package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P11257 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		double a_cut = 35 * 0.3;
		double b_cut = 25 * 0.3;
		double c_cut = 40 * 0.3;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N;i++) {
			boolean flag = true;
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a < a_cut) {
				flag = false;
			}
			
			if (b < b_cut) {
				flag = false;
			}
			
			if (c < c_cut) {
				flag = false;
			}
			
			int sum = a+b+c;
			
			if (sum < 55) {
				flag = false;
			}
			
			if (flag == false) {
				sb.append(name).append(" ").append(sum).append(" ").append("FAIL").append("\n");
			}
			else {
				sb.append(name).append(" ").append(sum).append(" ").append("PASS").append("\n");
			}
			
		}
		System.out.println(sb);

	}
}
