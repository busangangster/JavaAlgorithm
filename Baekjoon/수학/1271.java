package Baekjoon.수학;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class P1271 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		
		sb.append(a.divide(b)).append("\n");
		sb.append(a.remainder(b));
		
		System.out.println(sb);
	
		
	}
}
