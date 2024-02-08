package Baekjoon.구현;
import java.io.*;

class P14581 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		String s = br.readLine();
		
		sb.append(":fan::fan::fan:").append("\n");
		sb.append(":fan::").append(s).append("::fan:").append("\n");
		sb.append(":fan::fan::fan:").append("\n");
		System.out.println(sb);
	}
}
