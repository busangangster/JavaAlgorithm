package Baekjoon.수학;
import java.io.*;
import java.util.*;

class P15059 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] food = new int[3];
		int[] people = new int[3];
		
		for (int i=0; i<3;i++) {
			food[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<3;i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		
		int k = 0;
		for (int i=0; i<3;i++) {
			if (food[i] < people[i]) {
				k = people[i] - food[i];
				ans += k;
			}
		}
		sb.append(ans);
		System.out.println(sb);
	}
}
