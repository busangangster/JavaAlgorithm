package Baekjoon.구현;
import java.io.*;

class P2562 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int max_v = Integer.MIN_VALUE;
		int idx = 0;
		for (int i=0;i<9;i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > max_v) {
				max_v = num;
				idx = i+1;
			}
			
		}
		System.out.println(max_v);
		System.out.println(idx);
		
	}
}