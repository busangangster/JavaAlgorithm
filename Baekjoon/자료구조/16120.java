package Baekjoon.자료구조;
import java.util.*;
import java.io.*;

class P16120 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		
		String s = br.readLine();
		for (int i=0;i<s.length();i++) {
			stack.push(s.charAt(i));
			if (stack.size() >= 4) {
				String tmp = "";
				for (int j=0;j<4;j++) {
					tmp = stack.pop() + tmp;
				}
				
				if (tmp.equals("PPAP")) {
					stack.push('P');
				} else {
					for (int z=0;z<4;z++) {
						stack.push(tmp.charAt(z));
					}
				}

			}
		}
		if (stack.size() == 1 && stack.peek() == 'P') {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
		
	}
}