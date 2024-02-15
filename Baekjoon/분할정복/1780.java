package Baekjoon.분할정복;
import java.io.*;
import java.util.*;

class P1780 {
    static int N,minus,zero,one;
    static int[][] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        minus = 0;
        zero = 0;
        one = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0,0,N);
        sb.append(minus).append("\n").append(zero).append("\n").append(one);
        System.out.println(sb);

    }

    public static void solution(int x, int y, int size) {
        if (check(x,y,size)) {
            if (arr[x][y] == -1) minus++;
            else if (arr[x][y] == 0) zero++;
            else if (arr[x][y] == 1) one++;
            return;
        }

        int newSize = size / 3;

        solution(x, y, newSize);
        solution(x, y+newSize, newSize);
        solution(x, y+newSize*2, newSize);

        solution(x+newSize, y, newSize);
        solution(x+newSize, y+newSize, newSize);
        solution(x+newSize, y+newSize*2, newSize);

        solution(x+newSize*2, y, newSize);
        solution(x+newSize*2, y+newSize, newSize);
        solution(x+newSize*2, y+newSize*2, newSize);

    }

    public static boolean check(int x, int y, int size) {
        int num = arr[x][y];

        for (int i=x; i< x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (arr[i][j] != num) return false;
            }
        }
        return true;
    }
}
