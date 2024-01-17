package Baekjoon.그리디;
import java.io.*;

class P27930 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		char[] korea = {'K','O','R','E','A'};
		char[] yonsei = {'Y','O','N','S','E','I'};
		int k = 0;
		int y = 0;
		
		for (int i=0; i<s.length();i++) {
			if (korea[k] == s.charAt(i)) {
				k++;
				if (k==5) {
					sb.append("KOREA");
					break;
				}
			}
			if (yonsei[y] == s.charAt(i)) {
				y++;
				if (y==6) {
					sb.append("YONSEI");
					break;
				
				}
			}
		}
		System.out.println(sb);
	}
}