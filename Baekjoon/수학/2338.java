package Baekjoon.수학;
import java.io.*;
import java.math.BigInteger;

class P2338 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int 형, long 형보다 큰 수가 들어올 수 있는 경우 => BigInteger 
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        sb.append(a.add(b)).append("\n").append(a.subtract(b)).append("\n").append(a.multiply(b));
        System.out.println(sb);
    }
}
