package Baekjoon.정렬;
import java.util.*;
import java.io.*;

class P23056 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<info> blue = new ArrayList<>();
        ArrayList<info> white = new ArrayList<>();
        int[] count = new int[n+1];

        while (true) {
            st = new StringTokenizer(br.readLine()," ");
            int c = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (c == 0 && name.equals("0")) break;
            else {
                if (c % 2 != 0 && count[c] < m) {
                    blue.add( new info(c,name));
                    count[c]++;
                } else if (c % 2 == 0 && count[c] < m) {
                    white.add(new info(c,name));
                    count[c]++;
                }
            }
        }

        Collections.sort(blue);
        Collections.sort(white);

        for (int i=0; i<blue.size(); i++) {
            sb.append(blue.get(i).num + " " + blue.get(i).name).append("\n");
        }
        for (int i=0; i< white.size(); i++) {
            sb.append(white.get(i).num + " " + white.get(i).name).append("\n");
        }
        System.out.println(sb);
    }    
}

class info implements Comparable<info>  {
    int num;
    String name;

    public info(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public int compareTo(info o) {
        if (this.num == o.num && this.name.length() == o.name.length()) {
            return this.name.compareTo(o.name);
        } else if (this.num == o.num) {
            return this.name.length() - o.name.length();
        } return this.num - o.num;
    }
}