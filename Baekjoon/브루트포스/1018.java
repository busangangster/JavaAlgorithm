package Baekjoon.브루트포스;
import java.util.*;
import java.io.*;

class P1018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Character[][] arr = new Character[N][M];
        int min_v = Integer.MAX_VALUE;

        for (int i=0; i< N;i++) {
            String s = br.readLine();
            for (int j=0; j<M;j++) {
                arr[i][j] = s.charAt(j);
            }
        }


        for (int i=0; i<N-7;i++) {
            for (int j = 0; j< M-7;j++) {
                int Wcnt = 0;
                int Bcnt = 0;
                for (int n=i;n<i+8;n++) {
                    for (int m=j;m<j+8;m++) {
                        if (arr[n][m] == 'W') {
                            Wcnt++;
                        }
                        else if (arr[n][m] == 'B') {
                            Bcnt++;
                        }
                    }
                }
                System.out.println(Wcnt);
                System.out.println(Bcnt);
                // System.out.println(min_v);
                System.out.println(Math.abs(Wcnt-Bcnt));
                min_v = Math.min(min_v,Math.abs(Wcnt-Bcnt)-1);
            }
        }

        System.out.println(min_v);

    }
}
