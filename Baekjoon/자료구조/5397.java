import java.util.*;
import java.io.*;


class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t=0; t<tc; t++) {
			String s = br.readLine();

			Deque<Character> d1 = new ArrayDeque<>();
			Deque<Character> d2 = new ArrayDeque<>();

			for (int i=0; i<s.length(); i++) {
				if (s.charAt(i) == '<') {
					if (d1.isEmpty()) {
						continue;
					}
					else {
						d2.addFirst(d1.pollLast());
					}
				}
				else if (s.charAt(i) == '>') {
					if (d2.isEmpty()) {
						continue;
					}
					else {
						d1.addLast(d2.pollFirst());
					}
				}
				else if (s.charAt(i) == '-') {
					if(!d1.isEmpty()) {
						d1.pollLast();
					}
				}
				else {
					d1.add(s.charAt(i));
				}
			}
			d1.addAll(d2);
			for (int i=d1.size(); i>0; i--) {
				sb.append(d1.pollFirst());
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}
}
