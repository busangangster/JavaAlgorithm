import java.util.*;
import java.io.*;

class P9226 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = br.readLine();
			if (s.equals("#")) {
				break;
			} else {
				String tmp= "";
				outer: for (int i=0;i<s.length();i++) {
					switch(s.charAt(i)) {
					case ('a'): {
						break outer;
					}
					case ('e'): {
						break outer;
					}
					case ('i'): {
						break outer;
					}
					case ('o'): {
						break outer;
					}
					case ('u'): {
						break outer;
					}
					default: {
						tmp += s.charAt(i);
						
					}
					}
				}
				s = s.replace(tmp,"");
				sb.append(s+tmp+"ay");
				System.out.println(sb);
				sb.setLength(0);
			}
		}
	}
}