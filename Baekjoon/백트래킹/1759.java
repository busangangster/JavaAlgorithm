import java.util.*;
import java.io.*;

class Main {
   static int L,C;
   static char[] alpha;
   static char[] ans;
   static StringBuilder sb = new StringBuilder();

 public static void main(String[] args) throws Exception{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st;

   st = new StringTokenizer(br.readLine());
   L = Integer.parseInt(st.nextToken());
   C = Integer.parseInt(st.nextToken());

   alpha = new char[C];
   ans = new char[L];

   st = new StringTokenizer(br.readLine());
   for (int i=0; i<C;i ++) {
      alpha[i] = st.nextToken().charAt(0);
   }

   Arrays.sort(alpha);
   DFS(0,0);
   System.out.println(sb);
 }

 public static void DFS(int cnt, int start) {
   if (cnt == L) {
      if (check(ans)) {
         for (int i=0; i< ans.length; i++) {
            sb.append(ans[i]);
         }
         sb.append("\n");
      }
      return;
   }

   for (int i=start; i<C; i++) {
      ans[cnt] = alpha[i];
      DFS(cnt+1,i+1);
   }
 }

 public static boolean check( char[] x) {
   int mo = 0;
   int ja = 0;

   for (int i=0; i<x.length; i++) {
      if (x[i] == 'a' || x[i] == 'e' || x[i] == 'i' || x[i] == 'o' || x[i] == 'u') {
         mo++;
      }
      else {
         ja++;
      }
   }
   if (mo >= 1 && ja >= 2) return true;
   else return false;

 }
}
