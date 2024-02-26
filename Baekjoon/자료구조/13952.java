package Baekjoon.자료구조;
import java.util.*;
import java.io.*;

class P13952 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Stack<Node> stack = new Stack<Node>();
		int ans = 0;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				int a = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				stack.add(new Node(a,t-1));
			}
			
			else {
				if (stack.isEmpty()) {
					continue;
				}
				else {
					stack.get(stack.size()-1).time -= 1;

				}
			}
			
			if (!stack.isEmpty()) {
				if (stack.get(stack.size()-1).time == 0) {
					ans += stack.get(stack.size()-1).score;
					stack.pop();
				}
			}
		}
		System.out.println(ans);
		
	}
}

class Node{
	int score;
	int time;
	public Node(int score, int time) {
		this.score = score;
		this.time = time;
	}
}
