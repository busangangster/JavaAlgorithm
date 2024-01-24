
import java.util.*;
import java.io.*;
class prac {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i=0; i<n;i++) {
            hm.put(st.nextToken(),0);
        }
        
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            while (st.hasMoreTokens()) {
                String k = st.nextToken();
                hm.put(k,hm.get(k)+1);
            }
        }

        List<String> list = new ArrayList<>(hm.keySet());

        Collections.sort(list,(o1,o2)-> {
            if (hm.get(o1) - hm.get(o2) == 0) { // 인기도가 같은 경우
                // compareTo는 문자열을 비교할 때, 
                // return o1.compareTo(o2); // compareTo는 1,0,-1리턴하는 거 아님 ?
                return hm.get(o1) - hm.get(o2); //틀림 
            } else { // 다른경우 key 기준 내림차순 
                return hm.get(o2) - hm.get(o1);
            }
        });

        for (String key: list) {
            System.out.println(key + " " + hm.get(key));
        }
    }
}