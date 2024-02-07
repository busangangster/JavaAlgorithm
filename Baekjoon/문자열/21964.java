package Baekjoon.문자열;
import java.io.*;

class P21964 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		for (int i=0;i<n;i++) {
			if (i >= n-5) {
				sb.append(s.charAt(i));
			}
		}
		System.out.println(sb);
	}
}
