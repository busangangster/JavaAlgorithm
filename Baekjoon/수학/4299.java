package Baekjoon.수학;
import java.util.*;
import java.io.*;

class P4299 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		
		boolean flag = false;
		outer: for (int i=0;i<1000;i++) {
			for (int j=0;j<1000;j++) {
				if (i+j == sum && Math.abs(i-j) == minus) {
					flag = true;
					sb.append(Math.max(i, j)).append(" ").append(Math.min(i,j));
					break outer;
				}
			}
		}
		if (flag == false) {
			sb.append(-1);
		}
		
		System.out.println(sb);

	}
}
