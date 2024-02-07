package Baekjoon.구현;
import java.io.*;

class P30501 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		outer: for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0;j<s.length();j++) {
				if (s.charAt(j) == 'S') {
					sb.append(s);
					break outer;
				}
			}
		}
		System.out.println(sb);
	}
}
