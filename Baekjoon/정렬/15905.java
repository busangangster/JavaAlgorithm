package Baekjoon.정렬;
import java.io.*;
import java.util.*;

class P15905 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<info> arr = new ArrayList<>();
		
		for (int i=0; i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.add(new info(a,b));
		}
		
		Collections.sort(arr);
		
		int t = arr.get(4).num;
		int ans = 0;
		
		for (int i=5;i<arr.size();i++) {
			if (arr.get(i).num == t) ans++;
			else break;
		} 
		
		System.out.println(ans);	
    } 
}

class info implements Comparable<info> {
	int num;
	int penalty;
	
	public info(int num, int penalty) {
		this.num = num;
		this.penalty = penalty;
	}

	@Override
	public int compareTo(info o) {
		if (this.num == o.num) {
			return this.penalty - o.penalty;
		}	
	 return o.num - this.num;
	}
}