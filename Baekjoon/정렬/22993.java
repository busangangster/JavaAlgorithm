package Baekjoon.정렬;
import java.io.*;
import java.util.*;

class P22993 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<info> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder(); 
		
		int n = Integer.parseInt(br.readLine()); 
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for (int i=0; i<n;i++) {
			arr.add(new info (Integer.parseInt(st.nextToken())));
		}
		
		long jun = arr.get(0).damage;
	
		arr.remove(0);
		
		Collections.sort(arr);
		
		boolean flag = true;
		
		for (int i=0 ;i<arr.size();i++) {
			if (jun > arr.get(i).damage) {
				jun += (long) arr.get(i).damage;
			}
			else {
				flag = false;
				break ;
			}
		}
		
		if (flag) sb.append("Yes");
		else sb.append("No");
		
		System.out.println(sb);
	}
}

class info implements Comparable<info> {
	int damage;
	
	public info(int damage) {
		this.damage = damage;
	}
	
	@Override
	public int compareTo(info o) {
		return this.damage - o.damage;
	}	
}