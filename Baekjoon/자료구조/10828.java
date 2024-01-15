package Baekjoon.자료구조;
import java.util.*;
import java.io.*;

class P10828 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i=0;i<n;i++) {
			String[] arr = br.readLine().split(" ");

				if (arr[0].equals("top") ) {
					if (stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.peek()).append("\n");
					}
				} else if (arr[0].equals("size")) {
					sb.append(stack.size()).append("\n");
				} else if (arr[0].equals("empty")) {
					if (stack.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
				} else if (arr[0].equals("pop") ) {
					if (stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.pop()).append("\n");
					}
				} else if (arr[0].equals("push") ) {
					stack.push(Integer.parseInt(arr[1]));
			} 
		}
		System.out.println(sb);	
	}
}