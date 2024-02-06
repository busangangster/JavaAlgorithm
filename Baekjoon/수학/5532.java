package Baekjoon.수학;
import java.io.*;

class P5532 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		
		int korean = 0 ;
		if (A%C == 0) korean = A/C;
		else korean = A/C+1;
		
		int math = 0;
		if (B%D == 0) math = B/D;
		else math = B/D+1;
		
		sb.append(L- Math.max(korean, math));
		System.out.println(sb);
		
	}    
}
