package Baekjoon.정렬;
import java.util.*;
import java.io.*;

class P22232 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<> arr = new ArrayList<>();

        for (int i=0; i<n;i++) {
            String[] s = br.readLine().split("\\.");
            System.out.println(Arrays.toString(s));
            // System.out.println( s);
        }
    }    
}

class info implements Comparable<info> {
    String name;
    String extension;

    public info (String name, String extension) {
        this.name = name;
        this.extension = extension;

    }
        @Override
        public int compareTo(info o) {
            if (this.name.equals(o.name) && this.extension.equals(o.extension)) {
                return this.extension.compareTo(o.extension);
            } else if  (this.name.equals(o.name)) {
                return 
            }
        }

    
}
