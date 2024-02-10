package Baekjoon.구현;
import java.io.*;

class P1668 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int left = 1;
        int right = 1;
        for (int i=0; i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int l_tmp = arr[0];

        for (int i=1; i<n;i++) {
            if (arr[i] > l_tmp) {
                left++;
                l_tmp = arr[i];
            }
        }
        sb.append(left).append("\n");

        int r_tmp = arr[n-1];
        for (int i = n-2; i >=0; i--) {
            if (arr[i] > r_tmp) {
                right++;
                r_tmp = arr[i];
            }
        }
        sb.append(right);
        System.out.println(sb);

    }
}
