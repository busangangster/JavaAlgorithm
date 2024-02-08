package Baekjoon.수학;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

class P13277 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		
		sb.append(a.multiply(b));
		System.out.println(sb);
	}
}
