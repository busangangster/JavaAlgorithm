package Baekjoon.수학;
import java.io.*;
import java.math.BigInteger;

class P1247 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<3;i++) {
            int n = Integer.parseInt(br.readLine());
            BigInteger ans = new BigInteger("0");

            for (int j=0;j<n;j++) {
                ans = ans.add(new BigInteger(br.readLine()));
            }
            if (ans.compareTo(BigInteger.ZERO) == -1) {
                sb.append("-");
            } else if (ans.compareTo(BigInteger.ZERO) == 1) {
                sb.append("+");
            } else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
