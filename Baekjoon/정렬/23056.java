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
        String[][] blue = new String[5000][2];
        String[][] red = new String[5000][2];

        HashMap<Integer,Integer> map = new HashMap<>();
        
        int b = 0;
        int r = 0;
        while (true) {
            st = new StringTokenizer(br.readLine()," ");
            // ArrayList<String> tmp = new ArrayList<String>();
            String c = st.nextToken();
            String s = st.nextToken();
            if (c.equals("0") && s.equals("0")) break;
            else {
                int cc = Integer.parseInt(c);
                map.put(cc,map.getOrDefault(cc, 0)+1);
                if (cc % 2==0) {
                    if (map.get(cc) > m) {
                        continue;
                    } else {
                        red[r][0] = c;
                        red[r][1] = s;
                    };
                    r++;
                } else {
                    if (map.get(cc) > m) {
                        continue;
                    } else {
                        blue[b][0] = c;
                        blue[b][1] = s;
                    }
                    b++;
                }
            }

        }

        Arrays.sort(blue,(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0] != null) {
                    if (o1[0].equals(o2[0]) && o1[1].length() == o2[1].length()) {
                        return o1[1].compareTo(o2[1]);
                    } else if (o1[0].equals(o2[0])) {
                        return o1[1].length() - o2[1].length();
                    }
                } else return 0;
                return o1[0].compareTo(o2[0]);
            }
        }));

        Arrays.sort(red,(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0] != null) {
                    if (o1[0].equals(o2[0]) && o1[1].length() == o2[1].length()) {
                        return o1[1].compareTo(o2[1]);
                    } else if (o1[0].equals(o2[0])) {
                        return o1[1].length() - o2[1].length();
                    }
                } else return 0;
                return o1[0].compareTo(o2[0]);
            }
        }));

        for (int i=0;i<5000;i++) {
            if (blue[i][0] != null) {
                sb.append(blue[i][0]+" "+blue[i][1]).append("\n");
            } else {
                break;
            }
        }

        for (int j=0;j<5000;j++) {
            if (red[j][0] != null) {
                sb.append(red[j][0]+" "+red[j][1]).append("\n");
            } else {
                break;
            }
        }
        // System.out.println(Arrays.deepToString(blue));
        // System.out.println(Arrays.deepToString(red));

        System.out.println(sb);
    }    
}