import java.io.*;
import java.util.*;

public class prac { 
	static int[] nums = new int[10];
	static int[] ans = new int[10];
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<10; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(Arrays.toString(nums));

		perm(0,0);
		System.out.println(cnt);

	}

	public static void perm(int count, int score) {
		if (count == 10) {
			if (score >= 5) cnt++;
			// System.out.println("here");
			return;
			
		}

		for (int i=1; i<6; i++) {
			if (count >= 2 && ans[count-1] == i && ans[count-2] == i) continue;

			ans[count] = i;
			if (ans[count] == nums[count]) perm(count+1,score+1);
			else perm(count+1,score);
		}
	}
}