package Baekjoon.기하학;
import java.io.*;
import java.util.*;

class P27323 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        sb.append(a*b);
        System.out.println(sb);
    }
}
