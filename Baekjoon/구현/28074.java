package Baekjoon.구현;
import java.io.*;
import java.util.*;

class P28074 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		HashSet<Character> hs = new HashSet<>();
		
		for (int i =0; i< s.length(); i++) {
			switch (s.charAt(i)) {
			case ('M'): {
				hs.add(s.charAt(i));
				break;
			}
			case ('O'): {
				hs.add(s.charAt(i));
				break;
			}
			case ('B'): {
				hs.add(s.charAt(i));
				break;
			}
			case ('I'): {
				hs.add(s.charAt(i));
				break;
			}
			case ('S'): {
				hs.add(s.charAt(i));
				break;
			}
			}
		}
		if (hs.size() == 5) System.out.println("YES");
		else System.out.println("NO");
	}
}
