package Baekjoon.구현;
import java.io.*;

class P31306 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		int vowels = 0;
		int y = 0;
		
		for (int i=0; i<s.length();i++) {
			switch (s.charAt(i)) {
				
			case 'a': {
				vowels++;
				break;
			}
			case 'e': {
				vowels++;
				break;
			}
			case 'i': {
				vowels++;
				break;
			}
			case 'o': {
				vowels++;
				break;
			}
			case 'u': {
				vowels++;
				break;
			}
			case 'y': {
				y++;
				break;
			}
			}
		}
		sb.append(vowels).append(" ").append(vowels+y);
		System.out.println(sb);
	}
}
