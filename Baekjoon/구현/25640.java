package Baekjoon.구현;
import java.io.*;

class P25640 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i=0;i<N;i++) {
			String k = br.readLine();
			if (s.equals(k)) cnt++;
		}
		
		System.out.println(cnt);
	}
}
