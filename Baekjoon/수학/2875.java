package Baekjoon.수학;
import java.io.*;
import java.util.*;

class P2875 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int w_t = w/2;
        int m_t = m/1;
        int contest= Math.min(w_t,m_t);

        m = m - contest*2;
        w = w - contest;

        k = (k - (m+w));

        if (k <=0 ) {
            sb.append(contest);
        }
        else {
            if (k % 3==0) {
                contest -= k /3;
            }
            else {
                contest -= (k/3 + 1);
            }
            sb.append(contest);
        }
        System.out.println(sb);

    }
}
