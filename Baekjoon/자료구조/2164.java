package Baekjoon.자료구조;
import java.util.*;
import java.io.*;

class P2164 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i=1;i<=N;i++) {
			q.add(i);
		}
		
		while (q.size() != 1) {
			q.poll();
			q.add(q.poll());
		}
		sb.append(q.peek());
		System.out.println(sb);
		
	}
}
