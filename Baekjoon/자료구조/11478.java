import java.util.*;
import java.io.*;

class prac {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		HashSet<String> hs = new HashSet<>();

		for (int i=0; i<s.length(); i++) {
			for (int j=i; j<s.length(); j++) {
				String tmp = s.substring(i, j+1);
				if (hs.contains(tmp)) {
					continue;
				}
				else {
					hs.add(tmp);
				}
			}
		}
		System.out.println(hs.size());
	}	
}
