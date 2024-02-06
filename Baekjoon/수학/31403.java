package Baekjoon.수학;
import java.io.*;

class P31403 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();
		
		int aa = Integer.parseInt(A);
		int bb = Integer.parseInt(B);
		int cc = Integer.parseInt(C);
		
		// 수
		sb.append(aa+bb-cc).append("\n");
		
		// 문자열
		String plus = A+B;
		int pluss = Integer.parseInt(plus);
		sb.append(pluss-cc);
		
		System.out.println(sb);
	}
}
