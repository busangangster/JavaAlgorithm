package Baekjoon.수학;
import java.util.StringTokenizer;
import java.io.*;

class P30007 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			sb.append(a*(x-1) +b).append("\n");
		}
		System.out.println(sb);
	}
}
